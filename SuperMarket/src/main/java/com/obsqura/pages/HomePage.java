package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Product']")
	WebElement ManageProductElement;
	
	@FindBy(xpath="//span[@class='badge bg-warning'][normalize-space()='Inactive'])[1]")
	WebElement InactiveStatusElement;
	
	@FindBy(xpath="//tbody/tr[1]/td[7]/a[1]/span[1]")
	WebElement ActiveStatusElement;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement TitleFieldElement;
	
	@FindBy(xpath="//input[@id='page']")
	WebElement PageFieldElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveButtonElement;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement NameFieldElement;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement UserNameFieldElement;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement PasswordFieldElement;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveDeliveryBoyElement;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButtonElement;
	
	public void clickManageProduct()
    {
    	PageUtility.clickOnElement(ManageProductElement);
    }
	public void clickOnStatusButton()
    {
    	PageUtility.clickOnElement(InactiveStatusElement);
    }
	public String getTextOfInactiveStatusButton()
	{
		return PageUtility.getElementText(InactiveStatusElement);
	}
	public String getTextOfActiveStatusButton()
	{
		return PageUtility.getElementText(ActiveStatusElement);
	}
	public String getUrlofManageProduct()
	{
		return driver.getCurrentUrl();
	}
	public boolean TitleFieldDisplayed()
	{
		return  PageUtility.isElementDisplayed(TitleFieldElement);
	}
	public void enterTextInTitleField(String title)
    {
    	PageUtility.enterText(TitleFieldElement, title);
    }
	public boolean PageFieldDisplayed()
	{
		return  PageUtility.isElementDisplayed(PageFieldElement);
	}
	public void enterTextInPageField(String page)
    {
    	PageUtility.enterText(PageFieldElement, page);
    }
	public boolean SaveButtonEnabled()
	{
		return  PageUtility.isElementEnabled(SaveButtonElement);
	}
	public void clickSaveButton()
    {
    	PageUtility.clickOnElement(SaveButtonElement);
    }

	public boolean NameFieldDisplayed()
	{
		return  PageUtility.isElementDisplayed(NameFieldElement);
	}
	public void enterTextInNameField(String name)
    {
    	PageUtility.enterText(NameFieldElement, name);
    }
	public boolean UserNameFieldDisplayed()
	{
		return  PageUtility.isElementDisplayed(UserNameFieldElement);
	}
	public void enterTextInUserNameField(String username)
    {
    	PageUtility.enterText(UserNameFieldElement, username);
    }
	public boolean PasswordFieldDisplayed()
	{
		return  PageUtility.isElementDisplayed(PasswordFieldElement);
	}
	public void enterTextInPasswordField(String password)
    {
    	PageUtility.enterText(PasswordFieldElement, password);
    }
	public boolean SaveDeliveryBoyButtonEnabled()
	{
		return  PageUtility.isElementEnabled(SaveDeliveryBoyElement);
	}
	public void clickSaveDeliveryBoyButton()
    {
    	PageUtility.clickOnElement(SaveDeliveryBoyElement);
    }
	public String fontWeightSearchButton()
	{
		return PageUtility.getCssValueOfElement(SearchButtonElement,"font-weight");
	}
}
