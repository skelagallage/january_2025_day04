package com.ucsc.automationcc.pom.page;

import com.ucsc.automationcc.pom.util.ExtentReportManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EbayHomePage extends BasePage {

    private String searchingCategory;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchBox;

    @FindBy(id="gh-cat")
    private WebElement categorySelect;

    @FindBy(id = "gh-search-btn")
    private WebElement searchButton;

    public EbayHomePage(WebDriver driver) {
        super(driver);
    }

    public void typeOnSearchBox(String text){
        try{
            searchBox.sendKeys(text);
            ExtentReportManager.logPass("Typed "+text+" in locator : "+searchBox.toString());
        }catch (Exception e){
            ExtentReportManager.logFail("No such locator : "+searchBox.toString());
        }


    }

    public void selectCategoryByVisibleText(String visibleText){
        try {
            new Select(categorySelect).selectByVisibleText(visibleText);
            searchingCategory = visibleText;
            ExtentReportManager.logPass("Selected ["+visibleText+"] in locator : "+categorySelect.toString());
        }catch (Exception e){
            ExtentReportManager.logFail("No such locator : "+categorySelect.toString());

        }

    }

    public <T> T clickOnSearchButton(Class<T> pageType){
        try{
            searchButton.click();
            ExtentReportManager.logPass("Click in locator : "+searchButton.toString());
        }catch (Exception e){
            ExtentReportManager.logFail("No such locator : "+searchButton.toString());
        }

//        return PageFactory.initElements(driver, MobileResultsPage.class);
//        return PageFactory.initElements(driver, TShirtResultsPage.class);
//        if(searchingCategory.equals("Cell Phones & Accessories")){
//            return PageFactory.initElements(driver, (Class<T>) MobileResultsPage.class);
//        } else if (searchingCategory.equals("Clothing, Shoes & Accessories")) {
//            return PageFactory.initElements(driver, (Class<T>) TShirtResultsPage.class);
//        }

//        return null;
        return PageFactory.initElements(driver, pageType);
    }
}
