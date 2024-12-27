package com.quander.testscript;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class CreatePotential extends basecl
{
	@Test
public void createPotential() throws EncryptedDocumentException, IOException, InterruptedException
{
	String potName = fl.getExcelData("potential", 1, 0);
	String accName = fl.getExcelData("potential", 1, 1);
	int yearBack = Integer.valueOf(fl.getExcelData("potential", 1, 2));
	String dateSel = fl.getExcelData("potential", 1, 3);
	int stageindex =Integer.valueOf(fl.getExcelData("potential", 1, 4));
	String date = fl.getExcelData("potential", 1, 5);
	PotentialPage potential = new PotentialPage(driver);
	hp.getPotentialsLink().click();
	potential.getNewPontentialLink().click();
	for(int i=0; i<2000; i++) 
	{
		try 
		{
			potential.getPotentialName().sendKeys(potName);
			potential.getAccountNameTbx().sendKeys(accName);
			potential.getAccountNameLookUpIcon().click();
			String pwid = driver.getWindowHandle();
			Set<String> allwid = driver.getWindowHandles();
			for (String string : allwid) {
				driver.switchTo().window(string);
			}
			 List<WebElement> acctNames = potential.getAcctName();
			for (WebElement webElement : acctNames) {
				if(webElement.getText().equals(accName))
				{
					webElement.click();
					break;
				}
			}
			driver.switchTo().window(pwid);
			potential.getDateTbx().sendKeys(date);
			Select s = new Select(potential.getStageDrp());
			s.selectByIndex(stageindex);
			potential.getSaveBtn().click();
			break;
		}
		catch (NoSuchElementException e)
		{
		}
	}
	
}
}