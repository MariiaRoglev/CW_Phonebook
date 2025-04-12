package com.phonebook.fw;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;

    UserHelper user;
    ContactHelper contact;
    HomePageHelper home;

    public ApplicationManager(String browser) {
        this.browser = browser;

    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

//        else if(browser.equalsIgnoreCase("firefox"))
//        {
//            driver.new FirefoxDriver();
//        }
//        else if(browser.equalsIgnoreCase("edge"))
//        {
//            driver.new EdgeDriver();
//        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://telranedu.web.app/home");

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }


    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHome() {
        return home;
    }


}
