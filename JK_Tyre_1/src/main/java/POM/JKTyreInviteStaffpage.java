package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JKTyreInviteStaffpage {
	private WebDriver driver;

	@FindBy(xpath = "/html/body/div/div/div[2]/div[4]/div/div/div[1]/div[2]/button")
	private WebElement inviteButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div/form/div[3]/div[1]/div/input")
	private WebElement staffName;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div/form/div[3]/div[2]/div/div/input")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div/form/div[5]/button[2]")
	private WebElement button2;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[3]/div/button")
	private WebElement okButton;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[4]/div/button")
	private WebElement okButton2;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div/form/div[5]/button[1]")
	private WebElement closeButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[4]/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[5]/span/span[1]")
	private WebElement inviteAgain;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[4]/div/button")
	private WebElement okInviteAgainButton;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[4]/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[5]/span/span[2]")
	private WebElement deleteButton;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[1]/div/div/div/div[2]/div/button[2]")
	private WebElement yesButton;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[4]/div/button")
	private WebElement deleteOK;
	
	public JKTyreInviteStaffpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	}
	 
	public void clickonInviteButton() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(inviteButton).build().perform();
		inviteButton.click();
		
	}
	
	public void sendStaffName() throws InterruptedException {
		staffName.sendKeys(" Jay");
		
	}
	
public void sendMobileNumber() throws InterruptedException {
		
	mobileNumber.sendKeys("9181716151");
	}

public void clickonButton2() throws InterruptedException {
	button2.click();
	
}

public void clickonOkButton() throws InterruptedException {
	okButton.click();
	
}

public void clickonOkButton2() throws InterruptedException {
	okButton2.click();
	
}

public void clickonCloseButton() throws InterruptedException {
	closeButton.click();
	
}

public void clickonInviteAgainLink() throws InterruptedException {
	inviteAgain.click();
	
}

public void clickonOkInviteAgainButton() throws InterruptedException {
	okInviteAgainButton.click();
	
}

public void clickonDeleteButton() throws InterruptedException {
	deleteButton.click();
	
}

public void clickonYesButton() throws InterruptedException {
	yesButton.click();
	
}

public void clickonDeleteOKButton() throws InterruptedException {
	deleteOK.click();
	
}

}
