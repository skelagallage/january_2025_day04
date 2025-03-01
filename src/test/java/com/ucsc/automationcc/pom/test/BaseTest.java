package com.ucsc.automationcc.pom.test;

import com.ucsc.automationcc.pom.util.BrowserFactory;
import com.ucsc.automationcc.pom.util.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    protected WebDriver driver;
    protected BrowserFactory browserFactory;

    @BeforeSuite
    public void initReporter(){
        ExtentReportManager.initReport();
    }
    @BeforeClass
    public void initBrowserFactory(){
        browserFactory = BrowserFactory.getBrowserFactory();
    }

//    @BeforeClass
    @BeforeMethod
    public void initBrowser(Method method){
//        driver = WebDriverManager.chromedriver().create();
        ExtentReportManager.createTest(method.getName());
        driver = browserFactory.getDriver();
        driver.manage().window().maximize();
    }

//    @AfterClass
    @AfterMethod
    public void quitBrowser(){
//        driver.quit();
        browserFactory.getDriver().quit();
        ExtentReportManager.flushReport();
    }
}
