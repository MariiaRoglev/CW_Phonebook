package com.phonebook.tests;

import com.phonebook.data.UserData;
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
        logger.info("Login with Data-->"+"*****"+UserData.PASSWORD);
        app.getUser().clickOnLoginLink();
        app.getUser().enterEmailAndPWD(new User().setMail(UserData.EMAIL).setPwd(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutDisplayed());
    }

    @Test //Ctrl+D = Duplicate test
    public void loginNegativeTestsEmptyEmailField()
    {
        app.getUser().clickOnLoginLink();
        app.getUser().enterEmailAndPWD(new User().setPwd(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertDisplayed());
    }



}
