package com.makemytrip.testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * 5/25/2023
 * 9:16 PM
 */
public class MakeMyTripTest {
    WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver=new EdgeDriver ();
        driver.manage ().window ().maximize ();
        driver.get ( "https://www.makemytrip.com/" );
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 5 ) );
        driver.manage ().timeouts ().pageLoadTimeout ( Duration.ofSeconds ( 5 ) );
    }

    @Test()
    public  void testFromTo()throws Exception{
        driver.findElement ( By.xpath ("//*[@id=\"SW\"]/div[1]/div[1]/a/picture/img" ) ).click ();
        driver.findElement(By.linkText("Cabs")).click();

        driver.findElement(By.xpath("//li[text()='OUTSTATION ROUND TRIP']")).click();

        driver.findElement(By.xpath("//span[text()='From']")).click();
        driver.findElement(By.xpath("//p[@class='searchedResult font14 darkText']/span[text()='Delhi']")).click();

        WebElement toElement=driver.findElement(By.xpath("//span[text()='To']"));
        toElement.click ();
        driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys ( "Manali" );

        driver.findElement ( By.xpath ( "//p[@class='searchedResult font14 darkText']/span[text()='Manali, Himachal Pradesh, India']" ) ).click ();
    }
    @AfterTest
    public void tearDown(){
        if ( driver!=null ) {
            driver.quit ();
        }
    }
}
