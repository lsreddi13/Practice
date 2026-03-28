package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClickExample {
	
	
	 //global vars
	//local vars
	  
	  
	@Test
	public void test1() {
        // Set up the WebDriver (ensure the path to your driver executable is correct)
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		WebDriver driver = new ChromeDriver();

       
            // Navigate to a sample web page (you can replace this with your target URL)
            driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");

            // Locate the element you want to double-click
            // This example uses an element with the ID "clickable" from the sample page
            WebElement elementToDoubleClick = driver.findElement(By.id("clickable"));

//            elementToDoubleClick.click();
            // Initialize the Actions class, passing the driver instance
            Actions ac = new Actions(driver);

            // Perform the double-click action
            ac.doubleClick(elementToDoubleClick).perform();

            // Add a wait to observe the result (optional, but useful for verification)
//            Thread.sleep(2000); // Wait for 2 seconds

            // Verify the result (e.g., check for an alert or a change in the UI)
            // The sample page changes the element text to "double-clicked"
            String resultText = elementToDoubleClick.getText();
            System.out.println("Element text after double click: " + resultText);

       
    }
	
	@Test
	public void test2() {
        // Set up the WebDriver (ensure the path to your driver executable is correct)
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		WebDriver  driver = new ChromeDriver();

       
            // Navigate to a sample web page (you can replace this with your target URL)
            driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");

            // Locate the element you want to double-click
            // This example uses an element with the ID "clickable" from the sample page
            WebElement elementToDoubleClick = driver.findElement(By.id("clickable"));

//            elementToDoubleClick.click();
            // Initialize the Actions class, passing the driver instance
            Actions ac = new Actions(driver);

            // Perform the double-click action
            ac.doubleClick(elementToDoubleClick).perform();

            // Add a wait to observe the result (optional, but useful for verification)
//            Thread.sleep(2000); // Wait for 2 seconds

            // Verify the result (e.g., check for an alert or a change in the UI)
            // The sample page changes the element text to "double-clicked"
            String resultText = elementToDoubleClick.getText();
            System.out.println("Element text after double click: " + resultText);

       
    }
}


