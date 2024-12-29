package com.ptron.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public class QuotesPage {
@FindBy(xpath = "//input[@value='New Quote']")
private WebElement newQuote;
@FindBy(xpath = "//input[@name='property(Subject)']")
private WebElement subjectTbx;
@FindBy(name = "property(Quote Stage)")
private WebElement quoteStageDrp;
@FindBy(xpath = "//img[@title='Potential Name Lookup']")
private WebElement potNameLookUpIcon;
@FindBy (xpath = "//a[@href='javascript:;']")
private List<WebElement> potNames;
@FindBy(xpath = "//img[@title='Contact Name Lookup']")
private WebElement contactLookUpIcon;
@FindBy(xpath = "//a[contains(@href,'javascript')]")
private List<WebElement> contactNames;
@FindBy(xpath = "//img[@title='Account Name Lookup']")
private WebElement acctLookupIcon;
@FindBy(xpath = "//a[@href='javascript:;']")
private List<WebElement> accountNames;
@FindBy(xpath = "//img[@title='Product Name Lookup']")
private WebElement productIcon;
@FindBy(xpath = "//a[@href='javascript:;']")
private List<WebElement> productNames;
@FindBy(name = "property(hdnProductCode1)")
private WebElement prodCodeTbx;
@FindBy(id = "hdnQtyStock1")
private WebElement qtyInStockTbx;
@FindBy(id = "txtQty1")
private WebElement qtyTbx;
@FindBy(id = "hdnUnitPrice1")
private WebElement unitPriceTbx;
@FindBy(xpath = "//img[@title='PriceBook Name Lookup']")
private WebElement listPriceIcon;
@FindBy(xpath = "//input[@id='txtListPrice1']")
private WebElement listPriceTbx;
@FindBy(xpath = "//a[@href='javascript:;']")
private WebElement priceBookName;
@FindBy(name = "property(Terms and Conditions)")
private WebElement tcTxtArea;
@FindBy(name = "property(Description)")
private WebElement desc;
@FindBy(xpath = "//input[@value='Save']")
private WebElement saveBtn;
@FindBy(xpath = "//form[@name='ProductLookUpForm']//td[@nowrap][3]")
private List<WebElement> listPrice;
@FindBy(xpath = "//td[@class='title hline']")
private WebElement quoteText;

public QuotesPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public List<WebElement> getListPrice() {
	return listPrice;
}

public WebElement getQuoteText() {
	return quoteText;
}

public WebElement getNewQuote() {
	return newQuote;
}

public WebElement getSubjectTbx() {
	return subjectTbx;
}

public WebElement getQuoteStageDrp() {
	return quoteStageDrp;
}

public WebElement getPotNameLookUpIcon() {
	return potNameLookUpIcon;
}

public List<WebElement> getPotNames() {
	return potNames;
}

public WebElement getContactLookUpIcon() {
	return contactLookUpIcon;
}

public List<WebElement> getContactNames() {
	return contactNames;
}

public WebElement getAcctLookupIcon() {
	return acctLookupIcon;
}

public List<WebElement> getAccountNames() {
	return accountNames;
}

public WebElement getProductIcon() {
	return productIcon;
}

public List<WebElement> getProductNames() {
	return productNames;
}

public WebElement getProdCodeTbx() {
	return prodCodeTbx;
}

public WebElement getQtyInStockTbx() {
	return qtyInStockTbx;
}

public WebElement getQtyTbx() {
	return qtyTbx;
}

public WebElement getUnitPriceTbx() {
	return unitPriceTbx;
}

public WebElement getListPriceIcon() {
	return listPriceIcon;
}

public WebElement getListPriceTbx() {
	return listPriceTbx;
}

public WebElement getPriceBookName() {
	return priceBookName;
}

public WebElement getTcTxtArea() {
	return tcTxtArea;
}

public WebElement getDesc() {
	return desc;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

}
