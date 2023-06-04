package com.makemytrip.testCase;

import com.makemytrip.pageObjects.GiftCardPage;
import com.makemytrip.testBase.BaseClass;
import org.testng.annotations.Test;

/**
 * 6/4/2023
 * 2:17 PM
 */
public class TC_003_GiftCards_Test extends BaseClass {
    @Test
    public void test_gift_card()throws Exception{
        GiftCardPage giftCardPage=new GiftCardPage (driver  );
        actions.moveToElement ( giftCardPage.getMoreTextElement ()).build ().perform ();
        actions.moveToElement ( giftCardPage.getGiftCardElement () ).click ().build ().perform ();

        executor.executeScript ( "arguments[0].scrollIntoView(true);",giftCardPage.getThankYouCard () );
        executor.executeScript ( "arguments[0].click();",giftCardPage.getThankYouCard () );
        giftCardPage.clickEmailBtn ();
    }
    @Test(priority = 1)
    public void test_gift_form() throws Exception{
        GiftCardPage giftCardPage=new GiftCardPage (driver  );
        executor.executeScript ( "arguments[0].scrollIntoView(true);", giftCardPage.getFromHeading ());

        //set form values
        giftCardPage.setReceiverName ( "Sonam" );
        giftCardPage.setSenderName ( "Kishan" );
        giftCardPage.setReceiverEmail ( "sonam" );
        giftCardPage.setSenderEmail ( "kishan@gmail.com" );
        giftCardPage.setSenderMobileNo ( "9876543210" );
        giftCardPage.setReceiverMobileNo ( "9887543210" );
        giftCardPage.setMessage ( "Say hi " );
        giftCardPage.clickBuyNowBtn ();
        Thread.sleep ( 8000 );
        String emailError=giftCardPage.getEmailErrText ();
        System.out.println ( "emailError = " + emailError );
    }

    @Test(priority = 2)
    public void test_hotel_capacity(){
        GiftCardPage giftCardPage=new GiftCardPage (driver  );

        executor.executeScript ( "arguments[0].scrollIntoView(true);",giftCardPage.getHotelElement () );
        executor.executeScript ( "arguments[0].click();",giftCardPage.getHotelElement () );
        giftCardPage.clickGuestLabel ();
        giftCardPage.clickAdultCountLabel ();
        String adultCapacity=giftCardPage.getAdultCapacity ();
        System.out.println ( "adultCapacity = " + adultCapacity );
        
        
    }
}
