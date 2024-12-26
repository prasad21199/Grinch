package com.ptron.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CheckJenk {
	@Test
	public void jenk()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com");
		System.out.println(driver.getTitle());
		driver.quit();
		Reporter.log("success",true);
		
	}
}
