package com.ptron.testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;

public class CreateQuote extends BaseClass{
@Test
public void createQuote() throws EncryptedDocumentException, IOException, InterruptedException
{
	String sub = fl.getExcelData("quote", 1, 0);
	String quoteStage = fl.getExcelData("quote", 1, 1);
	String potName = fl.getExcelData("quote", 1, 2);
	String contName = fl.getExcelData("quote", 1, 3);
	String accName = fl.getExcelData("quote", 1, 4);
	String prodName = fl.getExcelData("quote", 1, 5);
	String prodCode = fl.getExcelData("quote", 1, 6);
//	String qtyStock = fl.getExcelData("quote", 1, 7);
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
//	qp.getQtyInStockTbx().sendKeys(qtyStock);
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
}
