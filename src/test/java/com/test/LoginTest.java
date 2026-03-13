package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	// orange hrm
	String app_url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	WebDriver driver;

	@Test
	public void testLogin() throws InterruptedException {

		driver = new ChromeDriver();
		driver.get(app_url);

		String expectedUserNamePlaceHolderText = "Username";
		String expectedPasswordPlaceHolderText = "Password";
		
		String u_name= "Admin";
		String pwd = "admin123";

		Thread.sleep(5000);
		// create web element for user name input
		WebElement username_ele = driver.findElement(By.name("username"));
		
		
		
		
		
		// create web element for password input
		WebElement password_ele = driver.findElement(By.name("password"));
		//Create Web element for loginButton
		WebElement loginBtn_ele = driver.findElement(By.className("orangehrm-login-button"));

		// check the placeholder text for user name input
		String actualUserNamePlaceHolderText = username_ele.getAttribute("placeholder");
		Assert.assertEquals(actualUserNamePlaceHolderText, expectedUserNamePlaceHolderText,
				"Expected username placeholder text does not displayed.");

		// enter user name
		username_ele.sendKeys(u_name);

		// check place holder text for password input
		String actualPasswordPlaceHolderText = password_ele.getAttribute("placeholder");
		Assert.assertEquals(actualPasswordPlaceHolderText, expectedPasswordPlaceHolderText,
				"Expected password placeholder text does not displayed.");
		
		//enter password
		password_ele.sendKeys(pwd);
		loginBtn_ele.click();
		
		
		Thread.sleep(5000);
		//create web element for user profile icon
		WebElement profileIcon_ele = driver.findElement(By.className("oxd-userdropdown-name"));
		
		//click profile icon
		profileIcon_ele.click();
		
		//create webelement for logout option
		WebElement logout_ele = driver.findElement(By.xpath("//ul[@role=\"menu\"]/li[4]"));
		
		//click logout 
		logout_ele.click();
		

	}

}