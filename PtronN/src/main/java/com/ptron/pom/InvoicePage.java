package com.ptron.pom;

import java.util.List;

import org.checkerframework.checker.signature.qual.PrimitiveType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

public class InvoicePage {
@FindBy(xpath = "//input[@value='New Invoice']")
private WebElement newInvoiceBtn;
@FindBy(xpath = "//input[@name='property(Subject)']")
private WebElement subjectTbx;
@FindBy(xpath = "//img[@title='Account Name Lookup']")
private WebElement accountNameLookUpIcon;
@FindBy(xpath = "//a[@href='javascript:;']")
private List<WebElement> acctName;
@FindBy(xpath = "//tr[@id='hrow1']//img[@title='Product Name Lookup']")
private WebElement productLookUpIcon;
@FindBy(xpath = "//a[@href='javascript:;']")
private List<WebElement> productNames;
@FindBy(name = "property(txtQty1)")
private WebElement qtyTbx;
@FindBy(name = "property(txtListPrice1)")
private WebElement listPrice;
@FindBy(xpath = "//input[@value='Add Product']")
private WebElement addProductBtn;
@FindBy(className = "pointer")
private WebElement deletRowProductIcon;
@FindBy(name = "property(Terms and Conditions)")
private WebElement termCondTxtArea;
@FindBy(name = "property(Description)")
private WebElement descTxtArea;
@FindBy(xpath = "//input[@value='Save']")
private WebElement saveBtn;
@FindBy(xpath  = "//img[@onclick='moveright()']")
private WebElement onrightClick;
@FindBy(xpath = "//td[@class='title hline']")
private WebElement invoiceGetText;

public InvoicePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getNewInvoiceBtn() {
	return newInvoiceBtn;
}


public WebElement getOnrightClick() {
	return onrightClick;
}

public WebElement getSubjectTbx() {
	return subjectTbx;
}

public WebElement getAccountNameLookUpIcon() {
	return accountNameLookUpIcon;
}

public List<WebElement> getAcctName() {
	return acctName;
}

public WebElement getProductLookUpIcon() {
	return productLookUpIcon;
}

public List<WebElement> getProductNames() {
	return productNames;
}

public WebElement getQtyTbx() {
	return qtyTbx;
}

public WebElement getListPrice() {
	return listPrice;
}

public WebElement getAddProductBtn() {
	return addProductBtn;
}

public WebElement getDeletRowProductIcon() {
	return deletRowProductIcon;
}

public WebElement getTermCondTxtArea() {
	return termCondTxtArea;
}

public WebElement getInvoiceGetText() {
	return invoiceGetText;
}

public WebElement getDescTxtArea() {
	return descTxtArea;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

}
