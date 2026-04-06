package com.scereenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DemoScreenshot {

	@Test
	public void testScreenShotWebElement() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg");

	
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();
		
		WebElement getStartedBtn_ele = driver.findElement(By.linkText("Get Started"));
		
		
		File source = getStartedBtn_ele.getScreenshotAs(OutputType.FILE);

		// 3. Save the file to your desired destination
		File destination = new File(".//Screenshots//element_screenshot.png");
		FileUtils.copyFile(source, destination);
		
		
		
	}
	
	@Test
	public void testPageScreenShot() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg");

	
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();
		
		WebElement getStartedBtn_ele = driver.findElement(By.linkText("Get Started"));
		
		
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		// 3. Save the file to your desired destination
		File destination = new File(".//Screenshots//page_screenshot.png");
		FileUtils.copyFile(source, destination);
		
		
		
	}

}
