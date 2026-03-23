package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

	
	@Test
	public void test() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.fb.com");
		
		Thread.sleep(3000);
		
//		driver.findElement(By.cssSelector("#_r_2_")).sendKeys("sdafdafds");
		driver.findElement(By.xpath("//input[starts-with(@id,'_R_')]")).sendKeys("sdafdafds");
		
		
		
		//id usage directly
WebElement id= 		driver.findElement(By.id("small-searchterms"));

WebElement xpathID=driver.findElement(By.xpath("//input[@id='small-searchterms']"));

WebElement xpathPlaceHolder = driver.findElement(By.xpath("//input[@placeholder='Search store']"));

WebElement cssId = driver.findElement(By.cssSelector("input#small-searchterms"));

WebElement cssClass1 = driver.findElement(By.cssSelector("input.search-box-text"));

WebElement cssClass2 = driver.findElement(By.cssSelector(".search-box-text"));


WebElement cssClass3 = driver.findElement(By.cssSelector("input.search-box-text.ui-autocomplete-input"));


WebElement cssClass4 = driver.findElement(By.cssSelector("input.search-box-text.ui-autocomplete-input"));


driver.findElement(By.cssSelector("[name='q']"));


driver.findElement(By.cssSelector("input[name='q']"));

driver.findElement(By.cssSelector("tagname[attributename='attributeValue']"));





	}
}
