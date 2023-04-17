package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class SelectCategoryList
{
	WebDriver driver;

	public SelectCategoryList(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[contains(@class,'nav-item')]//a")
	List<WebElement> menu;
	
	public void navigateToMenu(String inputFormList)
	{
		for(WebElement categoryList:menu)
		{
			if(PageUtility.getElementText(categoryList).equals(inputFormList))
			{
				PageUtility.clickOnElement(categoryList);
				break;
			}
		}
	}
	

}
