package com.automation.tests.vytrack.login;

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

//STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;
    //https is a secured version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it
    private String URL = "http://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput"); //By.id("prependedInput") == passwordBy => same thing
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    @Test(description = "verify that warning message is displaced when user enters invalid username")
    public void invalidUserName(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
    }

    @Test(description = "Login as store manager and verify that tile is equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);
        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(actual, expected, "Page title is not correct!");
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void teardown(){
        if ( driver != null ){ // if driver object alive
            driver.quit(); // close browser, close session
            driver = null; // destroy webdriver driver object for sure
        }

    }
}

/*
html5 warning message attribute
this warning message can not be catched with locator
it some kind of attribute coming from html
you can not catch it, there is a method getAttribute
you can just read it
 */