package com.LottomaniaAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LottomaniaAdmin.qa.base.TestBase;

public class WinningTicketReport extends TestBase{
	//PAgeFactory or OR
	@FindBy(xpath = "//a[. = ' Reports ']")
	WebElement Reports;
	
	//Verify Title
	@FindBy(xpath = "//div[contains(text(),'Winning Ticket Report')]")
	WebElement WinningTicketReportTitle; 
	
	//Click on winning Report
	@FindBy(xpath = "//a[. = 'Winning Ticket Report']")
	WebElement WinningReport;
	
	//SelectCompanyNameDropDown
	@FindBy(id = "j_idt41:cmpny_label")
	WebElement CompanyNameDropDown;
	
	//SelectCompanyName
	@FindBy(xpath="//li[. = 'TESTING(999999)']")
	WebElement CompanyName;
	
	//AgentDropdown
	@FindBy(id = "j_idt41:sAgnt_label")
	WebElement AgentDropDown;
	
	//SelectAgentName
	@FindBy(xpath="//li[. = 'Akashd(100083)']")
	WebElement AgentName;
	
	//SubAgentDropDown
	@FindBy(id = "j_idt41:pAgnt_label")
	WebElement SubAgentDropDown;
	
	//SelectSubAgent
	@FindBy(xpath = "//li[. = 'Akash_02(200108)']")
	WebElement SubAgent;
	
	//RetailerDropDown
	@FindBy(id = "j_idt41:retlr_label")
	WebElement RetailerDropDown;
	
	//SelectRetailer
	@FindBy(xpath = "//li[. = 'Area_03(400191)']")
	WebElement Retailer;
	
	//GameListDropDown
	@FindBy(id = "j_idt41:gameList_label")
	WebElement GameList;
	
	//SelectGameName
	@FindBy(xpath = "//li[. = 'M-MIDWEEK']")
	WebElement GameName;
	
	//SubmitDetails
	@FindBy(xpath ="//span[. = 'Submit']")
    WebElement SubmitButton;

	// Initialize the Page Objects
	public WinningTicketReport() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyWinningTicketReportTitle() {
		return driver.getTitle();
	}
	
	public WinningReportPage enterDetails() throws InterruptedException {
			CompanyNameDropDown.click();
			CompanyName.click();
			Thread.sleep(3000L);
			AgentDropDown.click();
			AgentName.click();
			Thread.sleep(3000L);
			SubAgentDropDown.click();
			SubAgent.click();
			Thread.sleep(3000L);
			RetailerDropDown.click();
			Retailer.click();
			Thread.sleep(3000L);
			GameList.click();
			GameName.click();
			Thread.sleep(3000L);
			SubmitButton.click();
		return new WinningReportPage(); 
	}

	

}

