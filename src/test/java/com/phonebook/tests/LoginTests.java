package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase
{
    @BeforeMethod
    public void ensurePrecondition()
    {
        if(!app.getUser().isLoginLinkPresent())
        {
            app.getUser().clickOnSignOutBTN();
        }
    }


    @Test(priority = 1)
    public void loginPositiveTests()
    {
        app.getUser().clickOnLoginLink();
        app.getUser().enterEmailAndPWD(new User().setMail("kashamasha@gmail.com").setPwd("QwertyQwerty1!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutDisplayed());
    }

    @Test(priority = 2) //Ctrl+D = Duplicate test
    public void loginNegativeTestsEmptyEmailField()
    {
        app.getUser().clickOnLoginLink();
        app.getUser().enterEmailAndPWD(new User().setPwd("QwertyQwerty1!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }



}
