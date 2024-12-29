package com.ptron.testscript.e_e;

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

import com.ptron.generic.BaseClass;
import com.ptron.generic.FileLibrary;
import com.ptron.pom.AccountPage;
import com.ptron.pom.CampaignPage;
import com.ptron.pom.LeadPage;
@Listeners(com.ptron.generic.ListnerImplementation.class)
public class Camp_Invoice extends BaseClass{
	@Test (priority = 1)
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
	}
	
	@Test(priority = 2)
	public void createLead() throws EncryptedDocumentException, IOException
	{
		hp.getLeadsLink().click();
		FileLibrary fl = new FileLibrary();
		 int prefix = Integer.valueOf(fl.getExcelData("lead",1,0));
		String fn = fl.getExcelData("lead", 1, 1);
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
				lp.createLead(prefix, fn, desg, phone, mob, prefix, i, annRev, companny, lastName, desc);;
				break;
				}
			catch (NoSuchElementException e)
				{
				}
		}
}
	
	@Test (priority = 3)
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
	
	
	@Test(priority = 4)
	public void createQuote() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String sub = fl.getExcelData("quote", 1, 0);
		String quoteStage = fl.getExcelData("quote", 1, 1);
		String potName = fl.getExcelData("quote", 1, 2);
		String contName = fl.getExcelData("quote", 1, 3);
		String accName = fl.getExcelData("quote", 1, 4);
		String prodName = fl.getExcelData("quote", 1, 5);
		String prodCode = fl.getExcelData("quote", 1, 6);
//		String qtyStock = fl.getExcelData("quote", 1, 7);
		String qtyTbx = fl.getExcelData("quote", 1, 8);
		String unitPrice = fl.getExcelData("quote", 1, 9);
		String listPrice = fl.getExcelData("quote", 1, 10);
		String priceBookName = fl.getExcelData("quote", 1, 11);
		String tcText = fl.getExcelData("quote", 1, 12);
		String desc = fl.getExcelData("quote", 1, 13);
		for(int i=0; i<=35; i++)
		{
		hp.getRightScroolBtn().click();
		}
		hp.getQuotesLink().click();
		qp.getNewQuote().click();
		qp.getSubjectTbx().sendKeys(sub);
		Select s = new Select(qp.getQuoteStageDrp());
		s.selectByVisibleText(quoteStage);
		String pwid = driver.getWindowHandle();
		qp.getPotNameLookUpIcon().click();
		Set<String> allwid = driver.getWindowHandles();
		for (String string : allwid) {
			driver.switchTo().window(string);
		}
		List<WebElement> potNames = qp.getPotNames();
		for (WebElement webElement : potNames) {
			if(webElement.getText().equalsIgnoreCase(potName))
			{
				webElement.click();
				break;
			}
		}
		driver.switchTo().window(pwid);
		qp.getContactLookUpIcon().click();
		Set<String> allwid1 = driver.getWindowHandles();
		for (String string : allwid1) {
			driver.switchTo().window(string);
		}
		List<WebElement> contNames = qp.getContactNames();
		for (WebElement webElement : contNames) {
			if(webElement.getText().equalsIgnoreCase(contName))
			{
				webElement.click();
				break;
			}
		}
		driver.switchTo().window(pwid);
		qp.getAcctLookupIcon().click();
		Set<String> allwid2 = driver.getWindowHandles();
		for (String string : allwid2) {
			driver.switchTo().window(string);
		}
		List<WebElement> accNames= qp.getAccountNames();
		for (WebElement webElement : contNames) {
			if(webElement.getText().equalsIgnoreCase(accName))
			{
				webElement.click();
				break;
			}
		}
		driver.switchTo().window(pwid);
		qp.getProductIcon().click();
		Set<String> allwid3 = driver.getWindowHandles();
		for (String string : allwid3) {
			driver.switchTo().window(string);
		}
		List<WebElement> prodNames = qp.getProductNames();
		for (WebElement webElement : prodNames) {
			if(webElement.getText().equalsIgnoreCase(prodName))
			{
				webElement.click();
				break;
			}
		}
		driver.switchTo().window(pwid);
		qp.getProdCodeTbx().sendKeys(prodCode);
//		qp.getQtyInStockTbx().sendKeys(qtyStock);
		qp.getQtyTbx().sendKeys(qtyTbx);
		qp.getUnitPriceTbx().sendKeys(unitPrice);
		qp.getListPriceIcon().click();
		Set<String> allwid4 = driver.getWindowHandles();
		for (String string : allwid4) {
			driver.switchTo().window(string);
		}
		qp.getPriceBookName().click();
		driver.switchTo().window(pwid);
		qp.getTcTxtArea().sendKeys(tcText);
		qp.getDesc().sendKeys(desc);
		qp.getSaveBtn().click();
		if(qp.getQuoteText().getText().contains("Quote"))
		{
			Assert.assertTrue(true);
		}
	}

	@Test (priority = 5)
	public void createInvoice() throws EncryptedDocumentException, IOException
	{
		String sub = fl.getExcelData("invoice", 1, 0);
		String accName = fl.getExcelData("invoice", 1, 1);
		String prodName = fl.getExcelData("invoice", 1, 2);
		String qty = fl.getExcelData("invoice", 1, 3);
		String listPrice = fl.getExcelData("invoice", 1, 4);
		String tc = fl.getExcelData("invoice", 1, 5);
		String desc = fl.getExcelData("invoice", 1, 6);
		
		for(int i=0; i<50; i++)
		{
			ip.getOnrightClick().click();
		}
		hp.getInvoicesLink().click();
		ip.getNewInvoiceBtn().click();
		ip.getSubjectTbx().sendKeys(sub);
		String pwid = driver.getWindowHandle();
		ip.getAccountNameLookUpIcon().click();
		 Set<String> allwid = driver.getWindowHandles();
		 for (String string : allwid) {
			driver.switchTo().window(string);
		}
		 List<WebElement> accNames = ip.getAcctName();
		 for (WebElement webElement : accNames) {
			if(webElement.getText().equalsIgnoreCase(accName))
			{
				webElement.click();
				break;
			}
		}
		 driver.switchTo().window(pwid);
		 String pwid1 = driver.getWindowHandle();
		 ip.getProductLookUpIcon().click();
		 Set<String> allwid1 = driver.getWindowHandles();
		 for (String string : allwid1) {
			driver.switchTo().window(string);
		}
		 List<WebElement> prodNames = ip.getProductNames();
		 for (WebElement webElement : prodNames) {
			if(webElement.getText().equalsIgnoreCase(prodName))
			{
				webElement.click();
				break;
			}
		}
		 driver.switchTo().window(pwid1);
		 ip.getQtyTbx().sendKeys(qty);
		 ip.getListPrice().sendKeys(listPrice);
		 ip.getTermCondTxtArea().sendKeys(tc);
		 ip.getDescTxtArea().sendKeys(desc);
		 ip.getSaveBtn().click();
		Assert.assertTrue(ip.getInvoiceGetText().getText().contains("Invoice"));
		
	}
}
