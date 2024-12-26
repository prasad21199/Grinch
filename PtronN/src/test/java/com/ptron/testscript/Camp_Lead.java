package com.ptron.testscript;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;
import com.ptron.generic.FileLibrary;
import com.ptron.pom.CampaignPage;
import com.ptron.pom.LeadPage;

public class Camp_Lead extends BaseClass {
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
}
