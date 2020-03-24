package com.automation.tests.practice.selfPractice;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class March22 {
     private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    @Test
    public void zipCodeUpdate(){
        WebElement hisOldZip = driver.findElement(By.xpath("//td[text()='Mark Smith']//following-sibling::td[7]"));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
