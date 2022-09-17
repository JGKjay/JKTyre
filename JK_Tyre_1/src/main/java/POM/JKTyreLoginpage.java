package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JKTyreLoginpage {
	private WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;
	
	
	public JKTyreLoginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	 
	public void sendJKtyreLoginPageUsername(String username) {
		userName.sendKeys(username);
	}
	
	public void sendJKtyreLoginPagePassword(String userPassword) {
		password.sendKeys(userPassword);
	}
	
	public void clickJKtyreLoginPageLogin() {
		loginButton.click();
	}
	

}