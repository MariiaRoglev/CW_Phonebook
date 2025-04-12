package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        app.getUser().enterEmailAndPWD(new User().setMail(UserData.EMAIL).setPwd(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }


    @Test
    public void addNewContactPositiveTests()
{
    app.getContact().clickOnAddLink();
    app.getContact().fillInAllFields(new Contact().setName(ContactData.Name).setLastName(ContactData.LastName).setPhone(ContactData.Phone).setEmail(ContactData.Email).setAddress(ContactData.Address).setDescription(ContactData.Description));
    app.getContact().clickOnSaveBTN();
    Assert.assertTrue(app.getContact().isContactAdded(ContactData.Name));
}


//---------------------------------------

@Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)//to take data from Data Provider
    public void addNewContactPositiveFromDataProviderTests(String name,String lastName, String phone, String email, String address, String description)
{
    app.getContact().clickOnAddLink();
    app.getContact().fillInAllFields(new Contact().setName(name).setLastName(lastName).setPhone(phone).setEmail(email).setAddress(address).setDescription(description));
    app.getContact().clickOnSaveBTN();
    Assert.assertTrue(app.getContact().isContactAdded(name));
}


@Test(dataProvider = "addNewContactWithCsv", dataProviderClass = DataProviders.class)//to take data from Data Provider
    public void addNewContactPositiveFromDataProviderWithCsvFileTests(Contact contact)
{
    app.getContact().clickOnAddLink();
    app.getContact().fillInAllFields(contact);
    app.getContact().clickOnSaveBTN();
    Assert.assertTrue(app.getContact().isContactAdded(contact.getName()));
}







//---------------------------------------


    @AfterMethod
    public void postCondition()
    {
        app.getContact().deleteContact();
    }


}


