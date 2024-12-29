package com.ptron.testscript.e_e;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;

public class Vendor_PriceBook extends BaseClass {
	@Test (priority = 1)
	public void createVendor() throws EncryptedDocumentException, IOException
	{
		String phone = fl.getExcelData("vendor", 1, 0);
		String website = fl.getExcelData("vendor", 1, 1);
		String cat = fl.getExcelData("vendor", 1, 2);
		String vn = fl.getExcelData("vendor", 1, 3);
		String email = fl.getExcelData("vendor", 1, 4);
		 int gla = Integer.valueOf(fl.getExcelData("vendor", 1, 5));
		String state = fl.getExcelData("vendor", 1, 6);
		String city = fl.getExcelData("vendor", 1, 7);
		String country = fl.getExcelData("vendor", 1, 8);
		String zip = fl.getExcelData("vendor", 1, 9);
		String desc = fl.getExcelData("vendor", 1, 10);
		hp.getVendorsLink().click();
		vp.getnVendors().click();
		vp.createVendor(phone, website, cat, vn, email, gla, state, city, state, country, zip, desc);
		vp.getSave().click();
	}
	@Test (priority = 2)
	public void createProduct() throws EncryptedDocumentException, IOException
	{
		for(int i=0; i<=1000; i++)
		{
			try{
				String prodCode = fl.getExcelData("product", 1, 0);
				String prodName = fl.getExcelData("product", 1, 1);
				String vendName = fl.getExcelData("product", 1, 2);
				String indexCat = fl.getExcelData("product", 1, 3);
				int indexM =Integer.valueOf(fl.getExcelData("product", 1, 4));
				String ssDate = fl.getExcelData("product", 1, 5);
				String sEndate = fl.getExcelData("product", 1, 6);
				String supStartD = fl.getExcelData("product", 1, 7);
				String saleEnd = fl.getExcelData("product", 1, 8);
				String unitprice = fl.getExcelData("product", 1,9);
				int indexU =Integer.valueOf(fl.getExcelData("product", 1, 10));
				String qtyStock = fl.getExcelData("product", 1, 11);
				String qtyDemand = fl.getExcelData("product", 1, 12);
				String desc = fl.getExcelData("product", 1, 13);
				hp.getProductsLink().click();
				pp.getNewProduct().click();
				pp.getProductCode().sendKeys(prodCode);
				pp.getProductName().sendKeys(prodName);
				pp.getVendorLookup().click();
				String pwid = driver.getWindowHandle();
				Set<String> alwid = driver.getWindowHandles();
				for (String string : alwid) {
					driver.switchTo().window(string);
				}
				 List<WebElement> vn = pp.getVendorName();
				 for (WebElement webElement : vn) {
					if(webElement.getTagName().equalsIgnoreCase(vendName))
					{
						webElement.click();
					}
				}
				driver.switchTo().window(pwid);
				Select s=new Select(pp.getProductCategory());
				pp.getProductCategory().click();
				Select s1=new Select(pp.getManufacturer());
				pp.getManufacturer().click();;
				s.selectByIndex(indexM);
				pp.getDate().sendKeys(ssDate);
//				pp.getSalesEnd().sendKeys(sEndate);
				pp.getSupportStart().sendKeys(supStartD);
				pp.getCalculator().sendKeys(unitprice);
				Select s4 = new Select(pp.getUsageUnit());
				pp.getUsageUnit().click();
				s4.selectByIndex(indexU);
				pp.getQtyInStock().sendKeys(qtyStock);
				pp.getQtyInDemand().sendKeys(qtyDemand);
				pp.getDesc().sendKeys(desc);
				pp.getSubmit().click();
				break;
			}
			catch (NoSuchElementException e) {
				driver.navigate().refresh();
			}
		}
	}
	@Test (priority = 3)
	public void createPricebook() throws EncryptedDocumentException, IOException 
	{
		for(int j=1; j<=50; j++)
		{
		try {
				for(int i=0; i<50; i++)
				{
					ip.getOnrightClick().click();
				}
			hp.getPriceBookLink().click();
			pbp.getCreatePricebook().click();
			String pbName = fl.getExcelData("pricebook", 1,0 );
			pbp.getPricebookName().sendKeys(pbName);
			pbp.getSubmit().click();
			break;
			}
		catch (NoSuchElementException e)
			{
			driver.navigate().refresh();
			}
		}
		if(pbp.getPriceBookText().getText().contains("Price Book Details"))
		{
			Assert.assertTrue(true);
		}
	}
}
