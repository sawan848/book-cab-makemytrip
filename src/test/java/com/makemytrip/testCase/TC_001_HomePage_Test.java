package com.makemytrip.testCase;

import com.makemytrip.pageObjects.CarPage;
import com.makemytrip.pageObjects.HomePage;
import com.makemytrip.testBase.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * 6/4/2023
 * 9:59 AM
 */
public class TC_001_HomePage_Test extends BaseClass {
    @Test()
    public void  test_popup(){
        HomePage homePage=new HomePage ( driver );
       WebElement iFrame =new WebDriverWait ( driver, Duration.ofSeconds ( 30 ) ).
               until ( ExpectedConditions.visibilityOf (
                       homePage.setIFrame ()));

       if ( iFrame.isDisplayed () ){
           driver.switchTo ().frame ( iFrame );
           executor.executeScript ( "arguments[0].click();",homePage.setIFrameCloseBtn () );
       }
       driver.switchTo ().parentFrame ();
       new WebDriverWait ( driver,Duration.ofSeconds ( 3 ) ).
               until (ExpectedConditions.visibilityOf ( homePage.setCabElement () )  )
               .click ();
    }


}
