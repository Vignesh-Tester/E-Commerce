package Project.E_Commerce;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CartObjects;
import pageObjects.CheckoutPage;
import pageObjects.DesiredProduct;
import pageObjects.HomePage;
import pageObjects.LoginForm;
import pageObjects.flipkartProductDetails;
import resources.Base;

public class ProductDetails extends Base {

	
	@BeforeMethod()

	public void Initializebrowser() throws IOException {

	
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Parameters({ "searchText", "Sheetname", "path" })
	@Test
	public void outputAllProducts(String searchText, String Sheetname, String path) throws IOException {

		// creating an object and invoking it

		LoginForm lf = new LoginForm(driver);
		flipkartProductDetails pl = new flipkartProductDetails(driver);
		HomePage hp = new HomePage(driver);

		// close the login form
		lf.getCloseForm().click();

		// go to search bar and enter mobile phone
		hp.getSearchBar().sendKeys(searchText);
		hp.getSearchButton().click();

		int productCount = pl.getProductName().size();
		int columnCount = 0;
		try (XSSFWorkbook workbook = new XSSFWorkbook()) {
			XSSFSheet sheet = workbook.createSheet(Sheetname);

			for (int i = 0; i < productCount; i++) {

				XSSFRow row = sheet.createRow(i);
				XSSFCell cell = row.createCell(columnCount);
				String productName = pl.getProductName().get(i).getText();
				String productPrice = pl.getProductPrice().get(i).getText();
				System.out.println("Product Name is " + productName + "&" + " Price is " + productPrice);
				cell.setCellValue("Product Name is " + productName + "&" + " Price is  " + productPrice);
			}

			FileOutputStream fos = new FileOutputStream(path);
			workbook.write(fos);
		}

		System.out.println("success");
	}

	@Parameters({ "regUserName", "regPassword", "productSearch", "desiredProduct", "name", "phoneNumber", "pincode",
			"area", "address" })
	@Test
	public void addProductToCheckout(String regUserName, String regPassword, String productSearch, String desiredProduct,
			String name, String phoneNumber, String pincode, String area, String address)
			throws IOException, InterruptedException {

		// creating an object and invoking it
		LoginForm lf = new LoginForm(driver);
		flipkartProductDetails pl = new flipkartProductDetails(driver);
		HomePage hp = new HomePage(driver);
		DesiredProduct dp = new DesiredProduct(driver);
		CartObjects co = new CartObjects(driver);
		CheckoutPage cp = new CheckoutPage(driver);

		// Enter the credentials in login form
		lf.getUsername().sendKeys(regUserName);
		lf.getPassword().sendKeys(regPassword);
		lf.getSubmit().click();
		driver.navigate().refresh();
		String value = hp.getSuccessfulLogin().getText();

		// Verify that Login is changed to account
		String expValue = "My Account";
		Assert.assertEquals(value, expValue);

		// Go to Search Bar and search the product
		hp.getSearchBar().sendKeys(productSearch);
		hp.getSearchButton().click();

		// Store the Webelement and iterate over it to get the desired product using for
		// loop
		List<WebElement> productDesired = pl.getProductName();
		for (int i = 0; i < productDesired.size(); i++) {
			// get the name of the product using i
			String getProduct = productDesired.get(i).getText();
			// use contains and click the desired product
			if (getProduct.contains(desiredProduct)) {
				pl.getProductName().get(i).click();
			}

		}

		// The selected product will be opened in new tab.
		// Use Window handles to to move the driver object from parent window to child
		// window using iterator concept
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);

		// verify the pagr url
		String actualUrl = driver.getTitle();
		String expectedUrl = "Buy Apple iPhone 12 ( 64 GB Storage) Online at Best Price On Flipkart.com";
		Assert.assertEquals(actualUrl, expectedUrl);

		// Go to cart and verify that the cart is empty
		dp.getcartIcon().click();
		String cartText = co.getemptyCart().getText();
		String Expected = "Your cart is empty!";
		Assert.assertEquals(cartText, Expected);

		// Go back to product page and add the product to cart
		driver.navigate().back();
		dp.getAddToCart().click();

		// go back again too check whether the "ADD TO CART" is Changed to "GO TO CART"
		// to verify that the product is added to cart
		co.getProductName().click();
		String actualtext = dp.getAddToCart().getText();
		String expectedText = "GO TO CART";
		Assert.assertEquals(actualtext, expectedText);

		// go to cart and place the order
		dp.getcartIcon().click();
		co.getPlaceOrder().click();

		// Enter the required details to get to payment section
		cp.getName().sendKeys(name);
		cp.getPhone().sendKeys(phoneNumber);
		cp.getPincode().sendKeys(pincode);
		cp.getLocality().sendKeys(area);
		cp.getAddress().sendKeys(address);
		cp.getSaveAndDeliver().click();
		Thread.sleep(2000);
		cp.getContinue().click();
		cp.getAcceptAndContinue().click();

		// verify that the checkout is validated by checking the UPI ID is enabled
		cp.getPaymentSection().isSelected();

		// switch to parent ID
		driver.switchTo().window(parentID);

		
	}
}
