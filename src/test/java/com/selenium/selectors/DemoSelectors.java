package com.selenium.selectors;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoSelectors {
	
	
	WebDriver driver;
	String url = "https://www.vidyamandir.com/franchise/?utm_source=taboola&utm_medium=yahoo-mail&utm_campaign=46197578&tblci=GiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg#tblciGiC0Q6DK6fWglldCDPrJD9fUhaq5aBcWxgwofmDqYJ-tPSDkxHQoucWy_ISl04A_MJ_bXg";
	
	
	@Test
	public void  testSelectorClass() throws InterruptedException {
		
		driver = new ChromeDriver();
		
		driver.get(url); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("popup-close")).click();
		
		WebElement selectState = driver.findElement(By.id("state-select"));
		
		Select se = new Select(selectState);
		
		se.selectByIndex(6);
		se.selectByValue("Telangana");
		se.selectByVisibleText("Punjab");
		
		driver.findElement(By.xpath("//select[@id='state-select']")).click();
		Thread.sleep(4000);
		
		List<WebElement> stateList = driver.findElements(By.xpath("//select[@id='state-select']/option"));
		
 		for(WebElement state : stateList) {
 			String stateName = state.getText();
 			if(stateName.equals("Telangana")) {
 			state.click();
 			}
 		}
		
		
	}
	
	
	
	
	

}
