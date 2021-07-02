package com.LottomaniaAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LottomaniaAdmin.qa.base.TestBase;


public class LoginPage extends TestBase{
	
	//PageFactory - OR
	@FindBy(name = "form:userName")
	WebElement username;
	
	@FindBy(name = "form:password")
	WebElement password;
	
	@FindBy(name = "form:btlogin")
	WebElement login;
	
	@FindBy(name = "form:j_idt27")
	WebElement reset;
	
	@FindBy(id = "form:j_idt17")
	WebElement lottoLogo;
	
	@FindBy(id= "form:loginPanel_footer")
	WebElement versionDetails;
	
//	Initializing the page object
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
//	Actions :
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLottomaniaLogo() {
		return lottoLogo.isDisplayed();
	}
	
	public String validateVersion() {
		return versionDetails.getText();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	}
	
	

}