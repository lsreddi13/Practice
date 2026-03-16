package com.tests;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelResultWriter {

    private static final String excelPath =
            System.getProperty("user.dir") + "//screenshots//VehicleResults.xlsx";

    public static void writeResult(String vehicleNumber, String category) throws IOException {

        Workbook workbook;
        Sheet sheet;
        File file = new File(excelPath);

        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
        } else {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("Results");

            // Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Vehicle Number");
            header.createCell(1).setCellValue("Category");
            header.createCell(2).setCellValue("Screenshot Name");
        }

        int lastRow = sheet.getLastRowNum();
        Row row = sheet.createRow(lastRow + 1);

        row.createCell(0).setCellValue(vehicleNumber);
        row.createCell(1).setCellValue(category);
        row.createCell(2).setCellValue(vehicleNumber + ".png");

        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);

        fos.close();
        workbook.close();
    }
    
    
}
