package PageObjects;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BasePage {
    static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void ExplicityWaitIsClickable(WebElement elementString) {
        {
            try {

                for (int i = 0; i < 3; i++)
                    try {
                        WebDriverWait wait;
                        wait = new WebDriverWait(driver, 10);
                        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementString));
                        element.click();
                        break;
                    } catch (Exception e) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }

                    }
            } catch (Exception e) {
                System.err.println("\nError : ExplicityWaitIsClickable failed\n");
            }
        }


    }

    public void clear(WebElement el) {
        el.clear();
    }

    public void filltext(WebElement sk, String text) {
        sk.clear();
        sk.sendKeys(text);
    }

    public void click(WebElement el) {
        el.click();
    }

    public static boolean ElementDisplay(WebElement elementString) {
        WebElement webElement = (elementString);

        return webElement.isDisplayed();
        //return ElementIsDisplyed(elementString);
    }

    public String getText(WebElement el) {
        return el.getText();
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void TakeScreenShot() throws IOException {

        String folder_name = "/Users/yinonwishi/Downloads/screenshoots/";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy__hh_mm_ssaa");
        new File(folder_name).mkdir();
        String file_name = df.format(new Date()) + ".png";
        FileUtils.copyFile(scrFile, new File(folder_name + "/" + file_name));

    }
    public void WaitElementDosplayed(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void scrollDown()
    {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,450)", "");
    }


}