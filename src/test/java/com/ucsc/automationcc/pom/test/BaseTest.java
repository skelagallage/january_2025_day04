package com.ucsc.automationcc.pom.test;

import com.ucsc.automationcc.pom.util.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected BrowserFactory browserFactory;

    @BeforeClass
    public void initBrowserFactory(){
        browserFactory = BrowserFactory.getBrowserFactory();
    }

//    @BeforeClass
    @BeforeMethod
    public void initBrowser(){
//        driver = WebDriverManager.chromedriver().create();
        driver = browserFactory.getDriver();
        driver.manage().window().maximize();
    }

//    @AfterClass
    @AfterMethod
    public void quitBrowser(){
//        driver.quit();
        browserFactory.getDriver().quit();
    }
}
