package com.ptron.hardcode;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePurchaseOrder {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://192.168.114.128:8080/crm/HomePage.do");
		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456"+Keys.ENTER);
		for(int i=0;i<30;i++) {
			driver.findElement(By.id("scrollright")).click();
		}
		driver.findElement(By.linkText("Purchase Orders")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@onclick='createAction()']")).click();Thread.sleep(2000);
		driver.findElement(By.name("property(Subject)")).sendKeys("I ugent need 10 pieces");Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Vendor Name Lookup']")).click();Thread.sleep(2000);
		String parent = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for(String s:allwin) {
			driver.switchTo().window(s);
		}
		List<WebElement> allEle = driver.findElements(By.xpath("//a[@href='javascript:;']"));
		for(WebElement ele:allEle) {
			ele.click();Thread.sleep(2000);
			break;
		}
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@name='property(Billing Street)']")).sendKeys("Banaso");Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='property(Billing City)']")).sendKeys("Hazaribagh");Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='property(Billing State)']")).sendKeys("Jharkhand");Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='property(Billing Code)']")).sendKeys("825312");Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='property(Billing Country)']")).sendKeys("india");Thread.sleep(2000);
		driver.findElement(By.id("copyAddress")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//td[text()='Billing to Shipping']")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@title='Product Name Lookup']")).click();Thread.sleep(2000);
		String parent1 = driver.getWindowHandle();
		Set<String> allwin1 = driver.getWindowHandles();
		for(String s1:allwin1) {
			driver.switchTo().window(s1);
		}
		List<WebElement> allEle1 = driver.findElements(By.xpath("//a[@href='javascript:;']"));
		for(WebElement ele1:allEle1) {
			ele1.click();Thread.sleep(2000);
			break;
		}
		driver.switchTo().window(parent1);
		driver.findElement(By.name("property(txtListPrice1)")).sendKeys("120");Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Save']")).click();Thread.sleep(2000);
		driver.quit();

	}

}

