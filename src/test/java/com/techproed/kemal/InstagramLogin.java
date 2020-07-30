package com.techproed.kemal;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InstagramLogin extends TestBase {
    @Test
   public void instagram()  {
        driver.get("https://instagram.com");
        WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
        userName.clear();

        userName.sendKeys("kidstr00");

        WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
password.clear();

        password.sendKeys("cerkezsamil123");


        WebElement login=driver.findElement(By.xpath("//a[@href='/accounts/login/?source=auth_switcher']"));

        login.click();




    }
}
