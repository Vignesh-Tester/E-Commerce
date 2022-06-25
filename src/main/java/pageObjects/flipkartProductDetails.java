package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class flipkartProductDetails {

	public WebDriver driver;
	By productName = By.xpath("//div[@class='_4rR01T']");
	By productPrice = By.xpath("//div[@class='_30jeq3 _1_WHN1']");

	public flipkartProductDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}


	 public List<WebElement> getProductName() { 
		 return
	             driver.findElements(productName); }
	 
	 
	 public List<WebElement> getProductPrice() { 
		 return
	 driver.findElements(productPrice); }

}
