package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JKTyreLogoutpage {
	private WebDriver driver;

	@FindBy(xpath = "//img[@src='images/logout_icon.png']")
	private WebElement logOutIcon;
	
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logoutbutton;
	
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement clicklogoutbutton;
	
	
	
	public JKTyreLogoutpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	 
	public void moveToLogOutIcon() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(logOutIcon).build().perform();
		
		Thread.sleep(3000);
		
		
		
	}
	
	public void clickLogOutButton() throws InterruptedException {
		logoutbutton.click();
		
		
		
	}
	
	public void acceptLogOutButton() throws InterruptedException {
		clicklogoutbutton.click();
		
		
		
	}
	

}


