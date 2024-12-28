package com.ptron.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;


public class CreateSalesOrder extends BaseClass {
	@Test
	public void createSalesOrder() throws EncryptedDocumentException, IOException {
		String sub = fl.getExcelData("salesorder", 1, 0);
		String name = fl.getExcelData("salesorder", 1, 1);
		String pname = fl.getExcelData("salesorder", 1, 2);
		String qty = fl.getExcelData("salesorder", 1, 3);
		String lprice = fl.getExcelData("salesorder", 1, 4);
		for(int i=0;i<30;i++) 
		{
			hp.getRightScroolBtn().click();
		}
		hp.getSalesOrderLink().click();
		so.getNewSalesOrderBtn().click();
		so.getSubjectTbx().sendKeys(sub);
		so.getAccountNameTbx().sendKeys(name);
		so.getProdNameTbx().sendKeys(pname);
		so.getQtyTbx().sendKeys(qty);
		so.getListPriceTbx().sendKeys(lprice);
		so.getSaveBtn().click();
	}
}
