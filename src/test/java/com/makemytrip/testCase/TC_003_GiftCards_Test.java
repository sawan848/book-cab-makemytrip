package com.makemytrip.testCase;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.makemytrip.pageObjects.GiftCardPage;
import com.makemytrip.testBase.BaseClass;
import com.makemytrip.testUtils.DataProviders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

/**
 * 6/4/2023
 * 2:17 PM
 */
public class TC_003_GiftCards_Test extends BaseClass {
    private GiftCardPage giftCardPage;

    @BeforeClass
    public void createGiftCardObject(){
         giftCardPage=new GiftCardPage (driver  );
    }
    @Test
    public void test_gift_card(){
        try {
        logger.info ( "***** Starting TC_003_GiftCards_Test  *****" );

        actions.moveToElement ( giftCardPage.getMoreTextElement ()).build ().perform ();
        actions.moveToElement ( giftCardPage.getGiftCardElement () ).click ().build ().perform ();

        executor.executeScript ( "arguments[0].scrollIntoView(true);",
                giftCardPage.getThankYouCard () );
        executor.executeScript ( "arguments[0].click();",giftCardPage.getThankYouCard () );
        giftCardPage.clickEmailBtn ();
            logger.info ( "***** Mouse hover to the Gift card menu *****" );

        }catch (Exception e){
            e.printStackTrace ();
        }

    }
    @Test(priority = 1,dataProvider = "MakeMyTrip",dataProviderClass = DataProviders.class)
    public void test_gift_form(String recipientsName,String senderName,
                               String recipientsMobile,String senderMobile,
                               String recipientsEmail,String senderEmail,
                               String composeMessage,String expectedResults,
                               String actual,String result
    ) {
        try {

            executor.executeScript ( "arguments[0].scrollIntoView(true);",
                    giftCardPage.getFromHeading () );

            Thread.sleep ( 5000 );
            //set form values
            giftCardPage.setRecipientsName ( recipientsName );
            giftCardPage.setSenderName ( senderName );
            giftCardPage.setRecipientsEmail ( recipientsEmail );
            giftCardPage.setSenderEmail ( senderEmail );
            giftCardPage.setSenderMobileNo ( senderMobile );
            giftCardPage.setRecipientsMobileNo ( recipientsMobile );
            giftCardPage.setMessage ( composeMessage );
            giftCardPage.clickBuyNowBtn ();
            Thread.sleep ( 8000 );
            String emailError=giftCardPage.getEmailErrText ();

            BaseClass.captureScreen ( "" );
            logger.info ( "***** Capture screenshot of the form *****" );


            Shutterbug.shootPage ( driver, Capture.FULL, true ).
                    save ( System.getProperty ( "user.dir" ) + "\\screenshot\\" );


            assertEquals ( emailError, expectedResults );
            excelUtility.setCellData ( "Sheet1", 1, 9, "Pass" );
            excelUtility.fillGreenColor ( "Sheet1", 1, 9 );
            logger.info ( "***** Set result to the excel sheet *****" );

        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    @Test(priority = 2)
    public void test_hotel_capacity() {
        try {

            executor.executeScript ( "arguments[0].scrollIntoView(true);", giftCardPage.getHotelElement () );
            executor.executeScript ( "arguments[0].click();", giftCardPage.getHotelElement () );
            executor.executeScript ( "arguments[0].click();", giftCardPage.clickGuestLabel () );

            Thread.sleep ( 5000 );
            giftCardPage.clickAdultCountLabel ();
            String adultCapacity = giftCardPage.getAdultCapacity ();

            excelUtility.setCellData ( "Sheet2", 0, 0, "Adults" );
            excelUtility.setCellData ( "Sheet2", 0, 1, adultCapacity );
            System.out.println ( "adultCapacity = " + adultCapacity );
            logger.info ( "***** set no of adults in hotel to the excel *****" );

        }catch (Exception e){
            e.printStackTrace ();
        }
        logger.info ( "***** END TC_003_GiftCards_Test  *****" );

        
    }
}
