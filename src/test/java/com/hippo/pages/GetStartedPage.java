package com.hippo.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hippo.Utils.Utility;



public class GetStartedPage extends Utility {
	
	
		public  GetStartedPage(WebDriver driver)
		{
			this.driver=driver;
		}
	 	
	 	public By profileIcon=By.xpath("//b[contains(@class,'topbar-profile-pic')]");
	    public By profileName=By.xpath("//div[@id='drop2']//label[@class='prof-name']");
	    public By mailId=By.xpath("//div[@id='drop2']//label[@class='prof-mail']");
	    public By hippoLog=By.xpath("//a[@class='hippo-logo']//img");
	    public By topBar=By.id("hippoTopBar");
	    public By getStartedSpace=By.id("gettingStartedOuterDiv");
	    public HashMap<String,String> profileData=new HashMap<String,String>();
	    public By closewhatsNewPopUp=By.xpath("//div[@class='userpilot-btn userpilot-no-hover']");
	    public By whatsNewHeder=By.xpath("//div[@class='userpilot-slide-contaienr']//div[@class='userpilot-builder-block']//b[text()='What is Hippo Video?']");
	    
	    public HashMap<String,String> getProfileData() throws InterruptedException
	    {
	    	element(profileIcon).click();
	    	profileData.put("profileName", element(profileName).getText());
	    	profileData.put("mailId", element(mailId).getText());
	    	return profileData;
	    }
	    
	    public boolean isPageLoaded() throws InterruptedException
	    {
	    	return element(topBar).isDisplayed() && element(hippoLog).isDisplayed() && element(getStartedSpace).isDisplayed();
	    }
	    
	    public boolean isWhatsnewBannerDisplayed() throws InterruptedException
	    {
	    	return element(whatsNewHeder).isDisplayed();
	    }
	    
	    public void closeWhatsNewBanner() throws InterruptedException
	    {
	    	element(closewhatsNewPopUp).click();
	    	tryElementToBeGone(closewhatsNewPopUp);
	    }

}
