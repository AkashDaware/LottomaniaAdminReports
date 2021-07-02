package com.LottomaniaAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.LottomaniaAdmin.qa.base.TestBase;

public class TicketSearch extends TestBase{

	//PageFactory or Object Repository
	//TickeT TSN TextBox
	@FindBy(id = "formip:inp")
	WebElement tsnSearchBox;
	
	//TSN Search
	@FindBy(xpath = "//span[@class='ui-button-text ui-c']")
	WebElement searchButton;
	
	

	



}
