package com.ptron.testscript;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;

import net.bytebuddy.asm.Advice.AllArguments;

public class CreateProduct extends BaseClass{
	@Test
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
}
