package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
            }
        }
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
