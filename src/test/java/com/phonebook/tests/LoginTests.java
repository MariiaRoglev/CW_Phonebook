package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @Test
    public void loginPositiveTests()
    {
        click(By.cssSelector("[href='/login']"));

        //enter email
        type(By.name("email"), "kashamasha@gmail.com");

        //enter pwd
        type(By.name("password"), "QwertyQwerty1!");

        //click on Login button
        click(By.name("login"));

        //verify SignOut button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }



}
