package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AssignementAmazon extends TestBase {
    @Test
    public void amazonTest() {
        driver.get("https://www.amazon.com");

        // 3.Dropdown elementini bulun.
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select optionDropDownMenu = new Select(dropDownMenu);

// 4.İlk seçilen seçeneği(firstSelectedOption) konsolda yazdırın
        String firstSelectedAmazon = optionDropDownMenu.getFirstSelectedOption().getText();
        System.out.println("ILK SECILI OLAN SECENEK: " + firstSelectedAmazon);

        // ve ilk secenegin “All Departments” ile esit oldugunu dogrulayin.
        Assert.assertEquals(firstSelectedAmazon, "All Departments");
//6.seçeneği(option) index kullanarak secin ve 6.seçeneğin “Books” oldugunu dogrulayin
        optionDropDownMenu.selectByIndex(5);
        String sixtOption = optionDropDownMenu.getFirstSelectedOption().getText();
        System.out.println("Sixt option is: " + sixtOption);
        Assert.assertEquals(sixtOption, "Books");
        //// 6.Butun dropdown seçeneklerini konsolda yazdırın
        List<WebElement> allOptions = optionDropDownMenu.getOptions();
        int i = 1;
        for (WebElement w : allOptions) {
            System.out.println(i++ + ". option: " + w.getText());
        }
        // 7.Dropdowndaki eleman sayisini konsolda yazdırın
        int optionsSayisi = allOptions.size();
        System.out.println("Dropdowndaki eleman sayisi: " + optionsSayisi);
        // 8.“Electronics” ın dropdownda olup olmadığını kontrol edin. “Electronics” dropdownda bulunuyorsa konsolda True yazdırın.
        // Aksi takdirde False yazdırın.
        // ==> WebElement halindeki optionslari String halinde yeni bir listeye atabiliriz.
        List<String> allOptionsStringList = new ArrayList<String>();
        int count = 0;
        for(WebElement w :  allOptions) {
            if(w.getText().equals("Electronics")) {
                count++;
            }
            allOptionsStringList.add(w.getText()); // ==> String List e ekleme yaptik.
        }
        System.out.println("Electronics sayisi: " + count );
        String result = count>0 ? "True" : "False" ;
        System.out.println("Dropdownda \"Electronics\" bulunma durumu: "+ result);
        // Istenilirse bu sekilde list in icerisinde varmi diye contains methodu ile bakilabilir.
        System.out.println("Dropdownda \"Electronics\" bulunma durumu String List: " + allOptionsStringList.contains("Electronics"));
   }
}
