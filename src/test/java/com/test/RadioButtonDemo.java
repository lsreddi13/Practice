package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonDemo {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		 driver = new ChromeDriver();
	}
	@Test
	public void test() {
		
		driver.get("https://demoqa.com/radio-button");
		
		
			WebElement yesRadioBtn_ele = driver.findElement(By.id("yesRadio"));
			
			WebElement impressiveRadioBtn_ele = driver.findElement(By.id("impressiveRadio"));
			WebElement NoRadioBtn_ele = driver.findElement(By.id("noRadio"));
			
			
			boolean yesRadioStatus = yesRadioBtn_ele.isSelected();
			System.out.println("before clicking  : "+yesRadioStatus);
			
			yesRadioBtn_ele.click();
			
			boolean yesRadioStatus2 = yesRadioBtn_ele.isSelected();
			System.out.println("after clicking : "+yesRadioStatus2);
			
			impressiveRadioBtn_ele.click();
			
			boolean yesRadioStatus3 = yesRadioBtn_ele.isSelected();
			System.out.println("after clicking impressive yes button status : "+yesRadioStatus3);
			
			boolean impButtonStatus = impressiveRadioBtn_ele.isSelected();
			System.out.println("after clicking impressive impButtonStatus   : "+impButtonStatus);
	}

}
