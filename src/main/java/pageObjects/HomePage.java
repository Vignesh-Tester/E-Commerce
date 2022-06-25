package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	
	By loginButton = By.xpath("//a[@class='_1_3w1N']");
	By searchBar = By.xpath("//input[@placeholder='Search for products, brands and more']");
	By searchSubmit = By.xpath("//button[@class='L0Z3Pu']");
	By afterLogin = By.xpath("//div[@class='_2Xfa2_']/div[3]/div/div/div/div");
	
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	

	public WebElement getSearchBar() {
		return driver.findElement(searchBar);
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(searchSubmit);
	}
	
	public WebElement getSuccessfulLogin() {
		return driver.findElement(afterLogin);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	

	
	
}
