package com.techproed.tests;


import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAlerts extends TestBase {
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.



    @Test
    public void acceptAlert() {
        //1. butona tıklayın, uyarıdaki(alert) OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        // locate 1. buton
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        buton1.click();
        //Alert uzerindeki mesaji konsolda yazdir
        System.out.println("Alert mesaji: " + driver.switchTo().alert().getText());
        // uyarıdaki(alert) OK butonuna tıklayın
        driver.switchTo().alert().accept(); // accept() => click OK demektir
        //result mesajının görüntülendiğini doğrulayın =>idDisplayed()
        //locate result message
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMesaj.isDisplayed());  //Hard assert
    }

    @Test
    public void dismissAlert() {
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //2.butonu locate edelim
        //WebElement buton2 = driver.findElement()
    }

    @Test
    public void sendKeysAlert() {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
        //Locate 3.buton
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();
        //uyarıdaki metin kutusuna isminizi yazin
        driver.switchTo().alert().sendKeys("Kemal");
        //OK butonuna tıklayın
        driver.switchTo().alert().accept();
        //result mesajının görüntülendiğini doğrulayın
        WebElement resultMesaj = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMesaj.isDisplayed());


    }


}
