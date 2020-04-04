package com.automation.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    /**
     * Pause test for some time
     *
     * @param seconds
     */
    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param elements represents collection of WebElements
     * @return collection of strings
     */
    public static List<String> getTextFromWebElements(List<WebElement> elements) {
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            if (!element.getText().isEmpty()) {
                textValues.add(element.getText());
            }
        }
        return textValues;
    }

    /**
     * waits for backgrounds processes on the browser to complete
     *
     * @param timeOutInSeconds
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenshot(String name) {
        //adding date and time to screenshot name, to make screenshot unique
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        //where we gonna store a screenshot
        String path = "";

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }

        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);
        //since our reference type is a WebDriver
        //we cannot see methods from TakesScreenshot interface
        //that's why do casting
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        //take screenshot of web browser, and save it as a file
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //where screenshot will be saved
        File destination = new File(path);
        try {
            //copy file to the previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
//    /test-output/ -->  result
//    screenshots --> folder
//    png --> extention

/*
 name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name; // adding date and time to screenshot name  *if you want date to show first, just move the name to the right.
        String path = System.getProperty("user.dir")+"/test-output/screenshots/"+name+".png"; // location  where the screenshot would be stored in
        System.out.println("Screenshot is here: "+ path);
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver(); // since our reference type is webDriver we cannot see methods from TakesScreenshot Interface, thats why we do casting.
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE); // it takes a screenshot of the web browser and saves it as a file object // this line does the job
        File destination = new File(path); // where we will save the screenshot
        try{
            FileUtils.copyFile(source, destination); // copy file to the previously specified location
        }catch( IOException e) {
            e.printStackTrace();
        }
        return path;

 */