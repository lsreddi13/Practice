package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxDemo {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		 driver = new ChromeDriver();
	}
	@Test
	public void test() {
		
		driver.get("https://demoqa.com/checkbox");
		
		
		WebElement  homeCheckBox_ele = driver.findElement(By.xpath("//span[@aria-label=\"Select Home\"]"));
		
		//check the checkbox status, if it is not selected then only go and select checkbox
		
		String currentStatusValue = homeCheckBox_ele.getAttribute("aria-checked");
		System.out.println("currentStatusValue : " + currentStatusValue);
		
		if(currentStatusValue.equals("false")) {
			homeCheckBox_ele.click();
		}
		String afterseelcting = homeCheckBox_ele.getAttribute("aria-checked");
		
		System.out.println("afterseelcting : " + afterseelcting);
		
		String currentStatusValue2 = homeCheckBox_ele.getAttribute("aria-checked");
		if(currentStatusValue2.equals("true")) {
			homeCheckBox_ele.click();
		}
		
		String onceagain = homeCheckBox_ele.getAttribute("aria-checked");
		System.out.println("once again after clicking  : " + onceagain);
		
	}

}
