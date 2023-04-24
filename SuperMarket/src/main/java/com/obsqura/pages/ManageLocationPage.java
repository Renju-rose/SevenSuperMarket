package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageLocationPage {
	WebDriver driver;

	public ManageLocationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Manage Location']//parent::a")
	WebElement manageLocationElement;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButtonElement;
	
	@FindBy(xpath="//input[@id='location']")
	WebElement LocationElement;
	
	@FindBy(xpath="//input[@id='delivery']")
	WebElement DeliveryChargeElement;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement SaveButtonElement;
	
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement DeleteButtonElement;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButtonElement;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement EditButtonElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement 	UpdateButtonElement;
	
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement AlertMessageFieldElement;
	
	public ManageLocationPage clickOnManageLocation()
    {
    	PageUtility.clickOnElement(manageLocationElement);
    	return this;
    }
	public ManageLocationPage clickOnNewButton()
    {
    	PageUtility.clickOnElement(NewButtonElement);
    	return this;
    }
	public ManageLocationPage enterValueInLocationField(String locationName)
    {
    	PageUtility.enterText(LocationElement, locationName);
    	return this;
    }
	public ManageLocationPage clickOnEditButton()
    {
    	PageUtility.clickOnElement(EditButtonElement);
    	return this;
    }
	public ManageLocationPage clickOnUpdateButton()
    {
    	PageUtility.clickOnElement(UpdateButtonElement);
    	return this;
    }
	public ManageLocationPage clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
    	return this;
    }
	
	public ManageLocationPage enterValueInDeliveryChargeField(String deliveryCharge)
    {
    	PageUtility.enterText(DeliveryChargeElement, deliveryCharge);
    	return this;
    }
	public ManageLocationPage clickOnSaveButton()
    {
    	PageUtility.clickOnElement(SaveButtonElement);
    	return this;
    }
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageFieldElement.isDisplayed();
	}
	public boolean  greaterLocationComparisonOfNewBUttonAndSearchButton()
	{
		return PageUtility.greaterComparisonX(SearchButtonElement, NewButtonElement);
	}
	public String colorOfSearchButton()
	{
		return PageUtility.getCssValueOfElement(SearchButtonElement,"color");
	}

	

}
