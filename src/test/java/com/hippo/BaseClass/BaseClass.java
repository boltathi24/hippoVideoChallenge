package com.hippo.BaseClass;

import java.io.File;
import java.lang.reflect.Method;
//import com.sun.javafx.PlatformUtil;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.hippo.Utils.ExtentReporter;
import com.hippo.pages.GetStartedPage;
import com.hippo.pages.HomePage;
import com.hippo.pages.MarketingPage;

public class BaseClass {

	public  WebDriver driver=null;
	public MarketingPage marketingPage=null;
	public HomePage homePage=null;
	public GetStartedPage getStartedPage=null;
	
	@BeforeSuite
	public void setDriver()
	{
		System.setProperty("webdriver.chrome.driver", new File("chromedriver_linux").getAbsolutePath() );
		ExtentReporter.startReport();
		
	}

	
	@BeforeMethod
	public void initiMethods(Method method) throws InterruptedException {
		
		ExtentReporter.startTest(method.getDeclaringClass().getSimpleName() + "-" + method.getName());
	}
	
	
	 @AfterMethod
	 public void getResult(ITestResult result){
		 
		 if(result.getStatus() == ITestResult.SUCCESS)
		 {
			 ExtentReporter.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.ORANGE)); 
		 }
		 else if(result.getStatus() == ITestResult.FAILURE){
			 
		 ExtentReporter.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
		
	 }else if(result.getStatus() == ITestResult.SKIP){
	 
		 ExtentReporter.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.BROWN)); 
	 }
	 }
	
	public WebDriver getDriver()
	{
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);	
		driver.manage().window().maximize();
		return driver;
	}

	 
	 @AfterSuite
	 public void clearAll()
	 {
		ExtentReporter.extent.flush();
		 driver.quit();
	 }
	
}
