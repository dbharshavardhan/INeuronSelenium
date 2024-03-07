package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;


public class LoginTest extends BaseClass {
	
	@Test(dataProvider = "LoginDetails", dataProviderClass = CustomDataProvider.class)
	public void loginToApp(String userName, String password) 
	{
		LoginPage login = new LoginPage(driver);
		login.loginToApp(userName, password);
		System.out.println("Login Successful");
		System.out.println("Login app");
		
	
	}
}
