package com.ucsc.automationcc.pom.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TShirtResultsPage extends BasePage {


    @FindBy(xpath = "//span[text()='adidas']")
    private WebElement chkAdidas;

    public TShirtResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAdidasCheckBox(){
        new Actions(driver).scrollByAmount(0,400).perform();
        chkAdidas.click();
    }
}
