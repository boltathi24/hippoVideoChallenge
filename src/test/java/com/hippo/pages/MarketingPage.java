package com.hippo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hippo.Utils.Utility;

public class MarketingPage extends Utility {
	
	
	public MarketingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	 	
	  public By userMailTxtBox=By.xpath("//section[@class='panel home']//input[ @placeholder='Enter email']");
	  public By passwordTxtBox=By.xpath("//section[@class='panel home']//input[ @placeholder='Password']");
	  public By signUpBtn=By.xpath("//section[@class='panel home']//button[ @class='btn btn-primary hv-primary-btn f-btn signup-btn']");
	  public By pageLoader=By.xpath("//div[contains(@class,' page-loading')]");
	  
	  public String companyMail=null;
	  
	  public String getCompanyMail() {
		return companyMail;
	}

	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}

	public void doNewsignUp() throws InterruptedException
	  {
		 setCompanyMail(randomString("newUserBase", 5).toLowerCase()+"@gmail.com");
		  element(userMailTxtBox).sendKeys(getCompanyMail());
		  element(passwordTxtBox).sendKeys("TestDummy@123");
		  element(signUpBtn).click();
		  tryElementToBeGone(signUpBtn);
		  tryElementToBeGone(pageLoader);
		  
	  }

}
