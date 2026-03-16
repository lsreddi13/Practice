package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriter {
	
	@Test
	public void test() throws IOException {
		File folder = new File("./screenshots/nontruck");
		File folder2 = new File("./screenshots/truck");
		File[] pngFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
		writeMultipleFileNamesToExcel(pngFiles);
	}
	public static void writeMultipleFileNamesToExcel(File[] files) throws IOException {

        String excelPath = "./screenshots/ScreenshotLog.xlsx";
        Workbook workbook;
        Sheet sheet;

        File excelFile = new File(excelPath);

        if (excelFile.exists()) {
            FileInputStream fis = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Screenshots");

            // Create header row
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Screenshot Name");
        }

        int lastRow = sheet.getLastRowNum();

        for (File file : files) {
            Row row = sheet.createRow(++lastRow);
            row.createCell(0).setCellValue(file.getName());
        }

        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);

        fos.close();
        workbook.close();
    }
}
