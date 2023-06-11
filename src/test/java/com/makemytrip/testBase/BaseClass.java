package com.makemytrip.testBase;

import com.makemytrip.testUtils.ExcelUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * 6/4/2023
 * 9:50 AM
 */
public class BaseClass {
    protected static ExcelUtility excelUtility;
    protected static Logger logger;
    protected  static JavascriptExecutor executor;
    protected static Actions actions;
    protected static WebDriver driver;
    protected ResourceBundle resource;
    @BeforeTest()
    @Parameters(value = {"browser"})
    public void setDriver(String browser){
        resource=ResourceBundle.getBundle ( "conf/config" );
        excelUtility=new ExcelUtility ( resource.getString ( "excelPath" ) );
        logger= LogManager.getLogger (this.getClass ());

        switch (browser) {
            case "edge":
                driver = new EdgeDriver ();
                logger.info ( "*** EdgeDriver Setup ***" );

                break;
            case "firefox":
                driver = new FirefoxDriver ();
                logger.info ( "*** FirefoxDriver Setup ***" );

                break;
            case "chrome":
                WebDriverManager.chromedriver ().setup ();
                driver = new ChromeDriver ();
                logger.info ( "*** ChromeDriver Setup ***" );
                break;
        }

        executor=(JavascriptExecutor)driver;
        actions=new Actions ( driver );
        driver.manage ().window ().maximize ();
        driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ) );
        driver.manage ().timeouts ().pageLoadTimeout ( Duration.ofSeconds ( 10 ) );
        driver.get (  resource.getString ( "url" ));
    }
    @AfterTest()
    public void close(){
        driver.quit ();
    }

    public static String  captureScreen(String testName)throws IOException {
        String timeStamp=new SimpleDateFormat ("yyyyMMddHHmmss").format(new Date ());
        TakesScreenshot takeScreenshot=(TakesScreenshot)driver;
        File source=takeScreenshot.getScreenshotAs( OutputType.FILE);
        String destination=System.getProperty("user.dir")+"\\screenshot\\"+testName+"_"+timeStamp+".png";

        try {
            FileUtils.copyFile(source,new File(destination));
        }catch(Exception e) {
            e.getMessage();
        }

        return destination;

    }
}
