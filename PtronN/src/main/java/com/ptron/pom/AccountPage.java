package com.ptron.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class AccountPage {
@FindBy(xpath = "//td[contains(text(),'Account Detail')]")
private WebElement accountDetailsPage;
public AccountPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getAccountDetailsPage() {
	return accountDetailsPage;
}

}
