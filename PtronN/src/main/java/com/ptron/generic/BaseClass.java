package com.ptron.generic;


import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ptron.generic.FileLibrary;
import com.ptron.pom.*;

public class BaseClass {
	public static WebDriver  driver;
	public static  FileLibrary fl = new FileLibrary();
	public  LoginPage lp;
	public  HomePage hp;
	public ContactPage cp;
	public AccountPage ap;
	public PurchaseOrderPage po;
	public VendorsPage vp;
	public ProductsPage pp ;
	public InvoicePage ip;
	public SalesOrderPage so;
	public LeadPage leadpage;
	public CampaignPage camp;
	public PricebookPage pbp;
	public QuotesPage qp;
	@BeforeTest
	public void openBrowser() throws IOException
	{
		String url = fl.getProperty("url");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		cp = new ContactPage(driver);
		ap = new AccountPage(driver);
		po = new PurchaseOrderPage(driver);
		vp = new VendorsPage(driver);
		pp = new ProductsPage(driver);
		ip = new InvoicePage(driver);
		so = new SalesOrderPage(driver);
		camp = new CampaignPage(driver);
		leadpage = new LeadPage(driver);
		pbp = new PricebookPage(driver);
		qp = new QuotesPage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
	}
	@BeforeMethod
	public void login() throws IOException
	{
		String un = fl.getProperty("un");
		String pwd = fl.getProperty("pwd");
		lp.setSignIn(un, pwd);
	}
	@AfterMethod
	public void logout()
	{
		for(int i=0; i<=1000; i++) 
		{
			try {
					hp.getLogoutLink().click();
					break;
				}
			catch (NoSuchElementException e) {
			}
		
		}
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.manage().window().minimize();
		driver.quit();
	}
}
