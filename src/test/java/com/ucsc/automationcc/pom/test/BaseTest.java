package com.ucsc.automationcc.pom.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void initBrowser(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
