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

public class VehicleDataTest3 {
	WebDriver driver;
	ExcelResultWriter ew;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://commercial.policybazaar.com/");
		ew = new ExcelResultWriter();
	}

	@Test(enabled = true, dataProvider = "getData", dataProviderClass = com.test.DemoReadDataFromXLS.class)
	public void testLoginDATAPROVIDER(String vehicleNum) throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("carno")));

		Thread.sleep(1000);
		driver.findElement(By.name("carno")).clear();
		Thread.sleep(1000);

		driver.findElement(By.name("carno")).sendKeys(vehicleNum);
		driver.findElement(By.xpath("//button[contains(@class, 'viewPrice')]")).click();
		Thread.sleep(3000);

//			String vehicleName = wait.until(
//					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'vehcileName')]")))
//					.getText();

		List<WebElement> errorMsg = driver.findElements(By.xpath("//div[contains(@class,'text-danger')]"));

		if (!errorMsg.isEmpty() && errorMsg.get(0).isDisplayed()) {
			System.out.println("error displayed : " + vehicleNum);
			throw new SkipException("Skipping test due to invalid registration number message.");
		} else {

			try {
				String vehicleType = wait
						.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//ul[@class='listedDetails']/li[2]/div/p")))
						.getText();
				Thread.sleep(3000);
				if (vehicleType.equalsIgnoreCase("Truck")) {
					takeScreenshot(driver, vehicleNum, "truck");
					ew.writeResult(vehicleNum, "truck");
					System.out.println(vehicleNum);
					Thread.sleep(2000);
					driver.navigate().back();
				} else {

					takeScreenshot(driver, vehicleNum, "nontruck");
					ew.writeResult(vehicleNum, "nontruck");
					System.out.println(vehicleNum);
					Thread.sleep(2000);
					driver.navigate().back();
				}
			} catch (TimeoutException e) {
				// TODO: handle exception
				System.out.println("page not loaded : " + vehicleNum);
				ew.writeResult(vehicleNum, "page not loaded");
				driver.navigate().back();
			}

		}

	}

	public static void takeScreenshot(WebDriver driver, String filename, String storePlace) throws IOException {
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,
				new File(System.getProperty("user.dir") + "//screenshots//" + storePlace + "//" + filename + ".png"));
	}

}