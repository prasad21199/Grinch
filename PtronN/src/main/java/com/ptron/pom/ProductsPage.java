package com.ptron.pom;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	@FindBy(xpath="//a[text()='Products']")
	private WebElement products;
	@FindBy(xpath="//input[@value='New Product']")
	private WebElement newProduct;
	@FindBy(name="property(Product Code)")
	private WebElement productCode;
	@FindBy(name="property(Product Name)")
	private WebElement productName;
	@FindBy(xpath="//img[@title='Vendor Name Lookup']")
	private WebElement vendorLookup;
	@FindBy(xpath="//a[@href='javascript:;']")
	private List<WebElement> vendorName;
	@FindBy(name="property(Product Category)")
	private WebElement productCategory;
	@FindBy(name="property(Manufacturer)")
	private WebElement manufacturer;
	@FindBy(xpath="//img[@title='Calendar'])[1]")
	private WebElement saleStart;
	@FindBy(xpath="//input[@name='property(Sales Start Date)']")
	private WebElement date;
	@FindBy(xpath="//input[@name='property(Support Start Date)']")
	private WebElement supportStart;
	@FindBy(xpath="//input[@name='property(Support Expiry Date)']")
	private WebElement supportEnd;
	@FindBy(xpath="//input[@name='property(Unit Price)']")
	private WebElement calculator;
	@FindBy(xpath="//input[@type='button']")
	private WebElement calcu;
	@FindBy(name="calc1")
	private WebElement one;
	@FindBy (name="calc0")
	private WebElement zero;
	@FindBy (name="equal")
	private WebElement equal;
	@FindBy (xpath="//input[@name='property(Commission Rate)']")
	private WebElement commission;
	@FindBy (name="property(Usage Unit)")
	private WebElement usageUnit;
	@FindBy(name="property(Qty/Unit)")
	private WebElement qty;
	@FindBy(name="property(Qty in Stock)")
	private WebElement qtyInStock;
	@FindBy(name="property(Qty in Demand)")
	private WebElement qtyInDemand;
	@FindBy(name="property(Description)")
	private WebElement desc;
	@FindBy(xpath="//input[@value='Save']")
	private WebElement submit;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//	public WebElement getProducts() {
//		return products;
//	}

	public WebElement getNewProduct() {
		return newProduct;
	}

	public WebElement getProductCode() {
		return productCode;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getVendorLookup() {
		return vendorLookup;
	}

//	public WebElement getSamsung() {
//		return vendorName;
//	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getManufacturer() {
		return manufacturer;
	}

	public WebElement getSaleStart() {
		return saleStart;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getSupportStart() {
		return supportStart;
	}

	public WebElement getSupportEnd() {
		return supportEnd;
	}

	public WebElement getCalculator() {
		return calculator;
	}

	public WebElement getOne() {
		return one;
	}

	public WebElement getZero() {
		return zero;
	}

	public WebElement getEqual() {
		return equal;
	}

	public WebElement getCommission() {
		return commission;
	}

	public WebElement getUsageUnit() {
		return usageUnit;
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getQtyInStock() {
		return qtyInStock;
	}

	public WebElement getQtyInDemand() {
		return qtyInDemand;
	}

	public WebElement getDesc() {
		return desc;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getProducts() {
		return products;
	}

	public List<WebElement> getVendorName() {
		return vendorName;
	}


	public WebElement getCalcu() {
		return calcu;
	}
	

}
