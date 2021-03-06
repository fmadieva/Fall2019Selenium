package com.automation.tests.day8TestNG;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        // since every search item has a tag name <h3>
        // It's the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem: searchItems){
            String var = searchItem.getText();
            // if there is a text- print it
            if (!var.isEmpty()){
                System.out.println("var = " + var);
                //verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));

            }
        }
    }

    /**
     * Given user is on the amazon.com page
     * When user enters "java" as a search item
     * Then user clicks on the search button
     * And user clicks on the first search item
     * And user verifies taht title of the search item contains "Java"
     */
    @Test(description = "Search for Java book on Amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        BrowserUtils.wait(3);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(3);

        List<WebElement> searchItems = driver.findElements(By.tagName("h2"));

        searchItems.get(0).click();
        BrowserUtils.wait(5);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println("productTitleString = " + productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));
    }


    @BeforeMethod // set up
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }

    @AfterMethod // clean up
    public void teardown(){
        // close browser and destroy driver object
        driver.quit();
    }
}


//test without assertion is useless - what makes test => test
//without assertion you can not understand test has passed or failed
