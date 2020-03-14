
package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {

       System.setProperty("webdriver.chrome.driver", "chromedriver");
        //setup chromedriver
        WebDriverManager.chromedriver().setup();
        //create chromedriver object
        ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.quit();







//        System.setProperty("webdriver.chrome.driver","src/test/java/com/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
////open some website
//        driver.get("http://google.com");

    }
}