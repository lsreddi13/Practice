package com.test.buttons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.Utils;

public class DemoButtons extends Utils{
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void testButtons() {
		
		String doubleClickBtnText = "Double Click Me";
		
		String rightClickBtnText = "Right Click Me";
		String clickBtnText = "Click Me";
		
		driver.get("https://demoqa.com/buttons");
		WebElement doubleClick_ele = driver.findElement(By.id("doubleClickBtn"));
		
		WebElement rightClick_ele = driver.findElement(By.id("rightClickBtn"));
		
		WebElement clickMe_ele = driver.findElement(By.xpath("//*[@id='rightClickBtn']/../following-sibling::div/button"));
		
		
		
		Assert.assertEquals(getTextWebElement(driver, doubleClick_ele), doubleClickBtnText);
		Assert.assertEquals(getTextWebElement(driver, rightClick_ele), rightClickBtnText);
		Assert.assertEquals(getTextWebElement(driver, clickMe_ele), clickBtnText);
		
		
	}
	
	
	
	
	

}
