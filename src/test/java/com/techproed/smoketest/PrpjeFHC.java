package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PrpjeFHC extends TestBase {
/*    @Test(priority = 0)
    public void login() {  //http://www.fhctrip.com/Account/Logon
        // http://fhctrip-qa.com/Account/Logon
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();
    }*/

    @Test(priority = 1)
    public void acceptCriteria1() throws InterruptedException {
        Thread.sleep(3000);
        //  AC 1: System Management ana menusunun altinda User Management ve Hotel Management sub-menuleri olmali.
         WebElement userManagement = driver.findElement(By.xpath("//span[@class = 'title'][text() = 'User Management']"));
        Assert.assertTrue(userManagement.isDisplayed());
         WebElement hotelManagement = driver.findElement(By.xpath("//span[@class='title'][text()='Hotel Management']"));
        Assert.assertTrue(hotelManagement.isDisplayed());
    }

    @Test(priority = 2)
    public void acceptCriteria2() {
        //AC 2: Hotel Management menusunun altinda: Hotel Rooms, Room Reservations linkleri olmali
         WebElement hotelManagement = driver.findElement(By.xpath("//span[@class='title'][text()='Hotel Management']"));
        hotelManagement.click();
        WebElement hotelRoom = driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"));
        Assert.assertTrue(hotelRoom.isDisplayed());
        WebElement room_reservations = driver.findElement(By.partialLinkText("Room reservations"));
        Assert.assertTrue(room_reservations.isDisplayed());
    }

    @Test(priority = 3)
    public void acceptCriteria3() {
        //AC 3: Hotel Rooms'a tiklayinca ayni sayfada http://www.fhctrip.com/admin/HotelRoomAdmin sayfasi acilmali
        WebElement hotelManagement = driver.findElement(By.xpath("//span[@class='title'][text()='Hotel Management']"));
        hotelManagement.click();
        WebElement hotelRoom = driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"));
        hotelRoom.click();
        String expectedUrl = "http://www.fhctrip.com/admin/HotelRoomAdmin";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);


    }
}





