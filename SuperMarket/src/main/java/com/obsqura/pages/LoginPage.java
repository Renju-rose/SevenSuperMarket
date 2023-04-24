package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class LoginPage 
{
	WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement UserNameFieldElement;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement PasswordFieldElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SigninButtonElement;
	
	
	public LoginPage enterTextInUserNameField(String username)
    {
    	PageUtility.enterText(UserNameFieldElement, username);
    	return this;
    }
	public LoginPage enterPasswordInPasswordField(String password)
    {
    	PageUtility.enterText(PasswordFieldElement, password);
    	return this;
    }
	public LoginPage clickSignInButton()
    {
    	PageUtility.clickOnElement(SigninButtonElement);
    	return this;
    }
	public String getTitleofLogin()
	{
		return driver.getTitle();
	}
	

}
