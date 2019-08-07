package com.hippo.testModules;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hippo.Utils.Utility;
import com.hippo.pages.GetStartedPage;
import com.hippo.pages.HomePage;
import com.hippo.pages.MarketingPage;

public class validateCreateProspect extends Utility{

	@BeforeClass
	public void loadApp() {
		
		driver=getDriver();
		navigate("https://www.hippovideo.io");
		marketingPage=new MarketingPage(driver);
		homePage=new HomePage(driver);
		getStartedPage=new GetStartedPage(driver);
			}
	
	@BeforeMethod
	public void assignTestCategory()
	{
		assignTestCategory("prospectCreation");
	}

    @Test
    public void validateNewProspectCreation() throws InterruptedException 
    {      
     marketingPage.doNewsignUp();
     homePage.createProspect();
     
     
     
     Assert.assertEquals(driver.getCurrentUrl(),"https://www.hippovideo.io/video/getting-started","***Failure: URL redirectiton is incorrect After new sign up");
     Assert.assertTrue(getStartedPage.isWhatsnewBannerDisplayed(),"***Failure: whatsNew Banner is not displayed");
     getStartedPage.closeWhatsNewBanner();
     HashMap<String,String> createdUserData=getStartedPage.getProfileData();
     Assert.assertEquals(createdUserData.get("profileName"),homePage.getFirstName(),"***Failure: The first name provided while Creating prospect is not shown after successful signup");
     Assert.assertEquals(createdUserData.get("mailId"),marketingPage.getCompanyMail(),"***Failure: The Company Mail provided while Creating new User is not shown after successful signup");
     Assert.assertTrue(getStartedPage.isPageLoaded(),"***Failure: Page not loaded Properly After successfull sign Up");
     
    }

    @AfterClass
	public void windUp() {
		
		driver.close();
	}


 


    

}
