package com.obsqura.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

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
	
	@FindBy(xpath="//input[@id='main_img']")
	WebElement ChooseFileElement;
	
	@FindBy(xpath="//button[@name='update']")
	WebElement UpdateButtonElement;
	
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement AlertMessageFieldElement;
	
	
	public ManageSliderPage clickOnNewButton()
    {
		WaitUtility.waitForElementClickable(driver, NewButtonElement);
    	PageUtility.clickOnElement(NewButtonElement);
    	return this;
    }
	public ManageSliderPage enterTextInLinkField(String link)
    {
    	PageUtility.enterText(LinkFieldElement, link);
    	return this;
    }
	public ManageSliderPage clickOnSaveButton()
    {
		WaitUtility.waitForElementClickable(driver, SaveButtonElement);
    	PageUtility.clickOnElement(SaveButtonElement);
    	return this;
    }
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageFieldElement.isDisplayed();
	}
	public ManageSliderPage clickOnEditButton()
    {
		WaitUtility.waitForElementClickable(driver, EditButtonElement);
    	PageUtility.clickOnElement(EditButtonElement);
    	return this;
    }
	public ManageSliderPage uploadImage() throws IOException
	{
		ChooseFileElement.sendKeys("C:\\Users\\renju\\OneDrive\\Desktop\\Birthday Mundiyamkal\\DSC_6131.JPG");	
		return this;
	}
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public ManageSliderPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfhref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}
	public ManageSliderPage clickOnUpdateButton()
    {
		WaitUtility.waitForElementClickable(driver, UpdateButtonElement);
    	PageUtility.clickOnElement(UpdateButtonElement);
    	return this;
    }
	public ManageSliderPage clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
    	return this;
    }
}
