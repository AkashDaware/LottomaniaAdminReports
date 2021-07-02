package com.LottomaniaAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.LottomaniaAdmin.qa.base.TestBase;

public class HomePage extends TestBase {

	//	 PageFactory
	

	@FindBy(xpath = "//li[@id='header:sm_Reports']/a")
	WebElement report;

	//Click on Revenue Report Datewise
	@FindBy(xpath = "//a[@href='/Console/DateWiseRevenueReport.xhtml']")
	WebElement rrd;
	
	@FindBy(xpath = "//span[@class = 'FontBold Fs18 hardblue']")
	WebElement homePageTitle;

	@FindBy(xpath = "//div/ul/li[7]/a")
	WebElement reports;

	//Verify Title
	@FindBy(xpath = "//div[contains(text(),'Winning Ticket Report')]")
	WebElement winningTicketReportTitle; 

	//Click on winning Report
	@FindBy(xpath = "//a[. = 'Winning Ticket Report']")
	WebElement winningReport;



	//Initializing the page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//Actions :
	public String verifyHomePageTitle() {
		return homePageTitle.getText();
	}

	public WinningTicketReport clickOnWinningTicketReport() {
		reports.click();
		winningReport.click();
		return new WinningTicketReport();
	}

	public String verifyWinningTicketReportTitle() {
		return  winningTicketReportTitle.getText();
	}
	
	public RevenueReportDayWise clickOnReport() {
		report.click();
		rrd.click();
		return new RevenueReportDayWise();
	}
}	