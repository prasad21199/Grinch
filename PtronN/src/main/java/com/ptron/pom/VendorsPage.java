package com.ptron.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VendorsPage {
	@FindBy (xpath="//a[text()='Vendors']")
	private WebElement vendors;
	@FindBy(xpath="//input[@value='New Vendor']")
	private WebElement nVendors;
	@FindBy(name="property(Phone)")
	private WebElement phone;
	@FindBy(name="property(Website)")
	private WebElement website;
	@FindBy(name="property(Category)")
	private WebElement category;
	@FindBy(name="property(Vendor Name)")
	private WebElement vName;
	@FindBy(name="property(Email)")
	private WebElement email;
	@FindBy(name="property(GL Account)")
	private WebElement glAccount;
	@FindBy(name="property(Street)")
	private WebElement street;
	@FindBy(name="property(City)")
	private WebElement city;
	@FindBy(name="property(State)")
	private WebElement state;
	@FindBy(name="property(Country)")
	private WebElement country;
	@FindBy(name="property(Zip Code)")
	private WebElement zipCode;
	@FindBy(name="property(Description)")
	private WebElement description;
	@FindBy(xpath="//input[@value='Save']")
	private WebElement save;

	public VendorsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void createVendor(String ph, String web, String cat, String vn,
			String eml, int gla, String st, String ct, String ste,
			String cry, String zip, String desc) {
//		vendors.click();
//		nVendors.click();
		phone.sendKeys(ph);
		website.sendKeys(web);
		category.sendKeys(cat);
		vName.sendKeys(vn);
		email.sendKeys(eml);
		Select s = new Select(glAccount);
		s.selectByIndex(gla);
		street.sendKeys(st);
		city.sendKeys(ct);
		state.sendKeys(ste);
		country.sendKeys(cry);
		zipCode.sendKeys(zip);
		description.sendKeys(desc);	
	}

	public WebElement getVendors() {
		return vendors;
	}

	public WebElement getnVendors() {
		return nVendors;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getvName() {
		return vName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getGlAccount() {
		return glAccount;
	}

	public WebElement getStreet() {
		return street;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSave() {
		return save;
	}


}
