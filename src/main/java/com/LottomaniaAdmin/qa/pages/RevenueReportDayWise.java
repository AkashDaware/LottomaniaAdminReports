package com.LottomaniaAdmin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.LottomaniaAdmin.qa.base.TestBase;

public class RevenueReportDayWise extends TestBase{

	//PageFactory or Object Repository
	//Click on report
	@FindBy(xpath = "//li[@id='header:sm_Reports']/a")
	WebElement report;

	//Click on Revenue Report Datewise
	@FindBy(xpath = "//a[@href='/Console/DateWiseRevenueReport.xhtml']")
	WebElement rrd;

	//SelectCompanyNameDropDown
	@FindBy(id = "j_idt41:cmpny_label")
	WebElement CompanyNameDropDown;

	//SelectCompanyName
	String Company = prop.getProperty("company");
	By CompanyName = By.xpath("//li[. = " + Company +"]");


	//AgentDropdown
	@FindBy(id = "j_idt41:sAgnt_label")
	WebElement AgentDropDown;

	//SelectAgentName
	String Agent = prop.getProperty("agent");
	By AgentName = By.xpath("//li[. = " + Agent +"]");

	//SubAgentDropDown
	@FindBy(id = "j_idt41:pAgnt_label")
	WebElement SubAgentDropDown;

	//SelectSubAgent
	String SubAgent = prop.getProperty("subAgent");
	By SubAgentName = By.xpath("//li[. = " + SubAgent +"]");

	//RetailerDropDown
	@FindBy(id = "j_idt41:retlr_label")
	WebElement RetailerDropDown;

	//SelectRetailer
	String Retailer = prop.getProperty("retailer");
	By RetailerName = By.xpath("//li[. = " + Retailer +"]");

	//GameListDropDown
	@FindBy(id = "j_idt41:gameList_label")
	WebElement GameList;

	//SelectGameName
	String Game = prop.getProperty("game");
	By GameName = By.xpath("//li[. = " + Game +"]");

	//Click on  From Date Dropdown
	@FindBy(xpath="//div[2]/span//span[1]")
	WebElement fromDate;

	//Click on  From To Dropdown
	@FindBy(xpath="//div[5]/span//span[1]")
	WebElement toDate;

	//Click on current Date
	@FindBy(xpath="//button[. = 'Current Date']")
	WebElement currentDate;

	//SubmitDetails
	@FindBy(xpath ="//span[. = 'Submit']")
	WebElement SubmitButton;

	//Get Value of SSelling Terminal
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[2]")
	WebElement sellingTerminal;

	//Get Value of Sales
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[3]")
	WebElement salesAmount;

	//Get Value of Sales Bet Count
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[4]")
	WebElement salesBetCount;

	//Get Value of Cancel
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[5]")
	WebElement cancelAmount;

	//Get Value of Cancel bet count
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[6]")
	WebElement cancelBetCount;

	//Get Value of Net Sales
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[7]")
	WebElement netSales;

	//Get Value of Winning Amount
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[8]")
	WebElement winningAmount;

	//Get Value of Win Bet Count
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[9]")
	WebElement winBetCount;

	//Get Value of GGR
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[10]")
	WebElement ggr;

	//Get Value of GGR %
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[11]")
	WebElement ggrPer;

	//Get Value of Self Sales Commission
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[12]")
	WebElement selfSalesCommission;

	//Get Value of agent Sales Commission
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[13]")
	WebElement agentSalesCommission;

	//Get Value of Commission Refund
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[14]")
	WebElement commissionRefund;

	//Get Value of Revenue Amount
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[15]")
	WebElement revenueAmount;

	//Get Value of Revenue Percent
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[16]")
	WebElement revenuePer;

	//Get Value of Revenue Per Terminal
	@FindBy(xpath = "//tr[@class='ui-widget-content ui-datatable-even']/td[17]")
	WebElement revenuePerTerminal;

