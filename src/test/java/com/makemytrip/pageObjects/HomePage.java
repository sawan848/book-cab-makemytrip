package com.makemytrip.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 6/4/2023
 * 9:37 AM
 */
public class HomePage extends BasePage{

    //locators
    @FindBy(id = "webklipper-publisher-widget-container-notification-frame")
    private WebElement iFrameElement;
    @FindBy(css =".we_close" )
    private WebElement iFrameCloseBtnElement;

    @FindBy(css = ".menu_Cabs > div:nth-child(1) > a:nth-child(1)")
    private WebElement cabElement;
    public HomePage(WebDriver driver) {
        super ( driver );
    }

    public WebElement setIFrame(){
        return  iFrameElement;

    }
    public WebElement setIFrameCloseBtn(){
        return  iFrameCloseBtnElement;
    }
    public WebElement setCabElement(){
        return cabElement;
    }
}
