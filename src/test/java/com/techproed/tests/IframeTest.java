package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {

    @Test
    public void iframeTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //“An IFrame containing….” textini konsolda yazdirin
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        //Text Box’a “Merhaba Dunya!” yazin.
        // WebElement textBox = driver.findElement(By.xpath("//p")); //FAIL
        //textBox.sendKeys("Merhaba Dunya!");
        //TEST FAIL OLURSA NE YAPMALIYIZ??
        //1. Locator kontrol edilmeli
        //2. Wait(Bekleme) problemi var mi kontrol edilmeli
        //3. Sayfada Iframe var mi kontrol edilmeli
        //Bu sayfada IFRAME var. Dolayisiyla Iframe switchTo() yapmaliyiz.
        //Bir Iframe switch yapmanin 3 yolu vardir: 1. index ile, 2.id veya name value ile, 3.WebElement ile
        //driver.switchTo().frame(0);            // index 0 dan baslar.index kullanarak iframe e gidelim
        //driver.switchTo().frame("mce_0_ifr");  //id value kullanarak iframe e gidelim
        WebElement frameElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElement);  //webElement kullanarak iframe e gidelim
        //Artik iframe icindeki elementi bulabiliriz
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");
        //TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda yazdirin.
        //  WebElement seleniumText=driver.findElement(By.linkText("Elemental Selenium"));
        // System.out.println(seleniumText.getText());// bunu yazmaz cunku hala iframi'in icindeyiz. noSuchElement exception hatasi verir
        //iframe disina, parent frame'e ,  cikmamiz lazim
        //parent frame nasil geri geliriz:
        driver.switchTo().parentFrame();
        // driver.switchTo().defaultContent()// bu da parent pfarme gonderir
        //parentframe() ve defoultContent() burada ayni isi yaptirdi ama aralarinda bir fark var:
        //birden fazla ic ice girmis iframeler oldugunda parent frame bir ustteki iframe gider.
        //oysa defoult frame en bastaki frame'e geri doner.
        //simdi yazdirabiliriz
        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println(seleniumText.getText());


    }
}
