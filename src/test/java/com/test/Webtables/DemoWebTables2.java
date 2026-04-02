package com.test.Webtables;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utils.Utils;

public class DemoWebTables2 extends Utils {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void pageTest() {

		List<String> actualListNames = new ArrayList<>();

		List<String> expectedListNames = Arrays.asList("Show 10", "Show 20", "Show 30", "Show 40", "Show 50");

		driver.get("https://demoqa.com/webtables");
		clickShowPageNumberList();

		actualListNames = getListNames_Css("select.form-control > option", driver);

		
		Assert.assertEquals(actualListNames, expectedListNames);

		

	}

	public void clickShowPageNumberList() {
		WebElement show_ele = driver.findElement(By.cssSelector("select.form-control"));
		show_ele.click();

	}

}
