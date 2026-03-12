package com.test;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoPageTitle {
	@Test(enabled = false)
	public void printPageTitle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		String pageTitle = driver.getTitle();
		System.out.println("pageTitle : "+pageTitle);
		driver.close();
	}
	@Test(enabled = false)
	public void getCurrentUrl() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
//		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("currentUrl : "+currentUrl);
		driver.findElement(By.id("small-searchterms")).sendKeys("computer");
		driver.findElement(By.className("search-box-button")).click();
		String currentUrl2 = driver.getCurrentUrl();
		System.out.println("currentUrl2 : "+currentUrl2);
	}
	

	@Test
	public void testFullScreen() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().window().minimize();
			
		
	}

//	@Test
//	public void testMaxWindow() {
//		
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://demo.nopcommerce.com/");
//		driver.manage().window().maximize();
//		
//			
//		
//	}
	
	
}
