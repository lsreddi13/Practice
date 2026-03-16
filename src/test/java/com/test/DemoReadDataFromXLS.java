package com.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoReadDataFromXLS {

	

	@DataProvider
	public static Object[][] getData() throws EncryptedDocumentException, IOException {
		return readData();
	}

	public static Object[][] readData() throws EncryptedDocumentException, IOException {
		// get the file path
		String filePath = System.getProperty("user.dir") + "//testdataFiles//VehicleNumbers4.xlsx";

		System.out.println("print filepath : " + filePath);

		FileInputStream file = new FileInputStream(filePath);

		Workbook wb = WorkbookFactory.create(file);

		Sheet sheet = wb.getSheet("Sheet1");

		int numberOfRows = sheet.getLastRowNum();

		int numberOfCols = sheet.getRow(0).getLastCellNum();

		Object[][] ss = new Object[numberOfRows][numberOfCols];

		for (int i = 0; i < numberOfRows; i++) {

			for (int j = 0; j < numberOfCols; j++) {
//						System.out.println(sheet.getRow(i+1).getCell(j));
				ss[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}

		}
		return ss;

	}
}
