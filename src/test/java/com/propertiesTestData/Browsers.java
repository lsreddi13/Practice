package com.propertiesTestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Browsers {
	
	WebDriver driver;
	Properties prop;
	
	
	public Browsers() throws FileNotFoundException, IOException {
		
		prop = new Properties();
		
		prop.load(new FileInputStream(".//testdataFiles//config.properties"));
		
		if(prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
			
		} else if(prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(prop.getProperty("appURL"));
	}
	
	
	@Test
	public void testB1()  throws FileNotFoundException, IOException {
		new Browsers();
		
		DempProperties dp = new DempProperties();
		String name = prop.getProperty("username");
		dp.closePopup(driver);
		dp.enterName(driver, name);
		
		
	}
	
	//load the properties file and use the values in the test cases
	
//	pass the browser name and applciaiton url in properties file
	
	
	
	@Test 
	public void testB2() throws FileNotFoundException, IOException  {
		new Browsers();
		
		DempProperties dp = new DempProperties();
		String name = prop.getProperty("username");
		dp.closePopup(driver);
		dp.enterName(driver, name);
	}
	
	
	@Test
	public void testB3()  throws FileNotFoundException, IOException {
		new Browsers();
		DempProperties dp = new DempProperties();
		String name = prop.getProperty("username");
		dp.closePopup(driver);
		dp.enterName(driver, name);
		
	}

}
