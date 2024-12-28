package com.ptron.hardcode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PricebookModule {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://192.168.114.128:8080/crm/HomePage.do");
		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		for(int i=0;i<=6; i++) {
			driver.findElement(By.id("scrollright")).click();
		}
		driver.findElement(By.xpath("//a[text()='Price Books']")).click();
		driver.findElement(By.xpath("//input[@value='New Price Book']")).click();
		driver.findElement(By.name("property(Price Book Name)")).sendKeys("selling price");
		driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();

	}

}
