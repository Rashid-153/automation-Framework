package listeners;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.BaseClass;

public class CustomListener extends BaseClass implements ITestListener {
	
	int i=0;
	String filePath="D:\\testScreenShort\\failed\\";
	String successfilePath="D:\\testScreenShort\\success\\"; 
	public void onTestSuccess(ITestResult result) {

		//ITestListener.super.onTestSuccess(result);
		//String methodName=result.getName();    
		//takeScreenShotOnSuccess(methodName, driver);
		System.out.println("Test Case Passed: "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		String methodName=result.getName();    
    	takeScreenShot(methodName, driver);
    	
		
    	System.setProperty("org.uncommons.reportng.escape-output", "false");
		System.out.println("Test Case Failed: "+result.getName());
		Reporter.log("<a href="+filePath+methodName+".png target=\"_blank\">"+methodName+"</a>");
		Reporter.log("<br>");
		Reporter.log("<a href="+filePath+methodName+".png target=\"_blank\"><img height=200 width=200 src="+filePath+methodName+".png></a>");
		
	
		//ITestListener.super.onTestFailure(result);
	}
	
	

	private void takeScreenShot(String methodName, WebDriver driver) {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
		 
            try {
            	
               	FileUtils.copyFile(scrFile, new File(filePath+methodName+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
            	
            	} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	/*
	 * private void takeScreenShotOnSuccess(String methodName, WebDriver driver) {
	 * File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * //The below method will save the screen shot in d drive with test method name
	 * try { i++; FileUtils.copyFile(scrFile, new
	 * File(successfilePath+i+"-"+methodName+".png"));
	 * System.out.println("***Placed screen shot in "+successfilePath+" ***");
	 * 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Skipped: "+result.getName());
		//ITestListener.super.onTestSkipped(result);
	}

}
