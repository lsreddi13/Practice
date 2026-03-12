package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2 {

	
	@Test
	public void test() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.fb.com");
		//this is anotehr class
	}
}
