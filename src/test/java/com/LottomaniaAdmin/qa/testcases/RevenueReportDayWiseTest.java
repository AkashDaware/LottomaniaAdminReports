package com.LottomaniaAdmin.qa.testcases;

import java.math.RoundingMode;
import java.text.DecimalFormat;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.LottomaniaAdmin.qa.base.TestBase;
import com.LottomaniaAdmin.qa.pages.HomePage;
import com.LottomaniaAdmin.qa.pages.LoginPage;
import com.LottomaniaAdmin.qa.pages.RevenueReportDayWise;


public class RevenueReportDayWiseTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	RevenueReportDayWise rrd;
	
	
	public RevenueReportDayWiseTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		rrd = homePage.clickOnReport();
		
	}
	
	@Test(priority=1)
	public void validateRevenueReportDayWise() throws InterruptedException {
		rrd.getBeforeReport();
		// Getting values from config file
		String sale = prop.getProperty("Sale");
		double Sale = Float.parseFloat(sale);
		String saleBetCount = prop.getProperty("SaleBetCount");
		double SaleBetCount = Float.parseFloat(saleBetCount);
		String cancel = prop.getProperty("Cancel");
		double Cancel = Float.parseFloat(cancel);
		String cancelBetCount = prop.getProperty("CancelBetCount");
		double CancelBetCount = Float.parseFloat(cancelBetCount);
		String winningAmount = prop.getProperty("WinningAmount");
		double WinningAmount = Float.parseFloat(winningAmount);
		String winningBetCount = prop.getProperty("WinningBetCount");
		double WinningBetCount = Float.parseFloat(winningBetCount);
		String selfCommission = prop.getProperty("SelfCommission");
		double SelfCommission = Float.parseFloat(selfCommission);
		String agentCommission = prop.getProperty("AgentCommission");
		double AgentCommission = Float.parseFloat(agentCommission);
		//Getting Selling Terminals 
		double sellingTerminal = rrd.getSellingTerminal();
		//Getting Sales Amount before doing Bet Place
		double beforeSaleAmount = rrd.getSalesAmount();
		// Getting Sale Bet Count before doing bet place
		double beforeSalesBetCount = rrd.getSalesBetCount();
		// Getting Cancel Amount before doing bet place
		double beforeCancelAmount = rrd.getCancelAmount();
		// Getting Cancel bet count before doing bet place
		double beforeCancelBetCount = rrd.getCancelBetCount();
		// Getting Winning Amount before bet place
		double beforeWinningAmount  = rrd.getWinningAmount();
		// Getting Winning Bet Count before bet place
		double beforeWinningBetCount  = rrd.getWinningBetCount();
		// Wait for 10 sec and place bet from Terminal/Web
		Thread.sleep(15000L);
		// Running 2nd method
		rrd.getAfterReport();
		DecimalFormat df = new DecimalFormat("##.##");
		df.setRoundingMode(RoundingMode.HALF_DOWN);
		// Validation for Sales Amount
		double expectedSaleAmount = beforeSaleAmount + Sale;
		double actualSaleAmount = rrd.getSalesAmount();
		Assert.assertEquals(df.format(actualSaleAmount), df.format(expectedSaleAmount));
		System.out.println("Sales Amount verified");
		// Validation for Sales Bet Count
		double expectedSaleCount = beforeSalesBetCount + SaleBetCount;
		double actualSaleCount = rrd.getSalesBetCount();
		Assert.assertEquals(df.format(actualSaleCount)	, df.format(expectedSaleCount));
		System.out.println("Sales Bet Count verified");
		// Validation for Cancel bet
		double expectedCancelAmount = beforeCancelAmount - Cancel;
		double actualCancelAmount = rrd.getCancelAmount();
		Assert.assertEquals(df.format(actualCancelAmount), df.format(expectedCancelAmount));
		System.out.println("Cancel Amount Verified");
		// Validation for Cancel Bet Count
		double expectedCancelBetCount = beforeCancelBetCount - CancelBetCount;
		double actualCancelBetCount = rrd.getCancelBetCount();
		Assert.assertEquals(df.format(actualCancelBetCount), df.format(expectedCancelBetCount));
		System.out.println("Cancel Bet Count Verified");
		// Validation for Net Sale
		double expectedNetSale = expectedSaleAmount - expectedCancelAmount;
		double actualNetSale = rrd.getNetSales();
		Assert.assertEquals(df.format(actualNetSale), df.format(expectedNetSale));
		System.out.println("Net Sale Verified");
		// Validation for Winning Amount 
		double expectedWinning = WinningAmount + beforeWinningAmount;
		double actualWinning = rrd.getWinningAmount();
		Assert.assertEquals(df.format(actualWinning),df.format(expectedWinning));
		System.out.println("Winning Amount Verified");
		// Validation for Winning Bet Count
		double expectedWinningBetCount = WinningBetCount + beforeWinningBetCount;
		double actualWinningBetCount = rrd.getWinningBetCount();
		Assert.assertEquals(df.format(actualWinningBetCount), df.format(expectedWinningBetCount));
		System.out.println("Winning Bet Count verified");
		// Validation for GGR
		double expectedGGR = expectedNetSale - expectedWinning;
		double actualGGR = rrd.getGGR();
		Assert.assertEquals(df.format(actualGGR), df.format(expectedGGR));
		System.out.println("GGR verified");
		// Validation for GGR Percentage
		double expectedGGRPer = expectedGGR / expectedNetSale;
		double actualGGRPer = rrd.getGGRPer();
		Assert.assertEquals(df.format(actualGGRPer), df.format(expectedGGRPer));
		System.out.println("GGR percentage verified");
		// Validation for Self Commission
		double expectedSelfCommission = expectedNetSale * SelfCommission;
		double actualSelfCommission = rrd.getSelfComission();
		Assert.assertEquals(df.format(actualSelfCommission), df.format(expectedSelfCommission));
		System.out.println("Self Sales Comission verified");
		// Validation for Agent Commission
		double expectedAgentCommission = expectedNetSale * AgentCommission;
		df.format(expectedAgentCommission);
		double actualAgentCommission = rrd.getAgentComission();
		Assert.assertEquals(df.format(actualAgentCommission), df.format(expectedAgentCommission));
		System.out.println("Agent Sales Comission verified");
		// Validation for Revenue
		double expectedRevenueAmount = expectedNetSale - expectedSelfCommission - expectedAgentCommission ;
		double actualRevenueAmount = rrd.getRevenueAmount();
		Assert.assertEquals(df.format(actualRevenueAmount), df.format(expectedRevenueAmount));
		System.out.println("Revenue verified");
		// Validation for Revenue Percentage
		double expectedRevenuePer = expectedRevenueAmount / expectedGGR ; 
		double actualRevenuePer = rrd.getRevenuePer();
		Assert.assertEquals(df.format(actualRevenuePer), df.format(expectedRevenuePer));
		System.out.println("Revenue percentage verified");
		// Validation for Revenue per Terminal
		double expectedRevenuePerTerminal = expectedRevenueAmount / sellingTerminal;
		double actualRevenuePerTerminal = rrd.getRevenuePerTerminal();
		Assert.assertEquals(df.format(actualRevenuePerTerminal), df.format(expectedRevenuePerTerminal));
		System.out.println("Revenue per terminal verified");
	
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}