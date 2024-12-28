package com.ptron.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;
import com.ptron.pom.VendorsPage;

public class CreateVendor extends BaseClass{
@Test
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
}
