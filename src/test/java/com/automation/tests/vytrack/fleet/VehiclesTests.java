package com.automation.tests.vytrack.fleet;

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

import static org.testng.Assert.assertEquals;

public class VehiclesTests {

    private WebDriver driver;

    private String URL2 = "https://qa2.vytrack.com/entity/Extend_Entity_Carreservation";
    private String URL = "http://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2"); //By.id("prependedInput") == passwordBy => same thing
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By fleetBy = By.xpath("//*[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private By pageNumberBy = By.cssSelector("input[type='number']");


    @Test(description = "verify that subtitle is equal to All Cars")
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);

        driver.findElement(fleetBy).click(); // click on fleet

        BrowserUtils.wait(3); // wait

        WebElement subTitleElement = driver.findElement(subtitleBy); // get this element
        System.out.println(subTitleElement.getText()); // get the text

        String expected = "All Cars";
        String actual = subTitleElement.getText();

        Assert.assertEquals(actual, expected);


    }

    /**
     *
     *     ################ TASK 7 minutes until 3:48
     *
     *     Given user is on the vytrack landing page
     *     When user logs on as a store manager
     *     Then user navigates to Fleet --> Vehicles
     *     And user verifies that page number is equals to "1"
     */
    @Test
    public void verifyPageNumber(){
        String expected = "1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");
        Assert.assertEquals(actual, expected);
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
/*######## TASK
        under fleet package create a class called VehiclesPageTests
        In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part. Use LoginPageTests class as a reference.
        create a test called verifyPageSubTitle
        - in this test, you will need to navigate to Fleet --> Vehicles and verify that page subtitle is equals to "All Cars"
        user assertions for validation.

 */