package com.hippo.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hippo.BaseClass.BaseClass;

public class Utility extends BaseClass
{

	
	public void navigate(String url)
	{
		driver.get(url);
	}
	
	public String date(String format) {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();

		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}
	
	 public void waitForElement(By by) throws InterruptedException 
	 {
     int timeToWait = 15;
	WebDriverWait wait = new WebDriverWait(driver, timeToWait);
	wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	 public WebElement element(By by) throws InterruptedException
	 {
		 waitForElement(by);
		 return driver.findElement(by);
	 }
	 

	 public void assignTestCategory(String category) {
			try {
				ExtentReporter.getTest().assignCategory(category);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	
	 
	 public void tryElementToBeGone(By by) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			} catch (Exception e) {
				e.getMessage();
			}

		}
	 
	 public static int randomNumber(int min, int max) {
			Random RND = new Random();
			int index = RND.nextInt((max - min) + 1) + min;
			return index;
		}
	 
		public static String randomString(String baseString, int charLimit) {
			Random Rnd = new Random();
			StringBuilder builder = new StringBuilder();
			char ch;
			builder.append(baseString + "");
			for (int i = 0; i < charLimit; i++) {
				ch = (char) ((int) Math.floor(26 * Rnd.nextDouble() + 65));
				builder.append(ch);
			}

			String RS = builder.toString();
			return RS;
		}

}
