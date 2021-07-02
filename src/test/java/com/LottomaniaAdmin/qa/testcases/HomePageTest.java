package com.LottomaniaAdmin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.LottomaniaAdmin.qa.base.TestBase;
import com.LottomaniaAdmin.qa.pages.HomePage;
import com.LottomaniaAdmin.qa.pages.LoginPage;
import com.LottomaniaAdmin.qa.pages.WinningTicketReport;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	WinningTicketReport winningTicketReport;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void clickOnWinningTicketReportTest() {
		winningTicketReport = homePage.clickOnWinningTicketReport();
	}
	
	@Test(priority = 2)
	public void WinningTicketReportTitleTest() {
		String winningTitle = homePage.verifyWinningTicketReportTitle();
		Assert.assertEquals(winningTitle, "Winning Ticket Report");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

