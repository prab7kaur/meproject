package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass{

	//object repository   
	@FindBy(name="Username")
	WebElement 	Username;
	@FindBy(name="password")
	WebElement Password;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
	WebElement Loginbtn;
	
	//initiate page elements (create a constructor)
	public PomLogin() {
		PageFactory.initElements(driver, this);	
	}
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	public void typepassword(String passw) {
		Password.sendKeys(passw);
	}
	public void clickbtn() {
		Loginbtn.click();
}
	public String verify() {
		return driver.getTitle();
		
	}
}
