package com.test.waits;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PageLoadTimeOut {

	String apURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@Test
	public void testWaitExplicit() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.get(apURL);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");

	}

}
