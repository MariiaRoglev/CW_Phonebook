package com.phonebook.fw;

import com.phonebook.utils.MyListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.Duration;

public class ApplicationManager {
    String browser;
    WebDriver driver;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

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
            logger.info("Test starts in Chrome browser"); //also can write it for another browser

        }

        WebDriverListener listener = new MyListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);


//        else if(browser.equalsIgnoreCase("firefox"))//FOR ANOTHER BROWSER
//        {
//            driver.new FirefoxDriver();
//        }
//        else if(browser.equalsIgnoreCase("edge"))//FOR ANOTHER BROWSER
//        {
//            driver.new EdgeDriver();
//       }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://telranedu.web.app/home");
        logger.info("Current URL-->"+driver.getCurrentUrl());

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
