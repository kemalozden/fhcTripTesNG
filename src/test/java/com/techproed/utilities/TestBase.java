package com.techproed.utilities;

import com.techproed.pages.FHCLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

abstract public class TestBase {

    protected WebDriver driver;
    protected Actions actions;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions = new Actions(driver);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("gecerli_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("gecerli_password"));
        fhcLoginPage.loginButton.click();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}