package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoPrintAlTabs {
	
	@Test
	public void testPrintValues() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.cssSelector("[aria-label=\"Search\"]")).sendKeys("sasi");
		
		
		List<WebElement> li = driver.findElements(By.cssSelector("[role=\"listbox\"] li"));
		
		for(WebElement we : li) {
			String value = we.getText();
			System.out.println("value : "+value);
		}
		
		
	}

}
