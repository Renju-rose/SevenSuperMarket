package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageProductPage {
	WebDriver driver;

	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement DeleteButtonElement;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement EditButtonElement;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButtonElement;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement TitleFieldElement;
	
	@FindBy(xpath="//button[@name='Search']")
	WebElement FilterSearchButtonElement;
	
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	
	@FindBy(xpath="//button[@class='btn btn-xs btn-success']")
	WebElement ProductCodeButtonElement;
	
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement AlertMessageFieldElement;
	
	
	public ManageProductPage clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
    	return this;
    }
	public ManageProductPage clickOnSearchButton()
    {
    	PageUtility.clickOnElement(SearchButtonElement);
    	return this;
    }
	public ManageProductPage enterValueInTitleField(String title)
    {
    	PageUtility.enterText(TitleFieldElement, title);
    	return this;
    }
	public ManageProductPage clickOnFilterSearchButton()
    {
    	PageUtility.clickOnElement(FilterSearchButtonElement);
    	return this;
    }
	public boolean checkTitleIsPresent(String Title)
	{
		List<WebElement> rows=PageUtility.findRowElements(TitleFieldElement);
		for(WebElement row:rows)
		{
	     	if(row.getText().contains(Title))
	     		return  true;
		}
		return  false;
	}
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public ManageProductPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfhref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageFieldElement.isDisplayed();
	}
	public boolean  greaterLocationComparisonOfEditButtonAndDeleteButton()
	{
		return PageUtility.greaterComparisonX(DeleteButtonElement, EditButtonElement);
	}
	public boolean  productCodeButtonIsDisplayed()
	{
		return PageUtility.isElementDisplayed(ProductCodeButtonElement);
	}

}
