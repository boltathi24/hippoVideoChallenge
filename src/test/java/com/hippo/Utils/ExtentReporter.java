package com.hippo.Utils;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	

		public final static String FILEPATH = System.getProperty("user.dir") + "/custom-extent-reports/TestReport_" + new Utility().date("ddMMyyhhmm") + ".html";
		public static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();


		
		public static ExtentHtmlReporter htmlReporter;
		public  static ExtentReports extent;
		 public static ExtentTest logger;
		 
		/**
		 * @return create Extent Test obj
		 */

		
		 public static void startReport(){
			 
			 htmlReporter = new ExtentHtmlReporter(FILEPATH);
			 extent = new ExtentReports ();
			 extent.attachReporter(htmlReporter);
			 extent.setSystemInfo("Host Name", "HippoVideo");			 
			 htmlReporter.config().setDocumentTitle("HippoVideo Automation");
			 htmlReporter.config().setReportName("HippoVideo Automation Report");
			  htmlReporter.config().setTheme(Theme.DARK);
			 }
		/**
		 * @return current extent Test Obj
		 */
		public static synchronized ExtentTest getTest() {
			return extentTestMap.get((int) (long) (Thread.currentThread().getId()));
		}

		/**
		 * @Desc Ends the Current Extent Test Obj
		 */

		/**
		 * @Desc Starts Extent Test
		 * @param testName
		 * @return extentTest
		 */
		public static synchronized ExtentTest startTest(String testName) {
			return startTest(testName, "");
		}

		/**
		 * @Desc Returns Test With Description in Extent Report
		 * @param testName
		 * @param desc
		 * @return
		 */
		public static synchronized ExtentTest startTest(String testName, String desc) {
			logger= extent.createTest(testName);
			extentTestMap.put((int) (long) (Thread.currentThread().getId()), logger);
			return logger;
		}
}
