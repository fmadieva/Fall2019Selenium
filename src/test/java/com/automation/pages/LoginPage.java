package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="prependedInput") // this is how you find the username
    private WebElement username;

    @FindBy(id="prependedInput2") // finding password locator
    private WebElement password;

    @FindBy(id="_submit")  // <button type="submit" class="btn btn-uppercase btn-primary pull-right" id="_submit" name="_submit">Log in</button>
    private WebElement login;  // finding the login button ( id -locator = "_submit" is its value)

    @FindBy(linkText = "Forgot your password?") // <a href="/user/reset-request">Forgot your password?</a>
    private WebElement forgotPassword;           //


    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public LoginPage(){
        // to connect our webdriver, page class and page factory
        // pageFactory - used to use @FindBy annotations
        // PageFactory - helps to find elements easier
        //PageFactory.initElements(Driver.getDriver(), LoginPage.class); // it will always be the same in all classes.
        // or like this -->
        PageFactory.initElements(Driver.getDriver(), this);

    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }


    /**
     * Method to login, version #1
     * Login as a specific user
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }
    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
    }

}


//Notes

//PageFactory.initElements(Driver.getDriver(), LoginPage.class);
// required to put into constructor of every page class

//What is webdriver? --> getDriver()
// what the page class? --> the name of the class or the keyword this.

// @FindBy(id="submit")
// id is locator type
// "submit" is locator's value


