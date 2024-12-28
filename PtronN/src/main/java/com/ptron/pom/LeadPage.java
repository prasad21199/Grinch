package com.ptron.pom;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LeadPage {
	@FindBy(linkText = "New Lead")
	private WebElement newLeadLink;
	@FindBy(name = "property(saltName)")
	private WebElement prefixNameDrp;
	@FindBy(name = "property(First Name)")
	private WebElement firstNameTbx;
	@FindBy(name = "property(Designation)")
	private WebElement desgTbx;
	@FindBy(name = "property(Phone)")
	private WebElement phoneTbx;
	@FindBy(name = "property(Mobile)")
	private WebElement mobTbx;
	@FindBy(name = "property(Lead Source)")
	private WebElement leadSourceDrp;
	@FindBy(name = "property(Industry)")
	private WebElement industryDrp;
	@FindBy(xpath = "//table[@id='secContent1']//input[@name='property(Annual Revenue)']")
	private WebElement actualRevTbx;
	@FindBy(xpath = "//table[@id='secContent1']//input[@name='property(Company)']")
	private WebElement companyNameTbx;
	@FindBy(xpath = "//table[@id='secContent1']//input[@name='property(Last Name)']")
	private WebElement lastNameTbx;
	@FindBy(xpath = "//table[@class='secContent']//textarea[@name='property(Description)']")
	private WebElement descAreaBox;
	@FindBy(xpath = "//td[contains(text(),'Description')]/../../../..//input[@value='Save']")
	private WebElement saveBtn;
	@FindBy(xpath = "//img[contains(@title,'Campaign Na')]")
	private WebElement campaignNameLookUpIcon;
	@FindBy(xpath = "//a[contains(@href,'&module=Leads')]")
	private List<WebElement> leadsNames;
	@FindBy(xpath = "//div[@id='basic']//input[@name='Convert2']")
	private WebElement convertBtn;
	@FindBy(xpath = "//span[@id='potcal']//img")
	private WebElement dateLookupIcon;
	@FindBy(xpath =  "//a[contains(@href,'Year(-1)')]")
	private WebElement yearBack;
	@FindBy(className = "calDay")
	private List<WebElement> dateSel;
	@FindBy(xpath = "//select[contains(@onchange,'setPro')]")
	private WebElement potStage;
	@FindBy(name = "save")
	private WebElement saveBtnCnvtPot;
	@FindBy(xpath = "//a[contains(@href,'javascript:if (window.opener && !window.opener.closed && window.opener.pre')]")
	private WebElement monthBtn;
	@FindBy(xpath = "//td[contains(text(),'Lead Details')]")
	private WebElement leadDetailsPg;

	public LeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDateLookupIcon() {
		return dateLookupIcon;
	}
	public WebElement getMonthBtn() {
		return monthBtn;
	}
	

	public WebElement getPrefixNameDrp() {
		return prefixNameDrp;
	}

	public WebElement getFirstNameTbx() {
		return firstNameTbx;
	}

	public WebElement getDesgTbx() {
		return desgTbx;
	}

	public WebElement getPhoneTbx() {
		return phoneTbx;
	}

	public WebElement getMobTbx() {
		return mobTbx;
	}

	public WebElement getLeadSourceDrp() {
		return leadSourceDrp;
	}

	public WebElement getIndustryDrp() {
		return industryDrp;
	}

	public WebElement getActualRevTbx() {
		return actualRevTbx;
	}

	public WebElement getCompanyNameTbx() {
		return companyNameTbx;
	}

	public WebElement getLastNameTbx() {
		return lastNameTbx;
	}

	public WebElement getDescAreaBox() {
		return descAreaBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCampaignNameLookUpIcon() {
		return campaignNameLookUpIcon;
	}

	public WebElement getLeadDetailsPg() {
		return leadDetailsPg;
	}

	public WebElement getYearBack() {
		return yearBack;
	}

	public List<WebElement> getDateSel() {
		return dateSel;
	}

	public WebElement getPotStage() {
		return potStage;
	}
	

	public WebElement getSaveBtnCnvtPot() {
		return saveBtnCnvtPot;
	}

	public void createLead(int namePrefix , String firstName, String desg , String phonenum , String mobNum 
			, int leadSrcDrp , int industryDrp , String actualRev , String compName , String lastName
			, String desc)
	{
		Select s = new Select(prefixNameDrp);
		s.selectByIndex(namePrefix);
		firstNameTbx.sendKeys(firstName);
		desgTbx.sendKeys(desg);
		phoneTbx.sendKeys(phonenum);
		mobTbx.sendKeys(mobNum);
		Select s1 = new Select(leadSourceDrp);
		s1.selectByIndex(leadSrcDrp);
		actualRevTbx.sendKeys(actualRev);
		companyNameTbx.sendKeys(compName);
		lastNameTbx.sendKeys(lastName);
		saveBtn.click();
	}
	public WebElement getNewLeadLink() {
		return newLeadLink;
	}
	

	public WebElement getConvertBtn() {
		return convertBtn;
	}

	public List<WebElement> getLeadsNames() {
		return leadsNames;
	}
	
}
