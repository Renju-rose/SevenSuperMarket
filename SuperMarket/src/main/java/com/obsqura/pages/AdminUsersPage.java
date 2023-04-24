package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;

	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButtonElement;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement UserNameFieldElement;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement PasswordFieldElement;

	@FindBy(xpath="//select[@name='user_type']")
	WebElement UserTypeFieldElement;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement SaveButtonElement;

	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMessageElement;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement EditButtonElement;
	
	@FindBy(xpath="//button[@name='Update']")
	WebElement UpdateButtonElement;
	
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement DeleteButtonElement;
	
	
	public AdminUsersPage clickOnNewButton()
    {
    	PageUtility.clickOnElement(NewButtonElement);
    	return this;
    }
	public AdminUsersPage enterValueInUserNameField(String userName)
    {
    	PageUtility.enterText(UserNameFieldElement, userName);
    	return this;
    }
	public AdminUsersPage enterValueInPasswordField(String password)
    {
    	PageUtility.enterText(PasswordFieldElement, password);
    	return this;
    }
	public AdminUsersPage clickOnUserTypeButton()
    {
    	PageUtility.clickOnElement(UserTypeFieldElement);
    	PageUtility.selectDropdownbyIndex(UserTypeFieldElement, 2);
    	return this;
    }
	public AdminUsersPage clickOnSaveButton()
    {
    	PageUtility.clickOnElement(SaveButtonElement);
    	return this;
    }
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageElement.isDisplayed();
	}
	public AdminUsersPage clickOnEditButton()
    {
    	PageUtility.clickOnElement(EditButtonElement);
    	return this;
    }
	public AdminUsersPage clickOnUpdateButton()
    {
    	PageUtility.clickOnElement(UpdateButtonElement);
    	return this;
    }
	public AdminUsersPage clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
    	return this;
    }
	
}
