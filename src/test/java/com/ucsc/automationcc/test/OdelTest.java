package com.ucsc.automationcc.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class OdelTest {

    WebDriver driver = null;

    @BeforeClass
    public void initBrowser() throws InterruptedException {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://odel.lk/home");
        //Thread.sleep(5000);

    }

    @Test
    public void searchWomenHat() throws InterruptedException {
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div/a[text()='WOMEN']"))).perform();
        //Thread.sleep(5000);
        By byCapsAndHats = By.xpath("//a[@href='/women/accessories/caps-hats/sc/3675']");
        new Actions(driver).moveToElement(driver.findElement(byCapsAndHats)).perform();
        //Thread.sleep(5000);
        driver.findElement(byCapsAndHats).click();
        //Thread.sleep(5000);
        driver.findElement(By.id("brand_filter_button")).click();
        //Thread.sleep(5000);
        By byOdelCheckBox = By.xpath("//label[text()='ODEL']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byOdelCheckBox)));
        driver.findElement(byOdelCheckBox).click();
        //Thread.sleep(5000);
        new Actions(driver).scrollByAmount(0, 300).perform();
        //Thread.sleep(5000);
    }

    @AfterClass
    public void quitBrowser(){
        driver.quit();
    }
}
