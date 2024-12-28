package com.ptron.testscript;

import java.io.IOException;
import java.util.List;
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
		 for(int i=0; i<10; i++) {
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
//		 AccountPage ap = new AccountPage(driver);
//		 if(!(ap.getAccountDetailsPage().getText().contains("Account Details")))
//		 {
//			 Assert.fail();
//		 }
	}

}
