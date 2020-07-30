package com.techproed.kemal;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class locators {
    @Test
    public void locators(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");

        //        driver.get("https://www.facebook.com");
        //        WebElement ay=driver.findElement(By.id("month"));
        //        Select optionAy= new Select(ay);
        //        optionAy.selectByVisibleText("Aug");
        //
        //        WebElement gun=driver.findElement(By.id("day"));
        //        Select optionGun=new Select(gun);
        //        optionGun.selectByIndex(4);
        //
        //        WebElement yil=driver.findElement(By.id("year"));
        //        Select optionYil=new Select(yil);
        //        optionYil.selectByValue("2000");
        //       driver.close();

        WebElement day=driver.findElement(By.id("day"));
        Select optionDay=new Select(day);
        optionDay.selectByIndex(7);

        WebElement month=driver.findElement(By.id("month"));
        Select optionMonth=new Select(month);
        optionMonth.selectByValue("3");

        WebElement year=driver.findElement(By.name("birthday_year"));
        Select optionYear=new Select(year);
        optionYear.selectByVisibleText("1970");

        WebElement gender=driver.findElement(By.id("u_0_7"));
        gender.click();

        WebElement submit=driver.findElement(By.id("u_0_12"));
        submit.click();






    }

}
