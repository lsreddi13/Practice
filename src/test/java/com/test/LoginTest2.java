package com.test;

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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

public class LoginTest2 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://commercial.policybazaar.com/");
	}

	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.test.DemoReadDataFromXLS.class)
	public void testLoginDATAPROVIDER(String vehicleNum) throws InterruptedException, IOException {

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.name("carno")));
		
		
		driver.findElement(By.name("carno")).clear();
		driver.findElement(By.name("carno")).sendKeys(vehicleNum);
		driver.findElement(By.xpath("//button[contains(@class, 'viewPrice')]")).click();


//			String vehicleName = wait.until(
//					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'vehcileName')]")))
//					.getText();
		
		
		List<WebElement> errorMsg = driver.findElements(
		        By.xpath("//div[contains(@class,'text-danger')]"));

		if (!errorMsg.isEmpty() && errorMsg.get(0).isDisplayed()) {
			System.out.println("error displayed : "+vehicleNum);
		    throw new SkipException("Skipping test due to invalid registration number message.");
		}else {
		
			try {
			String vehicleType = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='listedDetails']/li[2]/div/p")))
					.getText();
			
			if (vehicleType.equalsIgnoreCase("Truck")) {
				takeScreenshot(driver, vehicleNum, "truck");
				System.out.println(vehicleNum);
			} else {

				takeScreenshot(driver, vehicleNum, vehicleType);
				System.out.println(vehicleNum);
			}
			}catch (TimeoutException e)  {
				// TODO: handle exception
				System.out.println("page not loaded : "+vehicleNum);
			}
			driver.navigate().back();
		}
			
			
			

	}

	

	public static void takeScreenshot(WebDriver driver, String filename, String storePlace) throws IOException {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,
				new File(System.getProperty("user.dir") + "//screenshots//" + storePlace + "//" + filename + ".png"));
	}

	
	

}
