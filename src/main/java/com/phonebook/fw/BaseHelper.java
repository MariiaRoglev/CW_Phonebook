package com.phonebook.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class BaseHelper
{
    WebDriver driver;

    public BaseHelper(WebDriver driver)
    {
        this.driver=driver;
    }

    public boolean isElementPresent(By locator) //refuctoring
    {
       return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text)
    {
        if(text!=null)
        {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertDisplayed() //Method: need to know that we have an Alert
    {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        if (alert == null)
        {
            return false;
        } else
        {
            driver.switchTo().alert();
            alert.accept();//click on Ok button in Alert
            return true;
        }
    }

    //need to wait Delete before assertion
    public void pause (int millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //to take screenshot
    public String takeScreenshot() throws IOException {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");


        try
        {
            Files.copy(tmp, screenshot);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return screenshot.getAbsolutePath();
    }

}
