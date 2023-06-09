package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class PushNotificationPage {
	WebDriver driver;

	public PushNotificationPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement PushNotificationElement;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement TitleFieldElement;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement DescriptionFieldElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SendButtonElement;
	
	@FindBy(xpath="//div[@class='col-md-12']")
	WebElement AlertMessageFieldElement;
	
	public PushNotificationPage clickPushNotification()
    {
    	PageUtility.clickOnElement(PushNotificationElement);
    	return this;
    }
	public boolean isTitleFieldDisplayed()
    {
    	return PageUtility.isElementDisplayed(TitleFieldElement);
    }
	public boolean isDescriptionFieldDisplayed()
    {
    	return PageUtility.isElementDisplayed(DescriptionFieldElement);
    }
	public PushNotificationPage enterValueInTitleField(String title)
    {
    	PageUtility.enterText(TitleFieldElement,title);
    	return this;
    }
	public PushNotificationPage enterValueInDescriptionField(String description)
    {
    	PageUtility.enterText(DescriptionFieldElement,description);
    	return this;
    } 
	public boolean isSendButtonEnabled()
    {
    	return PageUtility.isElementEnabled(SendButtonElement);
    }
	public PushNotificationPage clickOnSendButton()
    {
    	PageUtility.clickOnElement(SendButtonElement);
    	return this;
    }
	public String getUrlOfPushNotification()
    {
    	return driver.getCurrentUrl();
    }
	public boolean  greaterLocationComparisonOfDescriptionFieldAndTitleField()
	{
		return PageUtility.greaterComparisonY(DescriptionFieldElement, TitleFieldElement);
	}
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageFieldElement.isDisplayed();
	}
	
	
}
