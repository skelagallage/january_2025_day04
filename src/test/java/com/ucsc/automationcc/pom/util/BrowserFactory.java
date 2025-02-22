package com.ucsc.automationcc.pom.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    private static BrowserFactory browserFactory;

    ThreadLocal<WebDriver> tlWebDriver = ThreadLocal.withInitial(()->{
        WebDriver driver = null;
        String browserName = System.getProperty("browser", "chrome");
        driver = switch (browserName) {
            case "chrome" -> WebDriverManager.chromedriver().create();
            case "firefox" -> WebDriverManager.firefoxdriver().create();
            case "edge" -> WebDriverManager.edgedriver().create();
            default -> driver;
        };
        if(driver != null)
            driver.manage().window().maximize();
        return driver;
    });

    private BrowserFactory(){
    }

    public static BrowserFactory getBrowserFactory(){
        if(browserFactory == null){
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver getDriver(){
        return tlWebDriver.get();
    }

    public void quitDriver(){
        if(getDriver() != null){
            getDriver().quit();
        }
        tlWebDriver.remove();
    }


}
