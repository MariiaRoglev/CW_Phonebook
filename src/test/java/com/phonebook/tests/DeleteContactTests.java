package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    //Precondition
    //add contact
    //delete contact

    //click on the cart
    //click on Remove button
    //verify that the contact ids deleted (by size)

    @BeforeMethod
    public void precondition()
    {
        if(!app.getUser().isLoginLinkPresent())
        {
            app.getUser().clickOnSignOutBTN();
        }

        app.getUser().clickOnLoginLink();
        Assert.assertTrue(app.getContact().isContactAdded(ContactData.Name));
        app.getUser().enterEmailAndPWD(new User().setMail(UserData.EMAIL).setPwd(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getContact().clickOnAddLink();
        app.getContact().fillInAllFields(new Contact().setName(ContactData.Name).setLastName(ContactData.LastName).setPhone(ContactData.Phone).setEmail(ContactData.Email).setAddress(ContactData.Address).setDescription(ContactData.Description));
        app.getContact().clickOnSaveBTN();

        Assert.assertTrue(app.getContact().isContactAdded(ContactData.Name));
    }

    @Test
//    public void deleteContactTests()
//    {
//        int sizeBefore = app.getContact().sizeOfContacts();
//        app.getContact().click(By.cssSelector(".contact-item_card__2SOIM"));
//        app.getContact().click(By.xpath("//button[.='Remove']"));
//        app.getContact().pause(1000);
//        int sizeAfter = app.getContact().sizeOfContacts();
//        Assert.assertEquals(sizeAfter,sizeBefore-1);
//    }

    public void deleteContactTests() {
        int sizeBefore = app.getContact().sizeOfContacts();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContact().sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
