package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ScreenshotExcelWriter {
	
	
	public static void main(String[] args) throws IOException {

        String basePath = "./screenshots/";
        String[] folderNames = {"truck", "nontruck"};

        String excelPath = "./screenshots/ScreenshotLog2.xlsx";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Screenshots");

        // Create Header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Screenshot Name");
        header.createCell(1).setCellValue("Folder Type");

        int rowNum = 1;

        for (String folderName : folderNames) {

            File folder = new File(basePath + folderName);
            File[] pngFiles = folder.listFiles((dir, name) ->
                    name.toLowerCase().endsWith(".png"));

            if (pngFiles != null) {

                // Optional: sort files
                Arrays.sort(pngFiles);

                for (File file : pngFiles) {

                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(file.getName());
                    row.createCell(1).setCellValue(folderName);
                }
            }
        }

        FileOutputStream fos = new FileOutputStream(excelPath);
        workbook.write(fos);
        fos.close();
        workbook.close();

        System.out.println("Excel created successfully!");
    }
	
	
}
