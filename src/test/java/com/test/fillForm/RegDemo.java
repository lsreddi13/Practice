package com.test.fillForm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RegDemo {

	@Test
	public void test() {

		WebDriver driver = new ChromeDriver();

		String url = "https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg";

		driver.get(url);

		// validate input box placeholder text in the reg page.

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();
		
		
		WebElement name_ele = driver.findElement(By.name("name"));
		WebElement email_ele = driver.findElement(By.name("email"));
		

		String nameplaceHolder = name_ele.getAttribute("placeholder");
		name_ele.sendKeys("sasidhar");
		
		 

		String emailValue = email_ele.getAttribute("placeholder");
		email_ele.sendKeys("sasidhar@gmail.com");

		String mobileValue = driver.findElement(By.name("mobile")).getAttribute("placeholder");

		String selectStateValue = driver.findElement(By.name("state")).getAttribute("id");

		String selectStateValueMethod2 = driver.findElement(By.name("state")).getText();

		String selectCityValue = driver.findElement(By.name("city")).getAttribute("id");

		String selectCityValueMethod2 = driver.findElement(By.name("city")).getText();
		
		String profressionValue = driver.findElement(By.name("profession")).getAttribute("placeholder");
		
		String timeValue = driver.findElement(By.name("time")).getAttribute("id");
		
		String timeValueMethod2 = driver.findElement(By.name("time")).getText();
		
		
		
		
		System.out.println(nameplaceHolder);
		System.out.println(emailValue);
		System.out.println(mobileValue);
		System.out.println(selectStateValue);
		System.out.println(selectStateValueMethod2);
		System.out.println(selectCityValue);
		System.out.println(selectCityValueMethod2);
		System.out.println(profressionValue);
		System.out.println(timeValue);
		System.out.println(timeValueMethod2);
		
		
		

	}

}