	// Initialize the Page Objects
	public RevenueReportDayWise() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public double  getBeforeReport() throws InterruptedException {
		CompanyNameDropDown.click();
		driver.findElement(CompanyName).click();
		Thread.sleep(1000L);
		AgentDropDown.click();
		driver.findElement(AgentName).click();
		Thread.sleep(1000L);
		SubAgentDropDown.click();
		driver.findElement(SubAgentName).click();
		Thread.sleep(1000L);
		RetailerDropDown.click();
		driver.findElement(RetailerName).click();
		Thread.sleep(1000L);
		GameList.click();
		driver.findElement(GameName).click();
		Thread.sleep(1000L);
		fromDate.click();
		currentDate.click();
		Thread.sleep(1000L);
		toDate.click();
		currentDate.click();
		SubmitButton.click();
		Thread.sleep(1000L);

		//Getting Sales Amount from admin for previous bet place
		getSalesAmount();
		return getSalesAmount();
	}


	public void getAfterReport() throws InterruptedException {
		CompanyNameDropDown.click();
		driver.findElement(CompanyName).click();
		Thread.sleep(6000L);
		AgentDropDown.click();
		driver.findElement(AgentName).click();
		Thread.sleep(1000L);
		SubAgentDropDown.click();
		driver.findElement(SubAgentName).click();
		Thread.sleep(1000L);
		RetailerDropDown.click();
		driver.findElement(RetailerName).click();
		Thread.sleep(1000L);
		GameList.click();
		driver.findElement(GameName).click();
		Thread.sleep(1000L);
		fromDate.click();
		currentDate.click();
		Thread.sleep(1000L);
		toDate.click();
		currentDate.click();
		SubmitButton.click();
		Thread.sleep(1000L);

	}

	public double getSellingTerminal() {
		String SellingTerminal = sellingTerminal.getText();
		double sellingTerminal = Float.parseFloat(SellingTerminal);
		return sellingTerminal;
	}


	public double getSalesAmount() {
		String SaleAmount = salesAmount.getText();
		double saleAmount = Float.parseFloat(SaleAmount);
		return saleAmount;
	}

	public double getSalesBetCount() {
		String SaleBetCount = salesBetCount.getText();
		double saleBetCount = Float.parseFloat(SaleBetCount);
		return saleBetCount;
	}

	public double getCancelAmount() {
		String CancelAmount = cancelAmount.getText();
		double cancelAmount = Float.parseFloat(CancelAmount);
		return cancelAmount;
	}

	public double getCancelBetCount() {
		String CancelBetCount = cancelBetCount.getText();
		double cancelBetCount = Float.parseFloat(CancelBetCount);
		return cancelBetCount;
	}

	public double getNetSales() {
		String NetSale = netSales.getText();
		double netSale = Float.parseFloat(NetSale);
		return netSale;
	}

	public double getWinningAmount() {
		String WinningAmount = winningAmount.getText();
		double winningAmount = Float.parseFloat(WinningAmount);
		return winningAmount;
	}

	public double getWinningBetCount() {
		String WinBetCount = winBetCount.getText();
		double winBetCount = Float.parseFloat(WinBetCount);
		return winBetCount;
	}	

	public double getGGR() {
		String GGR = ggr.getText();
		double gGR = Float.parseFloat(GGR);
		return gGR;
	}	

	public double getGGRPer() {
		String GGRPer = ggrPer.getText();
		double gGGRPer = Float.parseFloat(GGRPer);
		return gGGRPer;
	}

	public double getSelfComission(){
		String SelfCommission = selfSalesCommission.getText();
		double selfCommission = Float.parseFloat(SelfCommission);
		return selfCommission;
	}

	public double getAgentComission() {
		String AgentCommission = agentSalesCommission.getText();
		double agentCommission = Float.parseFloat(AgentCommission);
		return agentCommission;
	}

	public double getComissionRefund() {
		String CommissionRefund = commissionRefund.getText();
		double commissionRefund = Float.parseFloat(CommissionRefund);
		return commissionRefund;
	}

	public double getRevenueAmount() {
		String RevenueAmount = revenueAmount.getText();
		double revenueAmount = Float.parseFloat(RevenueAmount);
		return revenueAmount;
	}

	public double getRevenuePer() {
		String RevenuePer = revenuePer.getText();
		double revenuePer = Float.parseFloat(RevenuePer);
		return revenuePer;
	}

	public double getRevenuePerTerminal() {
		String RevenuePerTerminal = revenuePerTerminal.getText();
		double revenuePerTerminal = Float.parseFloat(RevenuePerTerminal);
		return revenuePerTerminal;
	}

}
