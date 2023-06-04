package com.makemytrip.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 6/4/2023
 * 2:13 PM
 */
public class GiftCardPage extends BasePage{

    @FindBy(name="name")
    WebElement recipientsNameElement;

    @FindBy(name="senderName")
    WebElement senderNameElement;

    @FindBy(name="emailId")
    WebElement recipientsEmailIdElement;

    @FindBy(name="senderEmailId")
    WebElement senderEmailIdElement;
    @FindBy(name="mobileNo")
    WebElement recipientsMobileNoElement;
    @FindBy(name="senderMobileNo")
    WebElement senderMobileNoElement;
    @FindBy(name="giftMessage")
    WebElement messageElement;
    @FindBy(linkText = "Giftcards")
    WebElement giftCardElement;
    @FindBy(linkText = "Hotels")
    WebElement hotelElement;
    @FindBy(id = "guest")
    WebElement guestElement;

    @FindBy(xpath = "//p[@class='red-text font11 append-top5']")
    WebElement emailErrText;
    @FindBy(xpath = "//div[@id='deliveredSection']/h2")
    WebElement formHeading;
    @FindBy(xpath = "//div[@class='booking__sections make-flex column']/button")
    WebElement buyNowBtn;

    @FindBy(xpath = "//span[@class='chNavText']/span[@class='darkGreyText']")
    WebElement moreTextElement;
    @FindBy(xpath = "//p[@class='lato-black' and contains(text(),'Thank')]")
    WebElement thankYouCard;
    @FindBy(xpath = "//ul[@class='deliver__via__tab make-flex space-around']/li[2]")
    WebElement emailElement;

    @FindBy(xpath = "//div[@class='gstSlctCont ']/div/span[@data-testid='adult_count']")
    WebElement adultCountLabel;

    @FindBy(xpath = "//ul[@class='gstSlct__list']/li[40]")
    WebElement guestListLabel;


    public GiftCardPage(WebDriver driver) {
        super ( driver );
    }
    public String getAdultCapacity(){
       return  guestListLabel.getText ();
    }
    public void clickAdultCountLabel(){adultCountLabel.click ();}
    public WebElement clickGuestLabel(){ return guestElement;}
    public WebElement getHotelElement(){return hotelElement;}
    public String getEmailErrText(){return emailErrText.getText ();    }
    public void clickEmailBtn(){ emailElement.click ();}
    public void setRecipientsName(String name){recipientsNameElement.sendKeys ( name );}
    public void setSenderName(String senderName){senderNameElement.sendKeys ( senderName );}
    public void setRecipientsMobileNo(String recipientsMobileNo){recipientsMobileNoElement.sendKeys ( recipientsMobileNo );}
    public void setSenderMobileNo(String senderMobileNo){senderMobileNoElement.sendKeys ( senderMobileNo );}
    public void setSenderEmail(String senderEmail){senderEmailIdElement.sendKeys ( senderEmail );}
    public void setRecipientsEmail(String recipientsEmail){recipientsEmailIdElement.sendKeys ( recipientsEmail );}
    public void setMessage(String message){messageElement.sendKeys ( message );}
    public void clickBuyNowBtn(){buyNowBtn.click ();}
    public WebElement getGiftCardElement(){return  giftCardElement;}
    public WebElement getMoreTextElement(){return  moreTextElement;}
    public WebElement getFromHeading(){return formHeading;}
    public WebElement getThankYouCard(){return  thankYouCard;}

}
