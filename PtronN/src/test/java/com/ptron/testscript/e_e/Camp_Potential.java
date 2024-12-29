package com.ptron.testscript.e_e;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ptron.generic.FileLibrary;
import com.ptron.generic.*;
import com.ptron.pom.CampaignPage;
import com.ptron.pom.LeadPage;
import com.ptron.pom.PotentialPage;
@Listeners(com.ptron.generic.ListnerImplementation.class)
public class Camp_Potential extends BaseClass {
	@Test (priority = 1)
	public void createCampagin() throws IOException
	{
		for(int i=0; i<1000; i++)
		{
			try {
					hp.getCampaignLink().click();
					CampaignPage cp = new CampaignPage(driver);
					String campName = fl.getExcelData("campaign", 2, 0);
					String startDate = fl.getExcelData("campaign", 2, 1);
					String expRevenue = fl.getExcelData("campaign", 2, 2);
					String actCost = fl.getExcelData("campaign", 2, 3);
					String numSent = fl.getExcelData("campaign", 2, 4);
					int typeDrp = Integer.valueOf(fl.getExcelData("campaign", 2, 5));
					int statusDrp = Integer.valueOf(fl.getExcelData("campaign", 2, 6));
					String endDate = fl.getExcelData("campaign", 2, 7);
					String budgetCost = fl.getExcelData("campaign", 2, 8);
					String expResponse = fl.getExcelData("campaign", 2, 9);
					String desc = fl.getExcelData("campaign", 2, 10);
					cp.createCampaign(campName, startDate, expRevenue, actCost, numSent, typeDrp, statusDrp, endDate, budgetCost, expResponse, desc);
					if(cp.getCampDetails().getText().equals("Campaign Details"))
					{
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertFalse(false);
					}
					break;
				}
			catch (NoSuchElementException e) {
				driver.navigate().refresh();
			}
		}
	}
	@Test (priority = 2)
	public void createLead() throws EncryptedDocumentException, IOException
	{
		for(int j=0; j<1000; j++)
		{
			try 
			{
				hp.getLeadsLink().click();
				FileLibrary fl = new FileLibrary();
				 int prefix = Integer.valueOf(fl.getExcelData("lead",1,0));
				String fn = (fl.getExcelData("lead", 1, 1));
				String desg = fl.getExcelData("lead", 1, 2);
				String phone = fl.getExcelData("lead", 1, 3);
				String mob = fl.getExcelData("lead", 1, 4);
				String leadSource = fl.getExcelData("lead", 1, 5);
				String indDrp = fl.getExcelData("lead", 1, 6);
				String annRev = fl.getExcelData("lead", 1, 7);
				String companny = fl.getExcelData("lead", 1, 8);
				String lastName = fl.getExcelData("lead", 1, 9);
				String desc = fl.getExcelData("lead", 1, 10);
				LeadPage lp = new LeadPage(driver);
				System.out.println(prefix);
				lp.getNewLeadLink().click();
				for(int i=0; i<1000; i++) 
				{
					try {
						lp.createLead(prefix, fn, desg, phone, mob, prefix, i, annRev, companny, lastName, desc);
						break;
						}
					catch (NoSuchElementException e)
						{
						}
				}
				break;
			}
			catch (NoSuchElementException e) {
				driver.navigate().refresh();
			}
		}
	}
	@Test (priority = 3)
	public void convertToPotential() throws EncryptedDocumentException, IOException, InterruptedException
	{
		for(int i=0; i<1000; i++)
		{
			try
			{
				hp.getLeadsLink().click();
				LeadPage lp = new LeadPage(driver);
				String fn = fl.getExcelData("lead", 1, 1);
				String ln = fl.getExcelData("lead", 1, 9);
				String dateSel = fl.getExcelData("lead", 1, 11);
				String potStageD = fl.getExcelData("lead", 1, 12);
				 List<WebElement> leadNames = lp.getLeadsNames();
				 for (WebElement webElement : leadNames) {
					if(webElement.getText().equals(fn+" "+ln))
					{
						webElement.click();
						break;
					}
				}
				 lp.getConvertBtn().click();
				 lp.getDateLookupIcon().click();
				 String pwid = driver.getWindowHandle();
				 Set<String> awid = driver.getWindowHandles();
				 for (String string : awid) {
					driver.switchTo().window(string);
				}
				 for(int j=0; j<10; j++) {
				 lp.getYearBack().click();
				 }
				 List<WebElement> date = lp.getDateSel();
				 for (WebElement webElement : date) {
					if(webElement.getText().equals(dateSel))
					{
						webElement.click();
						break;
					}
				}
				 driver.switchTo().window(pwid);
				 Select s = new Select(lp.getPotStage());
				 s.selectByIndex(Integer.valueOf(potStageD));
				 lp.getSaveBtnCnvtPot().click();
				if (ap.getAccountDetailsPage().getText().contains("Account"))
				{
					Reporter.log("sucess", true);
				}
				else
					Assert.fail();
				break;
			}
			catch (NoSuchElementException e) {
				driver.navigate().refresh();
			}
			}
		Assert.assertTrue(camp.getCampDetails().getText().contains("Campaign Details"));
		}
		
	}

