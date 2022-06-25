package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DesiredProduct {
	
	public WebDriver driver;
	By cartIcon = By.xpath("//a[@class='_3SkBxJ']");
	
	By addToCart = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	
	public DesiredProduct(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}

	public WebElement getcartIcon() {
		
		return driver.findElement(cartIcon);
	}
	
	public WebElement getAddToCart() {
		return driver.findElement(addToCart);
	}
}
