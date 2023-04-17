package com.obsqura.pages;

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
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement SaveDeliveryBoyElement;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButtonElement;
	
	@FindBy(css="i[class='fas fa-bars']")
	WebElement SideBarElement;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user-plus']")
	WebElement ManageDeliveryBoyButtonElement;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a")
	WebElement PasswordAreaElementElement;
	
	public void clickDeliveryBoyMoreInfo()
    {
    	PageUtility.clickOnElement(DeliveryBoyMoreInfoElement);
    }
	public void clickOnNewButton()
    {
    	PageUtility.clickOnElement(NewButtonElement);
    }
	public void clickOnSideBar()
    {
    	PageUtility.clickOnElement(SideBarElement);
    }
	public void clickOnManageDeliveryBoyButton()
    {
    	PageUtility.clickOnElement(ManageDeliveryBoyButtonElement);
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
		WaitUtility.waitForElement(driver,SaveDeliveryBoyElement);
		return  PageUtility.isElementEnabled(SaveDeliveryBoyElement);
	}
	public void clickSaveDeliveryBoyButton()
    {
		WaitUtility.waitForElementClickable(driver, SaveDeliveryBoyElement);
    	PageUtility.clickOnElement(SaveDeliveryBoyElement);
    	WaitUtility.waitForElementClickable(driver, SaveDeliveryBoyElement);
    }
	public String fontWeightOfSearchButton()
	{
		return PageUtility.getCssValueOfElement(SearchButtonElement,"font-weight");
	}
	public String getUrlofSavedDeliveryBoy()
	{
		return driver.getCurrentUrl();
	}
	public String getTextOfManageDeliveryBoy()
	{
		return PageUtility.getElementText(DeliveryBoyMoreInfoElement);
	}
	

}
