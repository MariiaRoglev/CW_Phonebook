package com.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper
{
    public HomePageHelper(WebDriver driver)
    {
        super(driver);
    }

    public boolean isPhoneComponentPresent()
    {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1")); //if one element will be found. this method is not universal
    }
}
