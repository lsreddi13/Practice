package com.test.mytest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class DemoTask1 {
	
	@Test
	public void test1() throws EncryptedDocumentException, IOException {
		
		
		String path = System.getProperty("user.dir") + "//mytestdata//data.xlsx";

        FileInputStream fis = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("testdata");

        int rows = sheet.getLastRowNum();

        for (int i = 0; i <= rows; i++) {

            Row row = sheet.getRow(i);

            if (row != null) {
                Cell cell = row.getCell(0);  // first column

                if (cell != null) {
                    System.out.println(cell.toString());
                }
            }
        }

        workbook.close();
        fis.close();
    }
		
	}


