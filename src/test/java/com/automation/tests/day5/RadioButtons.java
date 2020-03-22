package com.automation.tests.day5;
// March 7, 2020
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args){
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        //<input type="radio">
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));



        for(WebElement radioButton: radioButtons){

            //<input type="radio" id="red" name="color">
            String id = radioButton.getAttribute("id");

            //returns true if button already clicked
            boolean isSelected = radioButton.isSelected();
            System.out.println(id+" is selected? "+isSelected);

            //if button is eligible to click
            //returns true of you can click on the button
            if(radioButton.isEnabled()) {

                radioButton.click();
                System.out.println("Clicked on :: "+id);
                BrowserUtils.wait(1);

            } else {
                System.out.println("Button is disabled, not clicked :: "+id);
            }
            System.out.println();
        }

        driver.quit();
    }
}
/*
Agenda:
radio buttons
check boxes
-- isDisplayed()
-- isSelected()
-- isEnabled()
frames

##################################
WebElement element = findElement
List<WebElement> elements = findElements


<input type="radio" >

Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()? -- make sure that you don't use webdriver object after quit() method, it should be at the end of your test script.

.isEnabled() - returns true, if button can be clicked, otherwise - false.
.isSelected() - returns true, if button already clicked, otherwise - false.
.isDisplayed() - returns true, if element is visible. Applies to any kind of webelement, not only radio buttons.

NOTE: if element doesn't exists at all, you will get - NoSuchElementException.
This method will not work if element doesn't present in the HTML code.
To verify if element is not in HTML code at all, use findElements().size() == 0.


driver.findElements(By.by()).size() == 0;

<input type="radio" id="red" name="color">

radioButton.getAttribute("id"); --> red

radioButton.getAttribute("type"); --> radio

radioButton.getAttribute("name"); --> color

getText() ---> nothing

<tag>Text</tag>

Priority:
1. element must be present
2. element must be visible
3. element must be enabled

frame - used to insert one HTML document on another one. There are 2 type of frames: frame and iframe.

<frame> - to divide page on sectors
<iframe> - to insert one page inside another one, anywhere.

iframes - usually used to display adds.

To be able to interact with the content inside a frame, you need to switch to it.

driver.switchTo().frame("nameOrId"); by id or name of the frame
driver.switchTo().frame(index); by frame index, starting from 0

if there is only 1 frame = index will be 0

if there are 2 frames - first one will have index 0, second one index 1.
Counting - is from top to bottom.

WebElement frameElement = driver.findElement(By.className("someFrame"));
driver.switchTo().frame(frameElement);

if frame doesn't have a name or id, and index doesn't give accurate frame position, use webelement.

usually, all frames have id or name;

driver.switchTo().defaultContent() - to exit from the frame. If you don't exit, selenium will not see the content outside of this frame.


List<List<String>> -- nested frame

Windows:

First, go to the folder that contains the file you're interested in. The easiest way of copying a file path is to hold down the Shift key on your keyboard and then right-click on the file. (That displays extra functionality in the context menu). Then, choose "Copy as path" from the menu. This trick will also work on folders, if you want to copy the folder path. Even if the path doesn't contain any spaces, Windows will still automatically surround it with double-quotes.


Mac:

Right click on the file --> press and hold option button --> copy as a path name

To upload file in Selenium: you need to use sendKeys() method and provide path to the file.
######################################

isDisplayed() --- to check if element is visible
returns false if element in the DOM, but hidden.

isEnabled() --- to check if element is intractable (if you can do something with this element)

isSelected() --- returns true, if radio button or check box is already clicked

frames - to insert another HTML document. Content inside a frame is not visible for selenium by default, that's why you have to switch:

driver.switchTo().frame()

you can switch based on id/name, index, WebElement.

driver.switchTo().parentFrame() - if you are inside a child frame, switch to parent

driver.switchTo().defaultContent() - exit from all frames to original document.

to upload file, just use sendKeys() method and specify path to the file from your computer.
 */
