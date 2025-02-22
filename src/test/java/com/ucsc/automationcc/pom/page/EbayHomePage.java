package com.ucsc.automationcc.pom.page;

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
        searchBox.sendKeys(text);
    }

    public void selectCategoryByVisibleText(String visibleText){
        new Select(categorySelect).selectByVisibleText(visibleText);
        searchingCategory = visibleText;
    }

    public <T> T clickOnSearchButton(Class<T> pageType){
        searchButton.click();
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
