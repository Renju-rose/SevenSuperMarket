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
import Utilities.GeneralUtilities;

public class ManageLocationTest extends Base{
	ManageLocationPage manageLocationPage;
	Login login;
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyLocationAddingFunctionality() 
	{
		String locationName=ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"ManageLocation");
		String deliveryCharge=ExcelUtility.getNumeric(1, 0, GeneralUtilities.excelpath,"ManageLocation");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, GeneralUtilities.excelpath,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnManageLocation().clickOnNewButton().enterValueInLocationField(locationName).enterValueInDeliveryChargeField(deliveryCharge).clickOnSaveButton();
		assertTrue(manageLocationPage.AlertMessageFieldDisplayed(),"Failed to add Location Details");
	}
	
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyEditButtonFunctionalityInManageLocationField() 
	{
		String locationName=ExcelUtility.getString(2, 0, GeneralUtilities.excelpath,"ManageLocation");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, GeneralUtilities.excelpath,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnEditButton().enterValueInLocationField(locationName).clickOnUpdateButton();
		assertTrue(manageLocationPage.AlertMessageFieldDisplayed(),"Failed to update Location Details");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyDeleteButtonFunctionalityInManageLocationField() 
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, GeneralUtilities.excelpath,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageLocationPage.AlertMessageFieldDisplayed(),"Location Details is not getting deleted");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyColorofSearchButton() 
	{
		String expectedColorOfSearchButton=ExcelUtility.getString(3, 1, GeneralUtilities.excelpath,"ManageLocation");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, GeneralUtilities.excelpath,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		assertEquals(expectedColorOfSearchButton,manageLocationPage.colorOfSearchButton(),"Color of Search Button is not as expected");
	 }
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyIfSearchButtonisAlignedAfterNewButton() 
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, GeneralUtilities.excelpath,"Menu"));
		manageLocationPage=new ManageLocationPage(driver);
		assertTrue(manageLocationPage.greaterLocationComparisonOfNewBUttonAndSearchButton(),"Description Field is aligned above Title Field");
	}

}
