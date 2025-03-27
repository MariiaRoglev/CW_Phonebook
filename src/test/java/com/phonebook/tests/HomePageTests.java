package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase //extends TestBase -> extent for class TestBase
{

    @Test
    public void isHomeComponentPresentTest() //for calling the method
    {
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //System.out.println("Home_Component "+isPhoneComponentPresent());
        Assert.assertTrue(app.getHome().isPhoneComponentPresent());
    }


//assert-need to remind
// no need to print in tests








}
