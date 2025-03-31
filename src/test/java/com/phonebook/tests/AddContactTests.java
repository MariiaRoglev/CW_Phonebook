package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase
{
    @BeforeMethod
    public void precondition()
    {
        if(!app.getUser().isLoginLinkPresent())
        {
            app.getUser().clickOnSignOutBTN();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().enterEmailAndPWD(new User().setMail("kashamasha@gmail.com").setPwd("QwertyQwerty1!"));
        app.getUser().clickOnLoginButton();
    }


    @Test
    public void addNewContactPositiveTests()
{
    app.getContact().clickOnAddLink();
    app.getContact().fillInAllFields(new Contact().setName("Pasha").setLastName("Petrov").setPhone("1234567890").setEmail("Petrov@gmail.com").setAddress("Israel,Haifa").setDescription("qazwsx"));
    app.getContact().clickOnSaveBTN();
    Assert.assertTrue(app.getContact().isContactAdded("Pasha"));
}

    @AfterMethod
    public void postCondition()
    {
        app.getContact().deleteContact();
    }


}


