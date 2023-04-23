package com.obsqura.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageOrderPage {
	WebDriver driver;

	public ManageOrderPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement manageOrderMoreInfoElement;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButtonElement;

	@FindBy(id="pt")
	WebElement paymentDropdownElement;

	@FindBy(xpath="//button[@name='Search']")
	WebElement searchButtonTwoElement;

	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]")
	List<WebElement> listPaymentElement;

	@FindBy(id="st")
	WebElement statusDropdownElement;
	
	public String getSelectedPayment() 
	{
		PageUtility.clickOnElement(manageOrderMoreInfoElement);
		PageUtility.clickOnElement(searchButtonElement);
		PageUtility.selectFuncbyVisibletext(paymentDropdownElement, "Bank");
		String selected = PageUtility.FirstSelectedOption(paymentDropdownElement);
		PageUtility.clickOnElement(searchButtonTwoElement);
		return selected;
	}
	
	public String getListPayment()
	{
		PageUtility.clickOnElement(manageOrderMoreInfoElement);
		PageUtility.clickOnElement(searchButtonElement);
		PageUtility.selectFuncbyVisibletext(paymentDropdownElement, "Bank");
		String listPayment= PageUtility.FirstSelectedOption(paymentDropdownElement);
		PageUtility.clickOnElement(searchButtonTwoElement);
		return listPayment;

	}
	

	

}
