package com.test.Webtables;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoWebTables2 extends Utils{

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void pageTest() {

		driver.get("https://demoqa.com/webtables");
		clickShowPageNumberList();
		List<WebElement> pageOptions = 
		driver.findElements(By.cssSelector("select.form-control > option"));
		
		getListNames_Css("select.form-control > option", driver);
		

	}
	
	public void clickShowPageNumberList()
	{
		WebElement show_ele = driver.findElement(By.cssSelector("select.form-control"));
		show_ele.click();
		
		
	}
	
	

}
