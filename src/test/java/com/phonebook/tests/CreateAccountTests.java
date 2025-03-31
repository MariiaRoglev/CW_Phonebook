package com.phonebook.tests;


import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase

{

    SoftAssert softAssert=new SoftAssert();//inicialization

    @BeforeMethod
    public void ensurePrecondition()
    {
        if(!app.getUser().isLoginLinkPresent())
        {
            app.getUser().clickOnSignOutBTN();
        }
    }




    @Test(enabled = false)

    public void newUserIsRegistered()
    {
        app.getUser().clickOnLoginLink();
        app.getUser().enterEmailAndPWD(new User().setMail("kashamasha@gmail.com").setPwd("QwertyQwerty1!"));
        app.getUser().clickOnRegButton();
        Assert.assertTrue(app.getUser().isSignOutDisplayed());
    }

    @Test
    public void existedUserIsRegistered()
    {
        app.getUser().clickOnLoginLink();
        app.getUser().enterEmailAndPWD(new User().setMail("kashamasha@gmail.com").setPwd("QwertyQwerty1!"));
        app.getUser().clickOnRegButton();
        softAssert.assertTrue(app.getUser().isAlertDisplayed()); //First Alert
        softAssert.assertTrue(app.getUser().isErrorMessagePresent()); //Second Alert
        softAssert.assertAll(); //must for soft Assert!
}


}
