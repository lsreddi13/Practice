package com.propertiesTestData;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DempProperties {
	WebDriver driver;
	Properties prop;

	@Test
	public void test() throws IOException {
		prop = new Properties();
		prop.load(new FileInputStream("src/test/java/com/propertiesTestData/test.properties"));

		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")){
			driver = new EdgeDriver();
		}
		
		
		driver.get(prop.getProperty("appURL"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		

		String u_name = prop.getProperty("username");
		enterName(driver, u_name);

	}
	
	public void closePopup(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();
	}
	
	@Test
	public void test2() throws IOException {
		 prop = new Properties();

		prop.load(new FileInputStream("src/test/java/com/propertiesTestData/test2.properties"));
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")){
			driver = new EdgeDriver();
		}
		
		driver.get(prop.getProperty("appURL"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();

		String u_name = prop.getProperty("username");
		enterName(driver, u_name);

	}

	public void enterName(WebDriver driver, String a) {
		WebElement e_name_ele = driver.findElement(By.name("name"));
		String placeHolderText = e_name_ele.getAttribute("placeholder");
		System.out.println(placeHolderText);
		e_name_ele.sendKeys(a);

	}

}
