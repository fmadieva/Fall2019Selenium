package com.automation.tests.day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {
        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        inputStream.close();

        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1); // second row
        Cell cell = row.getCell(5); // get result column

        System.out.println("Before: "+cell.getStringCellValue());
        cell.setCellValue("FAILED");//I am changing from n/a to passed
        System.out.println("After: "+cell.getStringCellValue());

        Row firstRow = sheet.getRow(0); // get first row. 1 row is reserved for column names
        Cell newCell = firstRow.createCell(row.getLastCellNum()) ;// creating a new cell
        newCell.setCellValue("Date of execution"); // give the name to this cell

        // write date and time info into second row, last column

        Row secondRow = sheet.getRow(0);
        Cell newCell2 = secondRow.createCell(6); // create a cell
        newCell2.setCellValue(LocalDateTime.now().toString()); // I will set current date and time info into new cell

        // I create if I want to write something into the file
        // Dont forget to close excel file if you opened it
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }


}


//whenever you create a cell, it does not mean that all cell under neat will created automatically
//So first we created object of second row then we created new cell and write date and time information