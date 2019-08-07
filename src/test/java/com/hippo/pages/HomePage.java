package com.hippo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hippo.Utils.Utility;

public class HomePage extends Utility {
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	 	public By businessTypeUser=By.xpath("//div[@id='AskPlanTypePanel']//span[text()='business']");
	 	public By salesCustomization=By.xpath("//div[@class='plan-question-set']//span[text()='Sales: Send personalized video emails and track them']");
	 	public By nxtBtn=By.id("Business-next-btn");
	 	public By firstNameTxtBox=By.id("firstNameTxt");
	 	public By companyNameTxtBox=By.id("companyNameTxt");
	 	public By phoneTxtBox=By.id("phoneTxt");
	 	public By getStartedBtn=By.id("saveCompanyName");
	 	
	    public String firstName=null;
	    public String companyMail=null;
	 	
	 	public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getCompanyMail() {
			return companyMail;
		}

		public void setCompanyMail(String companyMail) {
			this.companyMail = companyMail;
		}

		public void createProspect() throws InterruptedException
	 	{
	 		element(businessTypeUser).click();
	 		element(salesCustomization).click();
	 		element(nxtBtn).click();
	 		tryElementToBeGone(nxtBtn);
	 		setFirstName(randomString("newUser", 5));
	 		element(firstNameTxtBox).sendKeys(getFirstName());
	 		setCompanyMail(randomString("newUserCreation", 5)+"@gmail.com");
	 		element(companyNameTxtBox).sendKeys(getCompanyMail());
	 		element(phoneTxtBox).sendKeys(String.valueOf(randomNumber(7, 9)));
	 		element(getStartedBtn).click();
	 		tryElementToBeGone(getStartedBtn);
	 	}

}
