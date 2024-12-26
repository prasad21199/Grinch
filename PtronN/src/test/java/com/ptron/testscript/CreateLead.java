package com.ptron.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;
import com.ptron.generic.FileLibrary;
import com.ptron.pom.LeadPage;

public class CreateLead extends BaseClass{
	@Test
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
}