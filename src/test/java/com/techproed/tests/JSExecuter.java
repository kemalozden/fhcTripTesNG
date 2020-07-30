package com.techproed.tests;

import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuter {
    @Test
    public void javascriptExecuterTest(){
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        WebElement loginButton= Driver.getDriver().findElement(By.id("btnSubmit"));
            }
            public void clickElementbyJS(WebElement element){
                JavascriptExecutor jsExecutor=((JavascriptExecutor) Driver.getDriver());
                jsExecutor.executeScript("arguments[0].click();",element);

            }
}
