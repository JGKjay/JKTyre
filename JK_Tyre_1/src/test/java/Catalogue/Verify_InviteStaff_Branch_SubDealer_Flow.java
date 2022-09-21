package Catalogue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.ILoggerFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


import POM.JKTyreHomepage;
import POM.JKTyreInviteStaffpage;
import POM.JKTyreLoginpage;
import POM.JKTyreLogoutpage;

import testBrowsersetup.Browsers;




public class Verify_InviteStaff_Branch_SubDealer_Flow extends Browsers {
	WebDriver driver;
	JKTyreLoginpage jkTyreLoginpage;
	JKTyreHomepage jkTyreHomepage;
	JKTyreInviteStaffpage jKTyreInviteStaffpage;
	JKTyreLogoutpage jkTyreLogoutpage;
	SoftAssert softAssert;
	
	static ExtentTest test;
	static ExtentReports report;
	static Date date=new Date();
	static SimpleDateFormat sd= new SimpleDateFormat("dd_MM_yyyy");
	
	
	int testID;
	
	
	@BeforeTest
	
	public void launchBrowser() throws Exception {
		
		
 
			  System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");  
         
         // Instantiate a ChromeDriver class.     
		 ChromeOptions op = new ChromeOptions();
	      //disable notification parameter
	      op.addArguments("--disable-notifications","--headless", "--no-sandbox", "--disable-dev-shm-usage");
		 
		 driver=new ChromeDriver(op);  
		
	/*	else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = openFirefoxBrowser();
		}
		
	*/	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
	
		
		

		driver.manage().window().maximize() ;
	}


	@BeforeClass
	public void createObject() throws IOException {
		System.out.println("Before Class");
		
		jkTyreLoginpage = new JKTyreLoginpage(driver);
		jkTyreHomepage = new JKTyreHomepage(driver);
		jKTyreInviteStaffpage = new JKTyreInviteStaffpage(driver);
		jkTyreLogoutpage = new JKTyreLogoutpage(driver);
		
		
	}
	
	@BeforeMethod
	public void loginToUserAccount() throws InterruptedException, Exception {
		System.out.println("Login JKTyre Advantage");
		
		
		  driver.get("https://staging.jkadvantage.co.in/#/login"); 
		  Thread.sleep(3000);
		  
		
		  driver.navigate().to("https://staging.jkadvantage.co.in/#/login"); 
		  
		jkTyreLoginpage.sendJKtyreLoginPageUsername("222111");
		jkTyreLoginpage.sendJKtyreLoginPagePassword("jktyre@12345");
		jkTyreLoginpage.clickJKtyreLoginPageLogin();
		softAssert = new SoftAssert();
		
		
		
	}
	

	
	@Test(priority = 1)
	public void to_Verify_Invite_New_Member() throws InterruptedException, IOException {
		
		
		
		testID = 104;
		System.out.println("To Verify Invite New Member ");
		
		
		Thread.sleep(3000);
		jkTyreHomepage.clickonInviteStafflink();
		
		System.out.println(" click on Ivite Staff Link **********************************");
		Thread.sleep(3000);
		
		Set <String> s = driver.getWindowHandles();
		
		for (String i:s)
		{
		
		String t = driver.switchTo().window(i).getTitle();
		System.out.println(t);
		}
		
		Thread.sleep(3000);
		
		jKTyreInviteStaffpage.clickonInviteButton();
		Thread.sleep(3000);
		jKTyreInviteStaffpage.sendStaffName();
		jKTyreInviteStaffpage.sendMobileNumber();
		jKTyreInviteStaffpage.clickonButton2();
		Thread.sleep(2000);
		
		if(driver.getPageSource().contains("Invite Successfully"))
		{
			System.out.println("Invite Successfully");
		
			softAssert.assertTrue(true, "Invite Successfully");
			
			jKTyreInviteStaffpage.clickonOkButton();
			
			Thread.sleep(3000);
			
			jKTyreInviteStaffpage.clickonInviteAgainLink();
			Thread.sleep(3000);
			
			test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "To Verify Invite New Member is Fail********************** ");

			jKTyreInviteStaffpage.clickonOkInviteAgainButton();
			Thread.sleep(2000);
			System.out.println("Invite Again Successfully*****");
			
			jKTyreInviteStaffpage.clickonDeleteButton();
			Thread.sleep(3000);
			jKTyreInviteStaffpage.clickonYesButton();
			Thread.sleep(3000);
			jKTyreInviteStaffpage.clickonDeleteOKButton();
			Thread.sleep(3000);
			
			System.out.println("New Invite Staff Delete Successfully*********");
			
			
			
		}
		else {
			System.out.println("Please add new number these invitee number already exists");
		
			softAssert.assertTrue(false, "Please add new number these invitee number already exists" );
		
			jKTyreInviteStaffpage.clickonOkButton2();
			
			test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "To Verify Invite New Member is Fail********************** ");

			
			jKTyreInviteStaffpage.clickonCloseButton();
			
			
			Thread.sleep(2000);
              jKTyreInviteStaffpage.clickonDeleteButton();
              Thread.sleep(3000);
			jKTyreInviteStaffpage.clickonYesButton();
			
