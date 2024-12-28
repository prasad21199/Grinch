package com.ptron.hardcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VendorModule {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://192.168.114.128:8080/crm/HomePage.do");
		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.xpath("//a[text()='Vendors']")).click();
		driver.findElement(By.xpath("//input[@value='New Vendor']")).click();
		driver.findElement(By.name("property(Phone)")).sendKeys("9470839354");
		driver.findElement(By.name("property(Website)")).sendKeys("www.samsung.com");
		driver.findElement(By.name("property(Category)")).sendKeys("Manufacturer");
		driver.findElement(By.name("property(Vendor Name)")).sendKeys("Samsung");
		driver.findElement(By.name("property(Email)")).sendKeys("gkrishna70@gmail.com");
		
		WebElement gla = driver.findElement(By.name("property(GL Account)"));
		
		Select s= new Select(gla);
		s.selectByIndex(4);
		
		driver.findElement(By.name("property(Street)")).sendKeys("4th cross road");
		driver.findElement(By.name("property(City)")).sendKeys("Bengaluru");
		driver.findElement(By.name("property(State)")).sendKeys("karnataka");
		driver.findElement(By.name("property(Country)")).sendKeys("India");
		driver.findElement(By.name("property(Zip Code)")).sendKeys("560019");
		driver.findElement(By.name("property(Description)")).sendKeys("This vendor deal with all products of samsung");
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
		driver.quit();
	}

}
