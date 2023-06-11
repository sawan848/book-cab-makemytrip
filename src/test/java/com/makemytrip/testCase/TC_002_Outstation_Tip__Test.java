package com.makemytrip.testCase;

import com.makemytrip.pageObjects.CarPage;
import com.makemytrip.testBase.BaseClass;
import com.makemytrip.testUtils.ExcelUtility;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * 6/4/2023
 * 11:04 AM
 */
public class TC_002_Outstation_Tip__Test extends BaseClass {
    private CarPage carPage;

    @BeforeClass
    public void setupClass(){
        carPage=new CarPage ( driver );

    }
    @Test()
    public void test_from_to() {
     logger.info ( "***** STARTING TC_002_Outstation_Tip__Test  *****" );
        try {
        carPage.clickFrom ();
        carPage.setFromElement ( "Delhi" );
        logger.info ( " Set Delhi to the input box" );
        carPage.clickToBtn ();
        carPage.setToElement ( "Man" );
        logger.info ( " Set Manali to the input box" );
        }catch (Exception e){
            e.printStackTrace ();
        }

    }
    @Test(priority = 1)
    public void test_departure_date(){
        try {

     FluentWait<WebDriver>fluentWait=new FluentWait<> (  driver)
                .ignoring( ElementClickInterceptedException.class).
                pollingEvery( Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(30));

       fluentWait.until ( driver -> {
           carPage.setDepartureElement ();
           return true;
       } );

       new WebDriverWait ( driver,Duration.ofSeconds ( 5 ) ).
               until ( ExpectedConditions.visibilityOf (
                       carPage.getDayPickerElement ()
               ) );
       carPage.setCalenderDayMonth ( "Mon","Jun","12","2023" );
       logger.info ( "set the departure day and month  " );
    }catch (Exception e){
            Assert.fail ();
        }
    }
    @Test(priority = 2)
    public void test_return_date(){
        try {

        FluentWait<WebDriver>fluentWait=new FluentWait<> (  driver)
                .ignoring( ElementClickInterceptedException.class).
                pollingEvery( Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(30));

        fluentWait.until ( driver -> {
            carPage.setReturnElement ();
            return true;
        } );
        carPage.setCalenderDayMonth ( "Thu","Jul","20","2023" );
            logger.info ( "set the return day and month  " );

        }catch (Exception e){
            e.printStackTrace ();
        }

    }

    @Test(priority = 3)
    public void test_pickup_time() {
        try {

        Thread.sleep ( 3000 );
        executor.executeScript ( "arguments[0].click()",carPage.getPickUpLabel () );
        carPage.setPickupTime ();
        carPage.clickPickupTimeBtn ();
            logger.info ( "set the pickup time  " );

        }catch (Exception e){
            e.printStackTrace ();
        }

    }

    @Test(priority = 4)
    public void test_drop_time() {
        try {

        Thread.sleep ( 3000 );
        executor.executeScript ( "arguments[0].click()",carPage.getDropLabel () );
        carPage.setPickupTime ();
        executor.executeScript ( "arguments[0].scrollIntoView(true);",carPage.setNextApplyBtn () );
        executor.executeScript ( "arguments[0].click();",carPage.setNextApplyBtn ()  );
        carPage.clickSearchBtn ();
        logger.info ( "set the drop time   " );

        }catch (Exception e){
            e.printStackTrace ();
        }


    }

    @Test(priority = 5)
    public void test_lowest_charges() {
        try {

        Thread.sleep ( 5000 );
        carPage.setSortedByElement ();
        carPage.setLowestToHighestPrice ();
        carPage.clickSuvLabel ();
        String suvPrice=carPage.getSuvPrice ();
        System.out.println ( "suvPrice = " + suvPrice );
        excelUtility.setCellData ( "Sheet3",0,0,"Suv Price" );
        excelUtility.setCellData ( "Sheet3",0,1,suvPrice );
        logger.info ( "store the lowest price of the suv the excel sheet   " );

        }catch (Exception e){
            e.printStackTrace ();
        }
        logger.info ( "***** END TC_002_Outstation_Tip__Test  *****" );
    }

}
