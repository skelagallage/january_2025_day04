package com.ucsc.automationcc.pom.test;

import com.ucsc.automationcc.pom.page.BasePage;
import com.ucsc.automationcc.pom.page.EbayHomePage;
import com.ucsc.automationcc.pom.page.MobileResultsPage;
import com.ucsc.automationcc.pom.page.TShirtResultsPage;
import org.testng.annotations.Test;

public class EbayTest extends BaseTest{

    @Test
    public void mobilePhoneSearch(){
        BasePage basePage = new BasePage(driver);
        EbayHomePage ebayHomePage = basePage.initApp("https://www.ebay.com/");
        ebayHomePage.typeOnSearchBox("mobile phone");
        ebayHomePage.selectCategoryByVisibleText("Cell Phones & Accessories");
        MobileResultsPage mobileResultsPage = ebayHomePage.clickOnSearchButton(MobileResultsPage.class);
        mobileResultsPage.clickOnAppleCheckBox();

    }

    @Test
    public void tShirtSearch(){
        BasePage basePage = new BasePage(driver);
        EbayHomePage ebayHomePage = basePage.initApp("https://www.ebay.com/");
        ebayHomePage.typeOnSearchBox("T-shirt");
        ebayHomePage.selectCategoryByVisibleText("Clothing, Shoes & Accessories");
        TShirtResultsPage tShirtResult = ebayHomePage.clickOnSearchButton(TShirtResultsPage.class);
        tShirtResult.clickOnAdidasCheckBox();

    }
}
