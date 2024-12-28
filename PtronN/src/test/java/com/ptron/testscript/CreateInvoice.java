package com.ptron.testscript;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;
@Listeners(com.ptron.generic.ListnerImplementation.class)
public class CreateInvoice extends BaseClass{
@Test
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
	
	
}
}
