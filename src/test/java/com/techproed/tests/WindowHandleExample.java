package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {


    @Test
    public void newWindowtest() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String parentWindowHandle = driver.getWindowHandle();//windows acilan her bir web page icin unique bir alfanumerik koc verir. bu kod, hangi sayfada oldugumuzu webdriver bununla kontrol eder
        System.out.println("Parent Window Handle: " + parentWindowHandle);//parent window handle i verir

        //https://the-internet.herokuapp.com/windows adresine gidin.
        //Sayfadaki textin  “Opening a new window” olduğunu doğrulayın.
        String actualtext = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualtext, expectedText);


        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTile = "The Internet";
        Assert.assertEquals(actualTitle, expectedTile);

        //Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
//Acilan yeni pencerenin sayfa başlığının (title)  “New Window” oldugunu dogrulayin.
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String childWindowHandle : allWindowHandles) {
            if (!childWindowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(childWindowHandle);
                System.out.println("Child Window Handle: " + childWindowHandle);



                String newWindowTitle=driver.getTitle();
                Assert.assertEquals(newWindowTitle, "New Window");
                //sayfadaki textin new window oldugunu dogrulayin
                String newWindowText=driver.findElement(By.xpath("//h3")).getText();
                Assert.assertEquals(newWindowText,"New Window");
                //Bir önceki pencereye geri döndükten sonra sayfa başlığının  “The Internet” olduğunu doğrulayın.
//sayfayi once parentwindow'a geri dondurmeliyiz
                driver.switchTo().window(parentWindowHandle);
                Assert.assertEquals(driver.getTitle(), "The Internet");
                


            }
        }
    }
}
