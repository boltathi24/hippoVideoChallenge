package com.hippo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.hippo.Utils.Utility;

public class gmailPage extends Utility {
	
public By subject=By.xpath("//div[@role='tabpanel']//tbody//tr[1]//span[@data-thread-id]");

public gmailPage(WebDriver driver)
{
	this.driver=driver;
	
}
public String getSubjectOfFirstMail() throws InterruptedException
{
	waitForElement(By.xpath("//div[@role='tabpanel']//tbody//tr[1]"));
	return elementList(subject).get(1).getText();
}

public void openFirstMail() throws InterruptedException
{
	clickOn(element(By.xpath("//div[@role='tabpanel']//tbody//tr[1]")));
	
}

public void isVideoDisplayed(String videoTemplate) throws InterruptedException
{
	Assert.assertTrue(element(By.xpath("//div[@class='adn ads']//div[text()='Click to watch video']")).isDisplayed(),"***FailurE: Video is not displayed");
	Assert.assertTrue(element(By.xpath("//div[@class='adn ads']//div[text()='Click to watch video']//preceding-sibling::div")).getText().contains(videoTemplate),"***Failure: Selected Video Template is not present");
}

public void navigateGmail()
{
	driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
}

public void loginGmail() throws InterruptedException
{
	waitForElement(By.id("identifierId"));
	driver.findElement(By.id("identifierId")).clear();
	driver.findElement(By.id("identifierId")).sendKeys("athi.raja24@gmail.com");
	driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
	waitForElement( By.name("password"));
	driver.findElement(By.name("password")).clear();
	
	String pwd="ZohoTest@24";
	System.out.println(pwd);
	driver.findElement(By.name("password")).sendKeys(pwd);
	waitForElement( By.id("passwordNext"));
	Thread.sleep(2000);
	driver.findElement(By.id("passwordNext")).click();
	tryElementToBeGone(By.id("passwordNext"));
}

public void logOutGmail() throws InterruptedException
{
	clickOn(element(By.xpath("//a[contains(@aria-label,'Google Account')]")));
	clickOn(element(By.xpath("//a[text()='Sign out']")));
	Thread.sleep(2000);
	
}

}
