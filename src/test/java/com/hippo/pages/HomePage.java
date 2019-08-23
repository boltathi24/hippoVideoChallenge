package com.hippo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hippo.Utils.Utility;

public class HomePage extends Utility {
	
	public By addProspectBtn=By.id("addManually");
	public By videoLibraryLink=By.xpath("//div[@id='menuIcon' and @class='nav-center-menu-icon-img library']");
	public By viewDetailOfVideoTemplates=By.xpath("//h6[text()='Video Templates']//ancestor::td//a[text()='VIEW DETAIL']");
	public By videoList=By.xpath("//div[@class='video-cover hippo-video-cat-list '][1]");
	public By videoLink=By.xpath("//div[@class='video-cover hippo-video-cat-list '][1]//video");
	
	public By videoCampignsLink=By.id("videoCampaignsTab-heading");
	public By sendEmailLink=By.xpath("//div[@id='videoCampaign']//div[@class='subtab video-campaign-subtab']");
	
	
	public By addContactBtn=By.xpath("//p[@id='importOrContacts']//span[@class='add-contacts-btn']");
	
	public By emailIdTxtBox=By.xpath("//div[contains(@class,'columns direct-contacts-email')]//input[@class='contacts-input' and @name='email']");
	public By firstNameToSendTxtBox=By.xpath("//input[@class='contacts-input' and @name='First Name']");
	public By addEmailContactBtn=By.id("addContacts");
	
	public By sendEmailBtn=By.id("sendEmailBtn");
	public By subjectTxtBox=By.id("emailSubject");
	
	
	
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
		
		public String sendSampleVideoToEmail(String email) throws InterruptedException
		{
			element(videoLibraryLink).click();
			move(element(By.xpath("//h6[text()='Video Templates']//ancestor::td")));
			move(element(viewDetailOfVideoTemplates));
			element(viewDetailOfVideoTemplates).click();
			
			waitForElement(videoList);
			move(elementList(videoList).get(0));
			clickOn(elementList(videoLink).get(0));
			
			element(videoCampignsLink).click();
			element(sendEmailLink).click();
			
			element(addContactBtn).click();
			
			element(emailIdTxtBox).sendKeys(email);
			String firstName=randomString("Bolt", 5);
			element(firstNameToSendTxtBox).sendKeys(firstName);
			element(addEmailContactBtn).click();
			
			String subj="hi There ";
			element(subjectTxtBox).sendKeys(subj+"${First Name}");
			element(sendEmailBtn).click();
			
			Assert.assertTrue(element(By.className("success-msg-container")).getText().contains("Video campaign launched successfully for 1 contacts!"));
			return subj+firstName;
			
		}
		
		public void logOutHippo() throws InterruptedException
		{
			clickOn(element(By.xpath("//nav[@id='hippoTopBar']//div[@class='curPointer flt_left profile_icon']")));
			element(By.id("userSignOutTxt")).click();
		}

}
