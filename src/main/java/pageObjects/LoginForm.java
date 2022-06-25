package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {

	public WebDriver driver;

	By username = By.xpath("//input[@class='_2IX_2- VJZDxU']");
	By password = By.xpath("//input[@type='password']");
	By submitLogin = By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']");
	By closeForm = By.xpath("//button[@class='_2KpZ6l _2doB4z']");

	public LoginForm(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getUsername() {

		return driver.findElement(username);

	}

	public WebElement getPassword() {

		return driver.findElement(password);

	}

	public WebElement getSubmit() {

		return driver.findElement(submitLogin);

	}

	public WebElement getCloseForm() {

		return driver.findElement(closeForm);

	}

}
