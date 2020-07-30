package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FHCLoginPositiveTest extends TestBase {
    @Test
   // public void positiveTestLogin(){               onceki metot
//        driver.get("http://www.fhctrip.com/Account/Logon");
//        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
//        fhcLoginPage.username.sendKeys("manager2");
//        fhcLoginPage.password.sendKeys("Man1ager2!");
//        fhcLoginPage.loginButton.click();
    public void positiveTestLogin(){  //http://www.fhctrip.com/Account/Logon
                                                // http://fhctrip-qa.com/Account/Logon
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();


    }
}