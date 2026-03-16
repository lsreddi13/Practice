package com.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginTest3 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://commercial.policybazaar.com/");
	}

	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.tests.DemoReadDataFromXLS.class)
	public void testLoginDATAPROVIDER(String vehicleNum) throws InterruptedException, IOException {

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.name("carno")));
		
		
		driver.findElement(By.name("carno")).clear();
		driver.findElement(By.name("carno")).sendKeys(vehicleNum);
		driver.findElement(By.xpath("//button[contains(@class, 'viewPrice')]")).click();


			String vehicleName = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'vehcileName')]")))
					.getText();
			if (vehicleName.equals("Truck")) {
				takeScreenshot(driver, vehicleNum, "truck");
			} else {

				takeScreenshot(driver, vehicleNum, "nonTruck");
			}
			System.out.println(vehicleNum);
			driver.navigate().back();
			

	}

	

	public static void takeScreenshot(WebDriver driver, String filename, String storePlace) throws IOException {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,
				new File(System.getProperty("user.dir") + "//screenshots//" + storePlace + "//" + filename + ".png"));
	}

	
	

}
