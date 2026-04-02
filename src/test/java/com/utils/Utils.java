package com.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {
	
	
	
	public List<String> getListNames_Css(String CssLocator, WebDriver driver) {
		List<String> actualListNames = new ArrayList<>();
		List<WebElement> ListElements = driver.findElements(By.cssSelector(CssLocator));

		for (WebElement element : ListElements) {
			actualListNames.add(element.getText());
		}
		return actualListNames;
	}
	
	
	
	public List<String> getListNames_xpath(String xpathLocator, WebDriver driver) {
		List<String> actualListNames = new ArrayList<>();
		List<WebElement> ListElements = driver.findElements(By.xpath(xpathLocator));

		for (WebElement element : ListElements) {
			actualListNames.add(element.getText());
		}
		return actualListNames;
	}
	
	public String getTextWebElement(WebDriver driver, WebElement element) {
		WebElement ele  = element;
		return ele.getText() ;
	}
}
