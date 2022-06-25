package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartObjects {
	
	public WebDriver driver;
	
	By productName = By.xpath("//a[@class='_2Kn22P gBNbID']");
	
	By placeOrder = By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']");
	
	By emptyCart = By.xpath("//div[@class='_1LCJ1U']");
	
	
	public CartObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
	}

	public WebElement getPlaceOrder() {
		
		return driver.findElement(placeOrder);
	}
	
	public WebElement getemptyCart() {
		return driver.findElement(emptyCart);
	}
	
	public WebElement getProductName() {
		return driver.findElement(productName);
	}
	
	

}
