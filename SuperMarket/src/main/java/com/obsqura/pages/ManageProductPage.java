package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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
	
	
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement AlertMessageFieldElement;
	
	
	public void clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
    }
	public void clickOnSearchButton()
    {
    	PageUtility.clickOnElement(SearchButtonElement);
    }
	public void enterValueInTitleField(String title)
    {
    	PageUtility.enterText(TitleFieldElement, title);
    }
	public void clickOnFilterSearchButton()
    {
    	PageUtility.clickOnElement(FilterSearchButtonElement);
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
	
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageFieldElement.isDisplayed();
	}
	public boolean  greaterLocationComparisonOfEditButtonAndDeleteButton()
	{
		return PageUtility.greaterComparisonX(DeleteButtonElement, EditButtonElement);
	}

}
