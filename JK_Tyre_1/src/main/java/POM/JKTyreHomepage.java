package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JKTyreHomepage {
	private WebDriver driver;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[3]/div[1]/div[1]/ul/div/ul/li[3]/span")
	private WebElement inviteStaff;
	
	
	
	public JKTyreHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	}
	 
	public void clickonInviteStafflink() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(inviteStaff).build().perform();
		inviteStaff.click();
		
		
		
	}
	
	
	

}
