package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase
{


    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://telranedu.web.app/home");
    }

    @AfterMethod(enabled = false)
    public void tearDown()
    {
        driver.quit();
    }

    public boolean isPhoneComponentPresent()
    {
        return driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1")).size()>0; //if one element will be found. this method is not universal
    }

    public boolean isElementPresent(By locator) //refuctoring
    {
       return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        //driver.findElement(By.cssSelector("[placeholder='Email']")).clear();
        driver.findElement(locator).clear();
        //driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("Mashamasha@gmail.com");
        driver.findElement(locator).sendKeys(text);
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
            return true;
        }
    }
}
