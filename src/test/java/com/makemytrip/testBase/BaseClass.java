package com.makemytrip.testBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

/**
 * 6/4/2023
 * 9:50 AM
 */
public class BaseClass {
    protected  static JavascriptExecutor executor;
    protected static WebDriver driver;
    @BeforeTest()
    public void setDriver(){
        driver=new ChromeDriver ();
        executor=(JavascriptExecutor)driver;
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
        driver.manage ().timeouts ().pageLoadTimeout ( Duration.ofSeconds ( 10 ) );
        driver.get ( "https://www.makemytrip.com/" );
    }
    @AfterTest()
    public void close(){
        driver.close ();
    }
}
