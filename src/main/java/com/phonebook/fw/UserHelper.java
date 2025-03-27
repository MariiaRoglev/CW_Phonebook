package com.phonebook.fw;

import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper
{
    public UserHelper(WebDriver driver)
    {
        super(driver);
    }


    //REFUCTORING
    public void clickOnRegButton()
    {
        click(By.name("registration"));
    }

    public void enterEmailAndPWD(User user)
    {
        type(By.name("email"), user.getMail()); //from class user
        type(By.name("password"), user.getPwd()); //from class user
    }

    public void clickOnLoginLink()
    {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutDisplayed()
    {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isErrorMessagePresent()
    {
        return isElementPresent(By.cssSelector(".login_login__3EHKB>div"));
    }
}
