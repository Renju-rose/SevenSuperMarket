package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;

public class ManageProductTest extends Base{
	ManageProductPage manageProductPage ;
	Login login;
	@Test
	public void verifySearchFunctionalityOfManageProduct() throws IOException
	{
		String title=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageProduct");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageProductPage=new ManageProductPage(driver);
		manageProductPage.clickOnSearchButton();
		manageProductPage.enterValueInTitleField(title);
		manageProductPage.clickOnFilterSearchButton();
		assertTrue(manageProductPage.checkTitleIsPresent(title),"Searched Content is not found");
	}
	@Test
	public void verifyDeleteFuncionalityOfManageProduct() throws IOException 
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageProductPage=new ManageProductPage(driver);
		manageProductPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageProductPage.AlertMessageFieldDisplayed(),"Product List not deleted");
	}
	@Test
	public void verifyIfDeleteButtonisAlignedAfterEditButton() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageProductPage=new ManageProductPage(driver);
		assertTrue(manageProductPage.greaterLocationComparisonOfEditButtonAndDeleteButton(),"Description Field is not aligned above Title Field");
	}
	

}
