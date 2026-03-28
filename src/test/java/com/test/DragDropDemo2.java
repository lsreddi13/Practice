package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragDropDemo2 {
	
	
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		 driver = new ChromeDriver();
	}
	
	
	@Test
	public void test() {
		
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		
		WebElement source = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement destination = driver.findElement(By.xpath("//*[@id='droppable']"));
		
		
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, destination).build().perform();
		
	}
	
	
	@Test
	public void test2() {
		
		
		driver.navigate().to("https://dhtmlx.com/docs/products/dhtmlxTree/");
		
		driver.manage().window().maximize();
		 driver.switchTo().frame(0);
		// find element which we need to drag
				WebElement source=driver.findElement(By.xpath("(//span[text()='Thrillers'])[1]"));
				
				WebElement destination=driver.findElement(By.xpath("(//span[text()='History'])[1]"));
		
		
		Actions ac = new Actions(driver);
//		ac.clickAndHold(source).pause(2000).moveToElement(destination).release().build().perform();
		ac.dragAndDrop(source, destination).build().perform();
		
	}

}
