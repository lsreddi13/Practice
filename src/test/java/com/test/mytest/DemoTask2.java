package com.test.mytest;

import java.io.*;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoTask2 {
	
	WebDriver driver;
	static int rowCounter = 1;
	
	@BeforeClass
	public void open() {
		 driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test(dataProvider = "excelData", dataProviderClass = DemoTask2.class)
	public void test2( String var1,String var2) throws Exception {
		Thread.sleep(3000);
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("username")).sendKeys(var1);
		
		driver.findElement(By.name("password")).sendKeys(var2);
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("df")).getText();
		
		writeResult( value);
		
	}
	
	public static void writeResult( String status) throws Exception {

        String path = System.getProperty("user.dir") + "//mytestdata//data.xlsx";

        FileInputStream fis = new FileInputStream(path);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet("testdata");
        
        Row row = sheet.getRow(rowCounter);

        if (row == null) {
            row = sheet.createRow(rowCounter);
        }

        Cell cell = row.createCell(2); // 👉 next column (column index 1)

        cell.setCellValue(status);

        fis.close();

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);

        fos.close();
        wb.close();
        rowCounter++;  
    }

	
	
	@DataProvider(name = "excelData")
	public Object[][] getData() throws Exception {
	    return readData();   // your existing method
	}
	
	
	public static Object[][] readData() throws Exception {

	    String path = System.getProperty("user.dir") + "//mytestdata//data.xlsx";

	    FileInputStream fis = new FileInputStream(path);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet("testdata");

	    int rows = sheet.getLastRowNum();
	    int cols = sheet.getRow(0).getLastCellNum();

	    Object[][] data = new Object[rows][cols];

	    for (int i = 0; i < rows; i++) {
	        for (int j = 0; j < cols; j++) {
	            data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
	            
	            
	        }
	    }
	    
	    

	    wb.close();
	    fis.close();

	    return data;
	}
	
	
}
