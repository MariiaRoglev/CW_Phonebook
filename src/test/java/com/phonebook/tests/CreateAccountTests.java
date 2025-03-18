package com.phonebook.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @Test
    public void newUserIsRegistered() {
        //click on Login button
        click(By.cssSelector("[href='/login']"));

        //enter email
        //driver.findElement(By.cssSelector("[placeholder='Email']")).click();
        type(By.name("email"), "kashamasha@gmail.com");

        //enter pwd
        type(By.name("password"), "QwertyQwerty1!");

        //click on Registration button
        click(By.name("registration"));

        //verify SignOut button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test (enabled = false)
    public void existedUserIsRegistered()
    {
        click(By.cssSelector("[href='/login']"));

        type(By.name("email"), "kashamasha@gmail.com");

        //enter pwd
        type(By.name("password"), "QwertyQwerty1!");

        //click on Registration button
        click(By.name("registration"));

        //verify SignOut button does not displayed. Alert (display is blocked) displayed
    Assert.assertTrue(isAlertDisplayed());

}


}
