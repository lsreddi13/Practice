package com.test.fillForm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DemoFillForm {
	WebDriver driver;

	@Test
	public void test() {

		driver = new ChromeDriver();

		String url = "https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg";

		driver.get(url);
		// validate input box placeholder text in the reg page.

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("popup-close")));
		driver.findElement(By.id("popup-close")).click();

		enterName("JoseQA");
		enterEmail("joseQA@gmail.com");
		enterMobile("9871113210");
		selectState("Telangana");
		selectCity("Hyderabad");
		enterProfession("Engineer");
		selectTime("Within 1 month");
		driver.findElement(By.xpath("//div[@id='form-response']/preceding-sibling::button")).click();
		
		getResponseMsg();
	}

	// 🔹 WebElements

	public void getResponseMsg() {
		WebElement response_ele = driver.findElement(By.xpath("//div[@id='form-response']"));
		String responseMsgText = response_ele.getText();
		System.out.println(responseMsgText);

	}

	// 🔹 Actions
	public void enterName(String name) {
		WebElement name_ele = driver.findElement(By.name("name"));
		name_ele.sendKeys(name);
	}

	public void enterEmail(String email) {
		WebElement email_ele = driver.findElement(By.name("email"));
		email_ele.sendKeys(email);
	}

	public void enterMobile(String mobile) {
		WebElement mobile_ele = driver.findElement(By.name("mobile"));
		mobile_ele.sendKeys(mobile);
	}

	public void selectState(String state) {
		WebElement state_ele = driver.findElement(By.name("state"));
		state_ele.sendKeys(state);
	}

	public void selectCity(String city) {
		WebElement city_ele = driver.findElement(By.name("city"));
		city_ele.sendKeys(city);
	}

	public void enterProfession(String profession) {
		WebElement profession_ele = driver.findElement(By.name("profession"));
		profession_ele.sendKeys(profession);
	}

	public void selectTime(String time) {
		WebElement time_ele = driver.findElement(By.name("time"));
		time_ele.sendKeys(time);
	}
}