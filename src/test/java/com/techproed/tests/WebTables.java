package com.techproed.tests;
//http://www.fhctrip.com/admin/HotelRoomAdmin
//Username : manager2
//Password : Man1ager2!
//table() metodu oluşturun
//Tüm table body’sinin boyutunu(size) bulun.
//Table’daki başlıkları(headers) konsolda yazdırın.
//printRows() metodu oluşturun
//table body’sinde bulunan toplam satir(row) sayısını bulun.
//Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
//4.satirdaki(row) elementleri konsolda yazdırın.
//printCells() metodu oluşturun
//table body’sinde bulunan toplam hücre(cell) sayısını bulun.
//Table body’sinde bulunan hücreleri(cells)  konsolda yazdırın.
//printColumns() metodu oluşturun
//table body’sinde bulunan toplam sutun(column) sayısını bulun.
//Table body’sinde bulunan sutunlari(column)   konsolda yazdırın.
//5.column daki elementleri  konsolda yazdırın.
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends TestBase {
    //    login() metodun oluşturun ve oturum açın.
    @Test

    public void login() {
        driver.get("http://www.fhctrip.com/admin/HotelRoomAdmin");
        driver.findElement(By.id("UserName")).sendKeys("manager2");     //Username : manager2;
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");   //Password : Man1ager2!;
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    public void table() throws InterruptedException {
        login();
        // tbody'deki datalari konsolda yazdirin
        Thread.sleep(3000);
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tbody.getText());
        //        Tüm table body’sinin boyutunu(size) bulun.
        List<WebElement> table = driver.findElements(By.xpath("//tbody//td"));
        System.out.println("TABLE BODY SIZE : " + table.size());
//        Table’daki başlıkları(headers) konsolda yazdırın.
        List<WebElement> allHeaders = driver.findElements(By.tagName("th"));
        for (WebElement header : allHeaders) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printRows() {
        login();
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println("Table body'de toplam " + driver.findElements(By.xpath("//tbody//tr")).size() + " tane satir(row) vardir.");
        //Table body’sinde bulunan satirlari(rows)  konsolda yazdırın.
        List<WebElement> allRows = driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement row : allRows) {
            System.out.println(row.getText());
        }
        //4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> elementsRow4 = driver.findElements(By.xpath("//tr[4]//td"));
        for (WebElement element : elementsRow4) {
            System.out.println(element.getText());
        }
    }
    @Test
    public void printColumns(){
        login();
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.      //tr[3]//td
        System.out.println("Tabloda toplam " + driver.findElements(By.xpath("//th")).size()+ " tane sutun(column) vardir.");
        //5.column daki elementleri  konsolda yazdırın.
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
        for(WebElement element : column5){
            System.out.println(element.getText());
        }
    }
    public void  printData(int row, int column){
        //kodlari bu metodun icine yazalim
        //   //tbody//tr[8]//td[3]
        //dinamik bir xpath yazalim
        String xpath = "//tbody//tr[" +row+ "]//td[" +column+ "]";
        //elementleri xpath'i kullanarak bulalim
        WebElement data = driver.findElement(By.xpath(xpath));
        //data lari yazdiralim
        System.out.println(data.getText());
    }
    @Test
    public void printDataTest(){
        login();
        printData(8,3);     // 1234
        printData(5,2);    //kalem
        printData(9,5);    //London
    }
}




