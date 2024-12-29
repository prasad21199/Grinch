package com.ptron.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;


public class ListnerImplementation extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		ITestNGMethod methodName = result.getMethod();
		Reporter.log(methodName +" has been started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestNGMethod methodName = result.getMethod();
		Reporter.log(methodName +" has been success ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+methodName+timeStamp+".png");
		try {
				FileUtils.copyFile(src, dest);
			} 
			catch (IOException e) 
			{
			}
	}
//	@Override
//	public void onTestFailure(ITestResult result) {
//		String methodName = result.getName();
//		String timestamp = LocalDateTime.now().toString().replace(':', '-');
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./errorShot/"+methodName+timestamp+".png");
//		try {
//			FileUtils.copyDirectory(src, dest);
//		} catch (IOException e) {
//		}
//		
//	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
