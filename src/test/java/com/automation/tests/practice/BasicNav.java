package com.automation.tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNav {
    public static void main(String[] args) throws Throwable{

        WebDriverManager.chromedriver().setup(); // to set chrome driver
        ChromeDriver driver = new ChromeDriver(); // to create an object of Chrome driver
        String url = "http://google.com";
        String url2 = "http://amazon.com";

        driver.get(url); // to open url, open some website
        Thread.sleep(3000);
        driver.navigate().to(url2); // load  a new web page in the current browser window


        driver.navigate().back(); //  Move in the browser history to the previous URL
        driver.navigate().forward(); // Move forward in the browser history, does nothing if we are on the latest page viewed.
        driver.navigate().refresh(); // load a new web page in the current browser window

        driver.close(); //  this closes only 1 window
        // driver.quit(); // this quits all the windows


    }
}
