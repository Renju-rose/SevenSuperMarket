package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class DeliveryBoyPage {
	WebDriver driver;

	public DeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'][normalize-space()='More info']")
	WebElement DeliveryBoyMoreInfoElement;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement NewButtonElement;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement NameFieldElement;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement UserNameFieldElement;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement PasswordFieldElement;
	
	@FindBy(xpath="//button[@name='create']")
	WebElement SaveDeliveryBoyElement;
	
	@FindBy(xpath="//i[@class='fa fa-angle-double-down']")
	WebElement PasswordShowDetailsButtonElement;
	
	@FindBy(xpath="//div[@class='profile-info-name']")
	WebElement PasswordShowDetails;
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement EditButtonElement;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMessageFieldElement;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButtonElement;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement ResetButtonElement;
	
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	
	@FindBy(css="i[class='fas fa-bars']")
	WebElement SideBarElement;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user-plus']")
	WebElement ManageDeliveryBoyButtonElement;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a")
	WebElement PasswordAreaElement;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement UpdateButtonElement;
	
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[8]/a[2]/i[1]")
	WebElement DeleteButtonElement;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement PhoneNumberFieldElement;
	
	
	@FindBy(xpath="//div[@class='card']//div[@class='card-header']")
	WebElement AlertForDeliveryBoyElement;
	
	
	public DeliveryBoyPage clickDeliveryBoyMoreInfo()
    {
    	PageUtility.clickOnElement(DeliveryBoyMoreInfoElement);
    	return this;
    }
	public DeliveryBoyPage clickOnEditButton()
    {
    	PageUtility.clickOnElement(EditButtonElement);
    	return this;
    }
	public DeliveryBoyPage clickOnUpdateButton()
    {
    	PageUtility.submitOnElement(UpdateButtonElement);
    	return this;
    }
	public DeliveryBoyPage clickOnNewButton()
    {
    	PageUtility.clickOnElement(NewButtonElement);
    	return this;
    }
	public DeliveryBoyPage clickOnPasswordShowDetailsButton()
    {
    	PageUtility.clickOnElement(PasswordShowDetailsButtonElement);
    	return this;
    }
	public DeliveryBoyPage clickOnSaveDeliveryBoy()
    {
    	PageUtility.submitOnElement(SaveDeliveryBoyElement);
    	return this;
    }
	public boolean PasswordShowDetailsIsDisplayed()
    {
    	return PageUtility.isElementDisplayed(PasswordShowDetails);
    }
	public DeliveryBoyPage clickOnSideBar()
    {
    	PageUtility.clickOnElement(SideBarElement);
    	return this;
    }
	public DeliveryBoyPage clickOnResetButton()
    {
    	PageUtility.clickOnElement(ResetButtonElement);
    	return this;
    }
	public DeliveryBoyPage clickOnManageDeliveryBoyButton()
    {
    	PageUtility.clickOnElement(ManageDeliveryBoyButtonElement);
    	return this;
    }
	
	public DeliveryBoyPage enterTextInNameField(String name)
    {
    	PageUtility.enterText(NameFieldElement, name);
    	return this;
    }
	public DeliveryBoyPage enterNumberInPhoneNumber(String number)
    {
    	PageUtility.enterText(PhoneNumberFieldElement, number);
    	return this;
    }
	
	public DeliveryBoyPage enterTextInUserNameField(String username)
    {
    	PageUtility.enterText(UserNameFieldElement, username);
    	return this;
    }
	
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public DeliveryBoyPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfhref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}
	
	public DeliveryBoyPage enterTextInPasswordField(String password)
    {
    	PageUtility.enterText(PasswordFieldElement, password);
    	return this;
    }
	
	public DeliveryBoyPage clickSaveDeliveryBoyButton()
    {
		//WaitUtility.waitForElementClickable(driver, SaveDeliveryBoyElement);
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", SaveDeliveryBoyElement); 
		PageUtility.clickOnElement(SaveDeliveryBoyElement);
		return this;
    }
	public String fontWeightOfSearchButton()
	{
		return PageUtility.getCssValueOfElement(SearchButtonElement,"font-weight");
	}
	public DeliveryBoyPage clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
    	return this;
    }
	public String getUrlofSavedDeliveryBoy()
	{
		return driver.getCurrentUrl();
	}
	public String getTextOfManageDeliveryBoy()
	{
		return PageUtility.getElementText(DeliveryBoyMoreInfoElement);
	}
	public boolean AlertMessageFieldDisplayed()
	{
		return  PageUtility.isElementDisplayed(AlertMessageFieldElement);
	}
	public boolean AlertFieldDisplayed()
	{
		return  PageUtility.isElementDisplayed(AlertForDeliveryBoyElement);
	}
	

}
