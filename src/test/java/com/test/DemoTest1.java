package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTest1 {
	
	@Test
	public void test1() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.findElement(By.xpath("//a[text()='Electronics']")).click();
		
		String expectedLabel = "Electronics";
		
		String actualLAbel = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualLAbel, expectedLabel, "page label does not matched.");
	
		
		List<WebElement> li1 = driver.findElements(By.xpath("//div[@class='item-box']//h2"));
		System.out.println(li1.size()+" : number of items count");
		
		List<String> productTitle1 = new ArrayList<>();
		for(WebElement we : li1) {
//			System.out.println(we.getText());
			
			productTitle1.add(we.getText());
		}
		
		for(String title : productTitle1) {
			System.out.println(title);
			
			
		}
		
		driver.findElement(By.cssSelector("h2 a[title='Show products in category Camera & photo']")).click();
		
		
//		String x1 = driver.findElement(By.xpath("(//div[@class='item-box']//h2)[1]")).getText();
//		String x2 = driver.findElement(By.xpath("(//div[@class='item-box']//h2)[2]")).getText();
//		String x3 = driver.findElement(By.xpath("(//div[@class='item-box']//h2)[3]")).getText();
		
		
//		WebElement el1 = driver.findElement(By.xpath("(//div[@class='item-box']//h2)[1]"));
//		WebElement el2 = driver.findElement(By.xpath("(//div[@class='item-box']//h2)[2]"));
//		WebElement el3 = driver.findElement(By.xpath("(//div[@class='item-box']//h2)[3]"));
		Thread.sleep(3000);
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='item-box']//h2"));
		System.out.println(li.size()+" : number of items count");
		
		List<String> productTitle = new ArrayList<>();
		for(WebElement we : li) {
//			System.out.println(we.getText());
			
			productTitle.add(we.getText());
		}
		
		for(String title : productTitle) {
			System.out.println(title);
			
			
		}
		
	}

}
