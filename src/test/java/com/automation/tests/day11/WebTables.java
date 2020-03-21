package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class WebTables {

    private WebDriver driver;




    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        // headless mode makes execution twice faster
        // it does everything except file uploading
        // set it to true to make it work
        chromeOptions.setHeadless(true); // to run browser without GUI. Makes browser invisible
        driver = new ChromeDriver(chromeOptions);

        //driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }

    @Test
    public void getColumnNames() {
        //th - represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
        //BrowserUtils.getTextFromWebElements(columnNames) ==>
        // this method takes the text of every single webElement and puts it into collection of strings
    }

    @Test
    public void verifyRowCount(){
        //  //tbody//tr - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));

        //if we will get a size of this collection, it automatically equals to number of elements
        Assert.assertEquals(rows.size(), 4);

        //expected result => 4 => number of rows
        //actual result => size of the collection(rows.size())

    }

    /*
    To get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn(){
        // td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));

    }
}

//first way :
//once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
//td element with email and td element that contains delete => are siblings
////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
//to make it easier :
//go back to parent and find link that has text delete
//td is child of tr
////td[text()='fbach@yahoo.com']/..//a[text()='delete']
//even more simple way :
//it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change ilocator will never find it
//go to find email in the first table go to parent go to second link inside this element
////table[1]//td[text()='jsmith@gmail.com']/..//a[2]