package com.ptron.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {
@FindBy(xpath = "//input[@onclick='createAction()']")
private WebElement newSalesOrderBtn;
@FindBy(name = "property(Subject)")
private WebElement subjectTbx;
@FindBy(name = "property(Account Name)")
private WebElement accountNameTbx;
@FindBy(name = "property(hdnProductName1)")
private WebElement prodNameTbx;
@FindBy(name = "property(txtQty1)")
private WebElement qtyTbx;
@FindBy(name = "property(txtListPrice1)")
private WebElement listPriceTbx;
@FindBy(xpath = "//input[@value='Save']")
private WebElement saveBtn;

public SalesOrderPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getNewSalesOrderBtn() {
	return newSalesOrderBtn;
}

public WebElement getSubjectTbx() {
	return subjectTbx;
}

public WebElement getAccountNameTbx() {
	return accountNameTbx;
}

public WebElement getProdNameTbx() {
	return prodNameTbx;
}

public WebElement getQtyTbx() {
	return qtyTbx;
}

public WebElement getListPriceTbx() {
	return listPriceTbx;
}

public WebElement getSaveBtn() {
	return saveBtn;
}


}
