package com.simbirsoft.files.tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class XlsxFileTest {

    @Test
    void checkXlsxFile () throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("xlsx_sample.xlsx");
        XLS xlsFile = new XLS(stream);
        int cellValueA = (int) xlsFile.excel.getSheetAt(0).getRow(5).getCell(0).getNumericCellValue();
        String cellValueB = xlsFile.excel.getSheetAt(0).getRow(30).getCell(1).getStringCellValue();
        String cellValueC = xlsFile.excel.getSheetAt(0).getRow(37).getCell(2).getStringCellValue();
        String cellValueD = xlsFile.excel.getSheetAt(0).getRow(53).getCell(3).getStringCellValue();
        String cellValueE = xlsFile.excel.getSheetAt(0).getRow(82).getCell(4).getStringCellValue();
        int cellValueF = (int) xlsFile.excel.getSheetAt(0).getRow(23).getCell(5).getNumericCellValue();
        String cellValueG = xlsFile.excel.getSheetAt(0).getRow(54).getCell(6).getStringCellValue();
        int cellValueH = (int) xlsFile.excel.getSheetAt(0).getRow(100).getCell(7).getNumericCellValue();

        Assertions.assertEquals(5, cellValueA);
        Assertions.assertEquals("Carla", cellValueB);
        Assertions.assertEquals("Wachtel", cellValueC);
        Assertions.assertEquals("Male", cellValueD);
        Assertions.assertEquals("Great Britain", cellValueE);
        Assertions.assertEquals(46, cellValueF);
        Assertions.assertEquals("15/10/2017", cellValueG);
        Assertions.assertEquals(6125, cellValueH);
    }
}
