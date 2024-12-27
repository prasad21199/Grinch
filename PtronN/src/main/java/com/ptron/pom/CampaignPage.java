package com.ptron.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CampaignPage {
	@FindBy(linkText = "New Campaign")
	private WebElement newCampaignLink;
	@FindBy(name  = "property(Campaign Name)")
	private WebElement campaignNameTbx;
	@FindBy(xpath = "//table[@class='secContent']//input[@name='property(Start Date)']")
	private WebElement startDateTbx;
	@FindBy(xpath = "//table[@class='secContent']//input[@name='property(Expected Revenue)']")
	private WebElement expectedRevenueTbx;
	@FindBy(xpath = "//table[@class='secContent']//input[@name='property(Actual Cost)']")
	private WebElement actualCostTbx;
	@FindBy(xpath = "//table[@class='secContent']//input[@name='property(Num sent)']")
	private WebElement numSentTbx;
	@FindBy(xpath = "//table[@class='secContent']//select[@name='property(Type)']")
	private WebElement typeDropDown;
	@FindBy(xpath = "//table[@class='secContent']//select[@name='property(Status)']")
	private WebElement statusDropDown;
	@FindBy(xpath = "//table[@class='secContent']//input[@name='property(End Date)']")
	private WebElement endDateTbx;
	@FindBy(xpath = "//table[@class='secContent']//input[@name='property(Budgeted Cost)']")
	private WebElement budgetCostTbx;
	@FindBy(xpath = "//table[@class='secContent']//input[@name='property(Expected Response)']")
	private WebElement expectedResponseTbx;
	@FindBy(xpath = "//table[@class='secContent']//textarea[@name='property(Description)']")
	private WebElement descAreaBox;
	@FindBy(xpath = "//td[contains(text(),'Description')]/../../../..//input[@value='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//td[contains(text(),'Campaign Details')]")
	private WebElement campDetails;
	
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void createCampaign(String campaignName , String startDate , String expectedRevenue , String actualCost , 
			String numSent , int typeDrp , int statusDrp , String endDate , String budgetCost , 
			String expectedResponse , String descArea )
	{
		newCampaignLink.click();
		campaignNameTbx.sendKeys(campaignName);
		startDateTbx.sendKeys(startDate);
		expectedRevenueTbx.sendKeys(expectedResponse);
		actualCostTbx.sendKeys(actualCost);
		numSentTbx.sendKeys(numSent);
		Select s = new Select(typeDropDown);
		s.selectByIndex(typeDrp);
		Select s1 = new Select(statusDropDown);
		s1.selectByIndex(statusDrp);
		endDateTbx.sendKeys(endDate);
		budgetCostTbx.sendKeys(budgetCost);
		expectedResponseTbx.sendKeys(expectedResponse);
		descAreaBox.sendKeys(descArea);
		saveBtn.click();
	}
	public WebElement getCampDetails() {
		return campDetails;
	}
}
