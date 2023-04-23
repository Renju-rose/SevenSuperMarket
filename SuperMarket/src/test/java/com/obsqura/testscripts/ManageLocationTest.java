package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;

public class ManageLocationTest extends Base{
	ManageLocationPage manageLocationPage;
	Login login;
	@Test
	public void verifyLocationAddingFunctionality() throws IOException 
	{
		String locationName=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageLocation");
		String deliveryCharge=ExcelUtility.getNumeric(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageLocation");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnManageLocation();
		manageLocationPage.clickOnNewButton();
		manageLocationPage.enterValueInLocationField(locationName);
		manageLocationPage.enterValueInDeliveryChargeField(deliveryCharge);
		manageLocationPage.clickOnSaveButton();
		assertTrue(manageLocationPage.AlertMessageFieldDisplayed(),"Location is not added successfully");
	}
	@Test
	public void verifyIfSearchButtonisAlignedAfterNewButton() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		assertTrue(manageLocationPage.greaterLocationComparisonOfNewBUttonAndSearchButton(),"Description Field is not aligned above Title Field");
	}
	@Test
	public void verifyEditButtonFunctionalityInManageLocationField() throws IOException
	{
		String locationName=ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageLocation");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnEditButton();
		manageLocationPage.enterValueInLocationField(locationName);
		manageLocationPage.clickOnUpdateButton();
		assertTrue(manageLocationPage.AlertMessageFieldDisplayed(),"Location is not get updated successfully");
	}
	@Test
	public void verifyDeleteButtonFunctionalityInManageLocationField() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageLocationPage.AlertMessageFieldDisplayed(),"Location is not getting deleted");
	}
	@Test
	public void verifyColorofSearchButton() throws IOException
	{
		String expectedColorOfSearchButton=ExcelUtility.getString(3, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageLocation");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		assertEquals(expectedColorOfSearchButton,manageLocationPage.colorOfSearchButton(),"Colors are not same");
	 }

}
