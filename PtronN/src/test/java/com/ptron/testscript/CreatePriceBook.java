package com.ptron.testscript;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;

public class CreatePriceBook extends BaseClass {
	@Test
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

