package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	public WebDriver driver;
	
	By enterName = By.xpath("//input[@name='name']");
	
	By enterPhone = By.xpath("//input[@name='phone']");
	
	By enterPincode = By.xpath("//input[@name='pincode']");
	
	By enterLocality = By.xpath("//input[@name='addressLine2']");
	
	By enterAddress = By.xpath("//textarea[@name='addressLine1']");
	
	By enterCity= By.xpath("//input[@name='city']");
	
	By enterState = By.xpath("//select[@name='state']");
	
	By saveAndDeliver = By.xpath("//button[@class='_2KpZ6l _1JDhFS _3AWRsL']");
	
	By emailId = By.xpath("//input[@placeholder='Enter your email ID']");
	
	By continueClick  = By.xpath("//button[text() = 'CONTINUE']");
	
	By closeForm = By.xpath("//button[@class='_2KpZ6l _1KAjNd']");
	
	By acceptandContinue = By.xpath("//button[@class='_2KpZ6l _1uR9yB _3dESVI']");
	
	By orderSummary = By.xpath("//div[@class='_2Kn22P']");
	
	By paymentWindow = By.xpath("//div[@class='_2nxZhC']/span");
	
	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}

	public WebElement getName() {
		return driver.findElement(enterName);
	}
	
	public WebElement getPhone() {
		return driver.findElement(enterPhone);
	}
	
	public WebElement getPincode() {
		return driver.findElement(enterPincode);
	}

	public WebElement getLocality() {
		return driver.findElement(enterLocality);
	}
	
	public WebElement getAddress() {
		return driver.findElement(enterAddress);
	}
	
	public WebElement getCity() {
		return driver.findElement(enterCity);
	}
	
	public WebElement getState() {
		return driver.findElement(enterState);
	}
	
	public WebElement getSaveAndDeliver() {
		return driver.findElement(saveAndDeliver);
	}
	
	public WebElement getEmailID() {
		return driver.findElement(emailId);
	}
	
	public WebElement getContinue() {
		return driver.findElement(continueClick);
	}
	
	public WebElement getAcceptAndContinue() {
		return driver.findElement(acceptandContinue);
	}
	
	public WebElement getOrderSummary() {
		return driver.findElement(orderSummary);
	}
	
	public WebElement getPaymentSection() {
		return driver.findElement(paymentWindow);
	}
}