			Thread.sleep(2000);
			jKTyreInviteStaffpage.clickonDeleteOKButton();
			
			Thread.sleep(3000);
			
			System.out.println("OLD Invite Staff Delete Successfully*********");
			
			
		
		
		
		test.log(LogStatus.PASS,"To Verify Invite New Member is Pass");
		
		}
		softAssert.assertAll();
		
		
		
	}
	
 /*	@Test(priority = 2)
	public void toVerifyEnterExcessPointToConvert() throws InterruptedException, IOException {
		
		
		
		testID = 105;
		System.out.println("To Verify Enter Excess Point To Convert ");
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		jkTyreHomepage.moveToCatalogueicon();
		jkTyreHomepage.catalogueButtonClick();
		String link = jkTyreHomepage.clickonRedemptionButton();
		if(link.equals("https://staging.jkadvantage.co.in/#/redemption-catalog")) {
			System.out.println(" Redemption link is"+ link);
			
		}
		else {
			AssertJUnit.fail();
		}
		
		Thread.sleep(5000);
		jkTyreCataloguepage.clickOnWelcomeButton();
		Thread.sleep(5000);
		
		jkTyreNewCataloguepage.enterPoint1();
		jkTyreNewCataloguepage.enterPoint2();
		jkTyreNewCataloguepage.enterPoint3();
		
		jkTyreNewCataloguepage.clickOnCheckBox();
		jkTyreNewCataloguepage.clickOnSubmitButton();
		Thread.sleep(5000);
		
		if(driver.getPageSource().contains("Request submission failed! The points total entered by you is exceeding the available points balance for redemption. Please make sure total points are not more than the mentioned points available for redemption"))
		{System.out.println("Request submission failed! The points total entered by you is exceeding the available points balance for redemption. Please make sure total points are not more than the mentioned points available for redemption");
		
		softAssert.assertTrue(true, "Request submission failed! The points total entered by you is exceeding the available points balance for redemption. Please make sure total points are not more than the mentioned points available for redemption" );
	

		}
		else {
			System.out.println("Thank you. Your request has been registered. You can edit your request till 20th June. Your last request will be considered as final request for Advantage Points Redemption against FY 2021-22 Points");
			
				softAssert.assertTrue(false, "Thank you. Your request has been registered. You can edit your request till 20th June. Your last request will be considered as final request for Advantage Points Redemption against FY 2021-22 Points");
		
		}
		
		
		
		
		test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Verify Enter Excess Point To Convert failed to  load ");
		
		jkTyreNewCataloguepage.clickOnOKButton();
		
		
		
		test.log(LogStatus.PASS,"TRequest submission failed! The points total entered by you is exceeding the available points balance for redemption. Please make sure total points are not more than the mentioned points available for redemption");
		
		
		
		
	}
	
	*/
	
	
	
@AfterMethod
public void logOutUserAccount() throws InterruptedException {
	System.out.println("LogOut JKTyre Advantage");
	Thread.sleep(3000);
	jkTyreLogoutpage.moveToLogOutIcon();
	Thread.sleep(3000);
	jkTyreLogoutpage.clickLogOutButton();
	Thread.sleep(3000);
	jkTyreLogoutpage.acceptLogOutButton();

	Thread.sleep(5000);
	
	
	
}

@AfterClass
public void closeBrowser() {
	driver.quit();
	
}




@AfterTest
public static String capture(WebDriver driver) throws IOException 
{
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File Dest = new File(".//target//ExtentReports//screenshots//" + System.currentTimeMillis()+ ".png");
	String errflpath = Dest.getAbsolutePath();
	FileUtils.copyFile(scrFile, Dest);
    return errflpath;
}



}
