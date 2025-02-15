package com.ucsc.automationcc.pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MobileResultsPage extends BasePage {


    @FindBy(xpath = "//span[text()='Apple']")
    private WebElement chkApple;

    public MobileResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAppleCheckBox(){
        new Actions(driver).scrollByAmount(0,50).perform();
        chkApple.click();
    }
}
