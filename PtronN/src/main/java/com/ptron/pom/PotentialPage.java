package com.ptron.pom;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;

public class PotentialPage {
@FindBy(linkText = "New Potential")
private WebElement newPontentialLink;
@FindBy(xpath = "//tr[@id='row1']//input[@name='property(Potential Name)']")
private WebElement potentialName;
@FindBy(xpath = "//img[@title='Account Name Lookup']")
private WebElement accountNameLookUpIcon;
@FindBy(xpath = "//tr[@id='row2']//input[@name='property(Account Name)']")
private WebElement accountNameTbx;
@FindBy(xpath = "//a[@href='javascript:;']")
private List<WebElement> acctName;
@FindBy(xpath = "//img[contains(@onclick,'showCal(')]")
private WebElement dateLookUpIcon;
@FindBy(xpath = "//a[contains(@href,'veYear(-1)')]")
private WebElement yearBackwardBtn;
@FindBy(className = "calDay")
private List<WebElement> dateSelect;
@FindBy(xpath = "//tr[@id='row2']//select[@name='property(Stage)']")
private WebElement stageDrp;
@FindBy(xpath = "//form[contains(@onsubmit,'else { return false }')]//input[@value='Save']")
private WebElement saveBtn;
@FindBy(xpath = "//tr[@id='row1']//input[@name='property(Closing Date)']")
private WebElement dateTbx;


public PotentialPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}



public WebElement getNewPontentialLink() {
	return newPontentialLink;
}

public WebElement getPotentialName() {
	return potentialName;
}

public WebElement getAccountNameLookUpIcon() {
	return accountNameLookUpIcon;
}

public WebElement getDateTbx() {
	return dateTbx;
}

public List<WebElement> getAcctName() {
	return acctName;
}


public WebElement getAccountNameTbx() {
	return accountNameTbx;
}

public WebElement getDateLookUpIcon() {
	return dateLookUpIcon;
}

public WebElement getYearBackwardBtn() {
	return yearBackwardBtn;
}

public List<WebElement> getDateSelect() {
	return dateSelect;
}

public WebElement getStageDrp() {
	return stageDrp;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public void createPotential(WebDriver driver, String potName , String accName , int yearBack , String dateSel , int stageIndex)
{
	potentialName.sendKeys(potName);
	accountNameLookUpIcon.click();
	String parent = driver.getWindowHandle();
	Set<String> wid = driver.getWindowHandles();
		for (String string : wid)
		{
			driver.switchTo().window(string);
		}
		for (WebElement accnames: acctName)
		{
			if(accnames.getText().equals(accName))
			{
				accnames.click();
				break;
			}
		}
		driver.switchTo().window(parent);
		dateLookUpIcon.click();
		Set<String> wid1 = driver.getWindowHandles();
		for (String string : wid) 
		{
			driver.switchTo().window(string);
		}
		for(int i=1; i<=5; i++)
		{
			yearBackwardBtn.click();
		}
		for(WebElement string : dateSelect) 
		{
			if(string.getText().equals(dateSel))
			{
				string.click();
				break;
			}
		}
		driver.switchTo().window(parent);
		Select s = new Select(stageDrp);
		s.selectByIndex(stageIndex);
		saveBtn.click();
	}
	
}

