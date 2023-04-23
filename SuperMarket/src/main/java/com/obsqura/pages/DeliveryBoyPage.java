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
	
	@FindBy(xpath="//div[@class='row-sm-12']")
	WebElement AlertMessageFieldElement;
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement SearchButtonElement;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement ResetButtonElement;
	
	@FindBy(css="i[class='fas fa-bars']")
	WebElement SideBarElement;
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user-plus']")
	WebElement ManageDeliveryBoyButtonElement;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a")
	WebElement PasswordAreaElement;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/section[1]/div[2]/div[1]/div[2]/div[2]/table[1]/tbody[1]/tr[1]/td[8]/a[2]/i[1]")
	WebElement DeleteButtonElement;
	
	@FindBy(xpath="//div[@class='card']//div[@class='card-header']")
	WebElement AlertForDeliveryBoyElement;
	
	
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
	public void clickOnResetButton()
    {
    	PageUtility.clickOnElement(ResetButtonElement);
    }
	public void clickOnManageDeliveryBoyButton()
    {
    	PageUtility.clickOnElement(ManageDeliveryBoyButtonElement);
    }
	
	public void enterTextInNameField(String name)
    {
    	PageUtility.enterText(NameFieldElement, name);
    }
	
	public void enterTextInUserNameField(String username)
    {
    	PageUtility.enterText(UserNameFieldElement, username);
    }
	
	public void enterTextInPasswordField(String password)
    {
    	PageUtility.enterText(PasswordFieldElement, password);
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
	public void clickOnDeleteButton()
    {
    	PageUtility.clickOnElement(DeleteButtonElement);
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
