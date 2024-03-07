package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By user= By.id("email1");
	By pass= By.id("password1");
	By login = By.xpath("//button[text()='Sign in']");
	
	public void loginToApp(String userName, String password) {
		driver.findElement(user).sendKeys(userName);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(login).click();
	}
}
