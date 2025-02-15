package com.ucsc.automationcc.pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public EbayHomePage initApp(String url){
        driver.get(url);
        return PageFactory.initElements(driver, EbayHomePage.class);
    }
}
