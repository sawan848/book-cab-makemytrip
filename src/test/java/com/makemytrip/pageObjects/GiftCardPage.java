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
    private WebElement recipientsNameElement;

    @FindBy(name="senderName")
    private WebElement senderNameElement;

    @FindBy(name="emailId")
    private WebElement recipientsEmailIdElement;

    @FindBy(name="senderEmailId")
    private WebElement senderEmailIdElement;
    @FindBy(name="mobileNo")
    private WebElement recipientsMobileNoElement;
    @FindBy(name="senderMobileNo")
    private WebElement senderMobileNoElement;
    @FindBy(name="giftMessage")
    private WebElement messageElement;
    @FindBy(linkText = "Giftcards")
    private WebElement giftCardElement;
    @FindBy(linkText = "Hotels")
    private WebElement hotelElement;
    @FindBy(id = "guest")
    private WebElement guestElement;

    @FindBy(xpath = "//p[@class='red-text font11 append-top5']")
    private WebElement emailErrText;
    @FindBy(xpath = "//div[@id='deliveredSection']/h2")
    private WebElement formHeading;
    @FindBy(xpath = "//div[@class='booking__sections make-flex column']/button")
    private WebElement buyNowBtn;

    @FindBy(xpath = "//span[@class='chNavText']/span[@class='darkGreyText']")
    private WebElement moreTextElement;
    @FindBy(xpath = "//p[@class='lato-black' and contains(text(),'Thank')]")
    private WebElement thankYouCard;
    @FindBy(xpath = "//ul[@class='deliver__via__tab make-flex space-around']/li[2]")
    private   WebElement emailElement;

    @FindBy(xpath = "//div[@class='gstSlctCont ']/div/span[@data-testid='adult_count']")
    private   WebElement adultCountLabel;

    @FindBy(xpath = "//ul[@class='gstSlct__list']/li[40]")
    private   WebElement guestListLabel;


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
