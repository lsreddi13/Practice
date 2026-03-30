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

public class DemoWebTables {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void test() {

		driver.get("https://demoqa.com/webtables");

		List<String> actualHeaderNames = new ArrayList<>();
		List<String> expectedHeaderNames = Arrays.asList("First Name", "Last Name", "Age", "Email", "Salary",
				"Department", "Action");

		List<WebElement> tableHeaderNames = driver.findElements(By.xpath("//table/thead/tr/th"));

		for (WebElement h_name : tableHeaderNames) {
			actualHeaderNames.add(h_name.getText());
		}
		Assert.assertEquals(actualHeaderNames, expectedHeaderNames);

		// get the number of rows before adding new row
		

		int numberOfRowsBeforeAddingNewRow = getRowSize();

		// click add
		driver.findElement(By.id("addNewRecordButton")).click();

		

		WebElement l_name_ele = driver.findElement(By.id("lastName"));

		WebElement email_ele = driver.findElement(By.id("userEmail"));

		WebElement age_ele = driver.findElement(By.id("age"));

		WebElement sal_ele = driver.findElement(By.id("salary"));

		WebElement department_ele = driver.findElement(By.id("department"));

		WebElement submit_ele = driver.findElement(By.id("submit"));

		String fname = "Amar";
		String lname = "Reddy";
		String age = "35";
		String email = "Amar@gmail.com";
		String sal = "35000";
		String department = "testing";

		enterFirstName(fname);
		l_name_ele.sendKeys(lname);
		email_ele.sendKeys(email);
		age_ele.sendKeys(age);
		sal_ele.sendKeys(sal);
		department_ele.sendKeys(department);

		submit_ele.click();

		

		// get the number of rows after adding new row
		int numberOfRowsAfterAddingNewRow = getRowSize();

		// compare before value +1 equals to after value
		Assert.assertEquals(numberOfRowsAfterAddingNewRow, numberOfRowsBeforeAddingNewRow + 1);
//		clickEditIcon(fname);

		clickDeleteIcon(fname);
		

		// get the number of rows after adding new row
		int numberOfRowsAfterDeleteingNewRow =getRowSize();

		// compare before value +1 equals to after value
		Assert.assertEquals(numberOfRowsAfterDeleteingNewRow, numberOfRowsAfterAddingNewRow - 1);

	}

	public void clickEditIcon(String name) {
		WebElement editIcon = driver
				.findElement(By.xpath("//table/tbody/tr/td[contains(text(), '" + name + "')]/../td[7]/div/span[1]"));

		editIcon.click();
	}

	public void clickDeleteIcon(String name) {
		WebElement deleteIcon = driver
				.findElement(By.xpath("//table/tbody/tr/td[contains(text(), '" + name + "')]/../td[7]/div/span[2]"));

		deleteIcon.click();

	}

	public int getRowSize() {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowSize = rows.size();

		return rowSize;
	}
	
	public void enterFirstName(String fname) {
		WebElement f_name_ele = driver.findElement(By.id("firstName"));
		f_name_ele.sendKeys(fname);
	}

}
