package com.ptron.testscript;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ptron.pom.AccountPage;
import com.ptron.generic.*;
import com.ptron.pom.LeadPage;
@Listeners(com.ptron.generic.ListnerImplementation.class)
public class ConvertToPotential extends BaseClass{
	@Test
	public void convertLeadToPotential() throws EncryptedDocumentException, IOException, InterruptedException
	{
		hp.getLeadsLink().click();
		LeadPage lp = new LeadPage(driver);
		String fn = fl.getExcelData("lead", 1, 1);
		String ln = fl.getExcelData("lead", 1, 9);
		String dateSel = fl.getExcelData("lead", 1, 11);
		String potStageD = fl.getExcelData("lead", 1, 12);
		String cDate = fl.getExcelData("lead", 1, 13);
		 List<WebElement> leadNames = lp.getLeadsNames();
		 for (WebElement webElement : leadNames) {
			if(webElement.getText().equals(fn+" "+ln))
			{
				webElement.click();
				break;
			}
		}
		 lp.getConvertBtn().click();
		 lp.getCloseDateTbx().sendKeys(cDate);
		 Select s = new Select(lp.getPotStage());
		 s.selectByIndex(Integer.valueOf(potStageD));
		 lp.getSaveBtnCnvtPot().click();
		 AccountPage ap = new AccountPage(driver);
		 if(ap.getAccountDetailsPage().getTagName().contains("Account"))
		 {
			 Assert.assertTrue(true);
		 }
		 else
			 Assert.assertFalse(false);
	}
	
//	@Test
//	public void createPricebook() throws EncryptedDocumentException, IOException 
//	{
//		for(int j=1; j<=50; j++)
//		{
//		try {
//				for(int i=0; i<50; i++)
//				{
//					ip.getOnrightClick().click();
//				}
//			hp.getPriceBookLink().click();
//			pbp.getCreatePricebook().click();
//			String pbName = fl.getExcelData("pricebook", 1,0 );
//			pbp.getPricebookName().sendKeys(pbName);
//			pbp.getSubmit().click();
//			break;
//			}
//		catch (NoSuchElementException e)
//			{
//			driver.navigate().refresh();
//			}
//		}
//	}

}
