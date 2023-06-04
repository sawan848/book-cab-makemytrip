package com.makemytrip.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

/**
 * 6/4/2023
 * 9:35 AM
 */
public class CarPage extends BasePage{
    @FindBy(xpath = "//span[text()='From']")
    WebElement fromElement;
    @FindBy(xpath = "//span[text()='To']")
    WebElement toElement;

    @FindBy(xpath = "//span[text()='DEPARTURE']")
    WebElement departureElement;
    @FindBy(xpath = "//span[text()='RETURN']")
    WebElement returnElement;
    @FindBy(className = "DayPicker")
    WebElement dayPickerElement;

    public CarPage(WebDriver driver) {
        super ( driver );
    }

    public void setDepartureElement(){
        departureElement.click ();
    }
    public void setReturnElement(){
        returnElement.click ();
    }

    public WebElement getDayPickerElement(){return dayPickerElement;}

    public void setCalenderDayMonth(String day,String month,String date,String year){
        driver.findElement(By.xpath("//div[@aria-label='"+day+" "+month+" "+date+" "+year+"']")).click();
    }

    public void clickFrom(){
        fromElement.click ();
    }
    public void clickToBtn(){
        toElement.click ();
    }

    public void setFromElement(String from){
        driver.findElement(By.xpath("//p[@class='searchedResult font14 darkText']/span[text()='Delhi']")).click();

    }

    public void  setToElement(String to){
        driver.findElement (
                By.xpath ("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input" ) )
                .sendKeys ("Man" );

        driver.findElement (
                By.xpath ( "//p[@class='searchedResult font14 darkText']/span[text()='Manali, Himachal Pradesh, India']" ) )
                .click ();


    }
    public WebElement getPickUpLabel(){
        return driver.findElement ( By.xpath ("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[5]/label" ) ) ;
    }
    public WebElement getDropLabel(){
        return driver.findElement ( By.xpath ("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[6]/label" ) ) ;
    }
    public void clickPickupTimeBtn(){driver.findElement ( By.className ( "applyBtn" ) ).click ();}
    public  void setPickupTime(){
        driver.findElement ( By.xpath ( "//ul[@class='newTimeSlotHrUl']/li[7]/span" ) ).click ();
        driver.findElement ( By.xpath ( "//ul[@class='newTimeSlotMinUl']/li[8]/span" ) ).click ();
        driver.findElement ( By.xpath ( "//ul[@class='newTimeSlotMerUl']/li[1]/span" ) ).click ();

    }
    public WebElement setNextApplyBtn(){
        return driver.findElement ( By.xpath ( "/html/body/div[1]/div/div[2]/div/div/div[2]/div/div[6]/div[1]/div[1]/div[5]/span" ) );}
}
