package com.ptron.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;
import com.ptron.pom.CampaignPage;
@Listeners(com.ptron.generic.ListnerImplementation.class)
public class CreateCampaign extends BaseClass {
	@Test
	public void createCampagin() throws IOException
	{
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
	}
}
