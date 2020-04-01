package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.tests.vytrack.TestBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {


    @Test
    public void verifyPageTitle(){
        //test --> ExtentTest object
        //we must add to every test at the beginning
        //test = report.createTest("Test name");
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboa");
        test.pass("Page title Dashboard was verified");
    }

    /**
     * Enter wrong credentials and verify warning message
     *
     */

    @Test
    public void verifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        // takes a screenshot
        BrowserUtils.getScreenshot("warningMessage");
    }
}