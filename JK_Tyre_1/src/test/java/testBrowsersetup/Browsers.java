package testBrowsersetup;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Browsers {
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","src" + File.separator + "test" + File.separator + "resources" + File.separator + "browsers" + File.separator + "chromedriver");
		ChromeOptions op = new ChromeOptions();
	      //disable notification parameter
	      op.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(op);
		return driver;
	}
	
	/* public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","src" + File.separator + "test" + File.separator + "resources" + File.separator + "browsers" + File.separator + "geckodriver");
		
		
		FirefoxOptions opn = new FirefoxOptions();
	      //disable notification parameter
	      opn.addPreference("dom.webnotifications.enabled", false);
		
	      WebDriver driver = new FirefoxDriver(opn);
		
		return driver;
	}
	*/
}

