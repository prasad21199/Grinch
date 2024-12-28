package com.ptron.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricebookPage {
	@FindBy(id="scrollright")
	private WebElement scroll;
	@FindBy(xpath="//input[@value='New Price Book']")
	private WebElement createPricebook;
	@FindBy(xpath="//input[@name='property(Price Book Name)']")
	private WebElement pricebookName;
	@FindBy(xpath="(//input[@type='submit'])[3]")
	private WebElement submit;

	public PricebookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getScroll() {
		return scroll;
	}

	public WebElement getCreatePricebook() {
		return createPricebook;
	}


	public WebElement getPricebookName() {
		return pricebookName;
	}

	public WebElement getSubmit() {
		return submit;
	}
	}
