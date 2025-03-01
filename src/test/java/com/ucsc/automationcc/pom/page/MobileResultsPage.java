package com.ucsc.automationcc.pom.page;

import com.ucsc.automationcc.pom.util.ExtentReportManager;
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
        try{
            new Actions(driver).scrollByAmount(0,50).perform();
            chkApple.click();
            ExtentReportManager.logPass("Click on checkbox : "+chkApple.toString());
        }catch (Exception e){
            ExtentReportManager.logFail("No such locator : "+chkApple.toString());
        }

    }
}
