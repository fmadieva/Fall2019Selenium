package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ExplicitWait {
    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
    }


    @Test
    public void waitForTitle(){
        driver.get("https://google.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleContains("Google"));
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
//wait up to 10 seconds until title contains google
//ExpectedConditions is a class , we use it for explicit wait;
//ExpectedCondition is interface it's usage is different, we will use it in fluent wait
 //     wait.until(ExpectedConditions.titleContains("Google"));
//when condition fails => we will get exception.
//by default it will check every 500 milliseconds => means that it checked 20 times until find the element
//Exception :
//org.openqa.selenium.TimeoutException: Expected condition failed:
//waiting for title to contain "Amazon". Current title: "Google" (tried for 10 second(s) with 500 milliseconds interval)