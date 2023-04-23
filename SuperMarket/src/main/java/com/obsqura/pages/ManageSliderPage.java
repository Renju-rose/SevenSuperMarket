package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageSliderPage {
	WebDriver driver;

	public ManageSliderPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButtonElement;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement EditButtonElement;
	
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement DeleteButtonElement;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement LinkFieldElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveButtonElement;
	
	@FindBy(xpath="//button[@name='update']")
	WebElement UpdateButtonElement;
	
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement AlertMessageFieldElement;
	
	
	public ManageSliderPage clickOnNewButton()
    {
    	PageUtility.clickOnElement(NewButtonElement);
    	return this;
    }
	public void enterTextInLinkField(String link)
    {
    	PageUtility.enterText(LinkFieldElement, link);
    }
	public ManageSliderPage clickOnSaveButton()
    {
    	PageUtility.clickOnElement(SaveButtonElement);
    	return this;
    }
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageFieldElement.isDisplayed();
	}
	public ManageSliderPage clickOnEditButton()
    {
    	PageUtility.clickOnElement(EditButtonElement);
    	return this;
    }
	public ManageSliderPage clickOnUpdateButton()
    {
    	PageUtility.clickOnElement(UpdateButtonElement);
    	return this;
    }
	public ManageSliderPage clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
    	return this;
    }
}
