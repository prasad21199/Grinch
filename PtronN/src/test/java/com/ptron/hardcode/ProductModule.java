package com.ptron.hardcode;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductModule {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://192.168.114.128:8080/crm/HomePage.do");
		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//input[@value='New Product']")).click();
		driver.findElement(By.name("property(Product Code)")).sendKeys("A231");
		driver.findElement(By.name("property(Product Name)")).sendKeys("Samsung s24 ultra");
		
		driver.findElement(By.xpath("//img[@title='Vendor Name Lookup']")).click();
		String pwid=driver.getWindowHandle();
		 Set<String> allwid = driver.getWindowHandles();
		 for (String wid : allwid) {
			 driver.switchTo().window(wid);
		}
		driver.findElement(By.xpath("//a[text()='Samsung']")).click();
		driver.switchTo().window(pwid);
		
		WebElement pc = driver.findElement(By.name("property(Product Category)"));
		Select s=new Select(pc);
		s.selectByIndex(1);
		
		WebElement manu = driver.findElement(By.name("property(Manufacturer)"));
		Select s1=new Select(manu);
		s1.selectByIndex(1);
		driver.findElement(By.xpath("(//img[@title='Calendar'])[1]")).click();
		Set<String> allwid1 = driver.getWindowHandles();
		for (String wid : allwid1) {
			 driver.switchTo().window(wid);
		}
		driver.findElement(By.xpath("//a[text()='25']")).click();
		driver.switchTo().window(pwid);
		
		driver.findElement(By.xpath("//input[@name='property(Sales End Date)']")).sendKeys("12/27/2024");
		driver.findElement(By.xpath("//input[@name='property(Support Start Date)']")).sendKeys("12/25/2024");
		driver.findElement(By.xpath("//input[@name='property(Support Expiry Date)']")).sendKeys("12/30/2024");
		driver.findElement(By.xpath("(//img[@title='Calculator'])")).click();
		Set<String> allwid2 = driver.getWindowHandles();
		for (String wid : allwid2) {
			 driver.switchTo().window(wid);
		}
		driver.findElement(By.name("calc1")).click();
		for(int i = 1; i <=5; i++) {
			driver.findElement(By.name("calc0")).click();
		}
		driver.findElement(By.name("equal")).click();
		driver.switchTo().window(pwid);
		driver.findElement(By.xpath("//input[@name='property(Commission Rate)']")).sendKeys("20000");
		WebElement uunit = driver.findElement(By.name("property(Usage Unit)"));
		Select s2=new Select(uunit);
		s2.selectByVisibleText("Pack");
		driver.findElement(By.name("property(Qty/Unit)")).sendKeys("150");
		driver.findElement(By.name("property(Qty in Stock)")).sendKeys("10");
		driver.findElement(By.name("property(Qty in Demand)")).sendKeys("100");
		driver.findElement(By.name("property(Description)")).sendKeys("High demand product");
		driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();
	}
}
