package com.javaScriptExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoJavaScriptExecutor {

	// scroll the page till bottom of the page
	// click on FAQ's + in the first question
	// validate the text.

	// open browser

	// open application

	// scroll the page till faqs

	// click + for first question

	// get the text

	// compare or valdiate text

//	@Test
	public void testJSE() {
		
		
			
			
		String expected_Text="Vidyamandir Classes offers a franchise model that allows entrepreneurs to operate educational coaching centers under the established VMC brand, specializing in IIT-JEE, NEET, and foundational courses for students in grades 6-12.";
		

		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();
		

		WebElement faq1_ele = driver.findElement(
				By.xpath("//button[contains(text(), 'What is the Vidyamandir Classes (VMC) franchise opportunity?')]"));

	
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		js.executeScript("arguments[0].scrollIntoView(true);", faq1_ele);
		
		faq1_ele.click();
		
		String actualText = driver.findElement(By.xpath("//button[contains(text(), 'What is the Vidyamandir Classes (VMC) franchise opportunity?')]/following-sibling::div/p")).getText();
	
		
		
		
		Assert.assertEquals(actualText, expected_Text);
		
	}
	
	@Test
	public void testJSE2() {
		
		String expected_Text="Vidyamandir Classes offers a franchise model that allows entrepreneurs to operate educational coaching centers under the established VMC brand, specializing in IIT-JEE, NEET, and foundational courses for students in grades 6-12.";
		

		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();
		

		WebElement faq1_ele = driver.findElement(
				By.xpath("//button[contains(text(), 'What is the Vidyamandir Classes (VMC) franchise opportunity?')]"));

	
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,1500)", "");
		js.executeScript("window.scrollBy(0,1500)", "");
		js.executeScript("window.scrollBy(0,500)", "");
		
		
		faq1_ele.click();
		
		String actualText = driver.findElement(By.xpath("//button[contains(text(), 'What is the Vidyamandir Classes (VMC) franchise opportunity?')]/following-sibling::div/p")).getText();
	
		
		
		
		Assert.assertEquals(actualText, expected_Text);
		
	}

}
