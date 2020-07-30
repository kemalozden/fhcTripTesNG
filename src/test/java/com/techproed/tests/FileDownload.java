package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {

    //Iki tane metod oluşturun : isExist() ve downloadTest()
    //downloadTest () metodunun icinde aşağıdaki testi yapın:
    //https://the-internet.herokuapp.com/download adresine gidin.
    //image1.jpg dosyasını indir
    //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
    @Test

    public void isExist() {
        String mevcutKlasor = System.getProperty("user.dir");
        System.out.println("mevcut Klasor: " + mevcutKlasor);
        String userKlasor = System.getProperty("user.home");
        System.out.println("User Klasor: " + userKlasor);
        String filePath = userKlasor + "/Desktop/Savegame.bgm";
        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);

    }

    @Test
    public void downloadTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidin.
        //image1.jpg dosyasını indir

        driver.get("https://the-internet.herokuapp.com/download");
        WebElement uploadedFile = driver.findElement(By.linkText("SaveGame.bgm"));
        uploadedFile.click();
        Thread.sleep(5000);
//Ardından dosyanın başarıyla indirilip indirilmediği
String userKlasor=System.getProperty("user.home");
String filePath=userKlasor+ "Users/ada/Downloads/SaveGame.bgm";
boolean isDownloaded=Files.exists(Paths.get(filePath));
Assert.assertTrue(isDownloaded);//dosya yuklendiyse pass olacak, degilse fail olacak

    }
}
