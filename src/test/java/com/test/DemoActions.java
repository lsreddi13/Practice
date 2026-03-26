package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DemoActions {
	
	String appURL = "https://www.synechron.com/en-in/synechronlabs/agentic-accelerator#about-accelerators";
	
	
	@Test
	public void testActionsMoveToElement() {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(appURL);
		WebElement whoWeAreLabel_ele = driver.findElement(By.xpath("//div/a/span[text()='Who We Are']"));
		
		Actions ac = new Actions(driver);
		//IS IT INTERFACE OR CLASS - IS IT ACTIONS OR ACTION CLASS?
		
//		ac.moveToElement(whoWeAreLabel_ele).build().perform();
		
		ac.contextClick(whoWeAreLabel_ele).build().perform();
		
		/**
		
		String submenu_xpath = "//div/a/span[text()='Who We Are']/../following-sibling::div/div/ul/li";
		
		List<WebElement> li = driver.findElements(By.xpath(submenu_xpath));
		
		
		
		for(int i=0; i<li.size(); i++) {
			
			String submenuName = li.get(i).getText();
			System.out.println(submenuName);
		}


//		for(int i=0; i<7; i++) {
//			
//			String submenuName = li.get(i).getText();
//			System.out.println(submenuName);
//		}
		
		for(WebElement we :li) {
			
			
			String submenuName = we.getText();
			System.out.println(submenuName);
		}
		**/
		
		
//		task
		//int[] ar = {1,2,5,10,15};
		//print big value
		
		
	}

}

