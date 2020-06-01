package seleniumPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

public class Checkbox {
    private WebDriver driver;

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");



    }

    @AfterMethod
    public void teardown(){
        driver.close(); // closes that specific page, quit() quits everything.
        System.exit(0); // whatever we have opened closes everything

    }

    /*
    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed, take a screenshot
        //no failure - no screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = BrowserUtils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName());//attach test name that failed
            BrowserUtils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath, "Failed");//attach screenshot
            test.fail(iTestResult.getThrowable());//attach console output
            //if excelUtil object was created
            //set value if result column failed
            if(excelUtil!=null){
                excelUtil.setCellData("FAILED","result",row++);
            }
        }
        BrowserUtils.wait(2);
        Driver.closeDriver();
    } 

    */

}
