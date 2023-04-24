package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManagePaymentMethodPage {
	WebDriver driver;

	public ManagePaymentMethodPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement EditButtonElement;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement PaymentMethodFieldElement;
	
	@FindBy(xpath="//input[@name='limit']")
	WebElement PaymentLimitFieldElement;
	
	@FindBy(xpath="//button[@name='Update']")
	WebElement UpdateButtonElement;
	
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement AlertMessageFieldElement;
	
	public ManagePaymentMethodPage clickOnEditButton()
    {
    	PageUtility.clickOnElement(EditButtonElement);
    	return this;
    }
	public ManagePaymentMethodPage enterValueInPaymentTypeField(String paymentType)
    {
    	PageUtility.enterText(PaymentMethodFieldElement, paymentType);
    	return this;
    }
	public ManagePaymentMethodPage enterValueInAmountField(String amount)
    {
    	PageUtility.enterText(PaymentMethodFieldElement, amount);
    	return this;
    }
	public ManagePaymentMethodPage clickOnUpdateButton()
    {
    	PageUtility.clickOnElement(UpdateButtonElement);
    	return this;
    }
	public boolean AlertMessageFieldDisplayed()
	{
		return  AlertMessageFieldElement.isDisplayed();
	}

}
