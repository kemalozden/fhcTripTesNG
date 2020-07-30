package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class ReadExcel {
    @Test
    public void readExcelFile() throws IOException {
        //Data okuyacagimiz dosyanin path'ini yazalim
      //  String path = "C:\\Users\\PC\\Desktop\\ULKELER.xlsx"; //hocanin dosyasi
       String path=  "C:\\Users\\ada\\IdeaProjects\\ULKELER.xlsx";
       // String path=  "C:/ULKELER.xlsx";

    //Dosyayi(file) acalim
        FileInputStream fileInputStream = new FileInputStream(path);
        //fileInputStream kullanarak workbook'u acalim
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //1.worksheet'e gidelim (index 0'dan basliyor)
        Sheet sheet = workbook.getSheetAt(0);
        //1.satira (row) gidelim (index 0'dan baslar)
        Row row = sheet.getRow(0);
        //Artik test datalarini(cell) okuyabiliriz.
        Cell cell = row.getCell(0);
        System.out.println("1.CELL'deki data : "+cell);
        System.out.println("2.CELL'deki data : "+ row.getCell(1));
    }
}