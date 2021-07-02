package com.LottomaniaAdmin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.LottomaniaAdmin.qa.base.TestBase;
import com.LottomaniaAdmin.qa.pages.HomePage;
import com.LottomaniaAdmin.qa.pages.LoginPage;
import com.LottomaniaAdmin.qa.pages.WinningReportPage;
import com.LottomaniaAdmin.qa.pages.WinningTicketReport;


public class WinningTicketReportTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	WinningTicketReport Win_Ticket;
	WinningReportPage winReportPage;
	
	public WinningTicketReportTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Win_Ticket = homePage.clickOnWinningTicketReport();
	}
	
	@Test(priority = 1)
	public void VerifyWinningTicketReportTitleTest() {
		String WinTitle = Win_Ticket.VerifyWinningTicketReportTitle();
		Assert.assertEquals(WinTitle, "Winning Ticket Report");
	}
	
	@Test(priority = 2)
	public void enterDetailsTest() throws InterruptedException {
		winReportPage = Win_Ticket.enterDetails();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
