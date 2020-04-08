package com.automation.tests.day25_excel_io;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;

public class ReadDataFromExcel {

    @Test
    public void readExcelFileTest() throws Exception {

        File file = new File("VytrackTestUsers.xlsx"); // we need to get a file as an object

        Workbook workbook = WorkbookFactory.create(file); // object that represents excel file

        Sheet workSheet = workbook.getSheet("QA1-short");

        Row firstRow = workSheet.getRow(0); // to the the first row

        Cell firstCell = firstRow.getCell(0); // get 1st cell

        String value = firstCell.getStringCellValue(); // get string value

        String secondCellValue = firstRow.getCell(1).getStringCellValue();

        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell = firstRow.getLastCellNum();

        System.out.println("************************");

        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+" | ");
        }

        int numberOfRows = workSheet.getLastRowNum() ; // to get # of rows  --- // last row is 16th --> index is 15
        int numberOfRows2 = workSheet.getPhysicalNumberOfRows();

        System.out.println("\n Index of last row  : "+numberOfRows);
        System.out.println(" total number Of Rows : " + numberOfRows2);

        System.out.println("************************");
        System.out.println("To print the whole sheet : ");

        for (int row = 0; row < workSheet.getPhysicalNumberOfRows() ; row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum() ; cell++) {

                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                        System.out.print(cellValue+" | ");
            }
            System.out.println();
        }




    }
}
