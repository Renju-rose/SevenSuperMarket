package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageUserPage {
	WebDriver driver;

	public ManageUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Manage Users']//parent::a")
	WebElement ManageUserElement;
	
	@FindBy(xpath="//span[text()='Active']")
	WebElement ActiveButtonElement;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement AlertMessageElement;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButtonElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SendButtonElement;
	
	public void clickOnManageUser()
    {
    	PageUtility.clickOnElement(ManageUserElement);
    }
	public String getUrlOfManageUser()
    {
    	return driver.getCurrentUrl();
    }
	public String colorOfSearchButton()
	{
		return PageUtility.getCssValueOfElement(SearchButtonElement,"color");
	}

}