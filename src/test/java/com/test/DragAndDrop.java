package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	 @Test
	    public void test() throws InterruptedException{
	        WebDriver driver = new ChromeDriver();
	        driver.get("http://dhtmlx.com/docs/products/dhtmlxTree/");
	        Thread.sleep(5000);
	        
	        driver.switchTo().frame(0);
//	        driver.findElement(By.xpath("//*[@id=\"treeSource\"]/ul/li[1]/ul/li[1]/ul/li[3]/div/span")).click();
	        WebElement source = driver.findElement(By.xpath("//*[@id=\"treeSource\"]/ul/li[1]/ul/li[1]/ul/li[3]/div/span"));
	        WebElement destination = driver.findElement(By.xpath("//*[starts-with(@id,'u177')]"));
	        Actions ac = new Actions(driver);
	         ac.dragAndDrop(source, destination).build().perform();
	    }
}
