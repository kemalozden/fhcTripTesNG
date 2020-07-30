package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClassExample extends TestBase {
   //Create  test method : contextClickMethod() ve aşağıdaki senaryoyu test edin:
    //https://the-internet.herokuapp.com/context_menu web sitesine gidin.
    //Dikdörtgen kutu icinde sağa tıklayın.
    //Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
    //Alert’te OK ye basin

    @Test
    public void contextClickMethod(){

driver.get("https://the-internet.herokuapp.com/context_menu");

        //Dikdörtgen kutu icinde sağa tıklayın.
        WebElement dikdortgen =driver.findElement(By.id("hot-spot"));
        //bunun icin action class objesi utericez
    //    Actions actions =new Actions(driver);// bunu testBase'e alalim
actions.contextClick(dikdortgen).perform();
//Alert mesajinin “You selected a context menu” oldugunu dogrulayin.
        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);
        //Alert’te OK ye basin
        driver.switchTo().alert().accept();
    }
    @Test
    public void hoverOver(){
        //https://www.amazon.com/  web sitesine gidin.
        driver.get("https://www.amazon.com/");
        //“Your Account” linkine tıklayın.
        WebElement helloSignIn = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
        actions.moveToElement(helloSignIn).perform();
        WebElement yourAccount = driver.findElement(By.linkText("Your Account"));
        yourAccount.click();
        //Sayfa basliginin(page title) “Your Account" icerdigini(contains) dogrulayin. odev


        }
    @Test
    public void keysUpDown(){
        //https://www.google.com/ adresine gidin.
    //Google text box’a IPHONE (capital) yazdirin
    //( input(giris) => iphone , output => IPHONE)
    //Text box’ta cift tiklayin(double click).
    driver.get("https://www.google.com/");
    WebElement searchBox=driver.findElement(By.name("q"));
    //buyuk harf icin 1. yol
    //    searchBox.sendKeys(Keys.SHIFT+ "iphone");
    /*//2.yol  actions class
        actions.
                moveToElement(searchBox).click().keyDown(Keys.SHIFT).
                sendKeys("iphone").
                perform();*/
        actions.keyDown(searchBox,Keys.SHIFT).
                sendKeys("iphone").
                keyUp(searchBox, Keys.SHIFT).
                perform();

        actions.doubleClick().perform();

    }

    @Test
    public void scrollUpDown() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //sayfayi asagi dogru kaydirma
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //bir sayfada birden fazla keys down keys up yapabiliriz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        //arrow doen da sayfayi asagi indirir ama daha az iner
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
       //sayfayi yukari kaydiralim
       actions.sendKeys(Keys.PAGE_UP).perform();
        //arrup up sayfayi yukari kaydirir ama daha az miktarda
        Thread.sleep(5000);





    }
}