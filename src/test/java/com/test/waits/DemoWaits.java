package com.test.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoWaits {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		

	}

	@Test
	public void testWaits1() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("username"))));
		wait.until(ExpectedConditions.alertIsPresent());
		
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

	}

	@Test
	public void testWaits2() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

	}
}
