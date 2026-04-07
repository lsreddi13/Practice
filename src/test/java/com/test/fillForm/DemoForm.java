package com.test.fillForm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoForm {
	
	
	WebDriver driver;
	
	
	
	public void enterName(String a) {
		WebElement e_name_ele = driver.findElement(By.name("name"));
		String placeHolderText = e_name_ele.getAttribute("placeholder");
		System.out.println(placeHolderText);
		e_name_ele.sendKeys(a);
		
	}
	
	
	
	
	
	
	@Test
	public void test() {
		
		String url = "https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg";
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("popup-close")).click();
		
		enterName("Jhansi");
		
	}
	

}
