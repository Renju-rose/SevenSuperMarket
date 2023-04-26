package com.obsqura.testscripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;

public class ManageUserTest extends Base{
	
	ManageUserPage manageUserPage ;
	Login login;
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyPasswordShowDetailsFunctionality() throws IOException 
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"Menu"));
		manageUserPage=new ManageUserPage(driver);
		manageUserPage.clickOnPasswordShowDetailsButton();
		assertTrue(manageUserPage.PasswordShowDetailsIsDisplayed(),"Password Details are not displaying in Manage User Page");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyStatusChangeActiveAndInActive() throws IOException
	{
		 login=new Login(driver);
		 login.logintoDashboard();
		 SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		 SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"Menu"));
		 manageUserPage=new ManageUserPage(driver);
		 manageUserPage.clickOnStatus();
		 assertTrue(manageUserPage.AlertMessageFieldDisplayed(),"Status is not changing properly in Manage User Page");
    }
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyColorofSearchButton() throws IOException
	{
		String expectedColorOfSearchButton=ExcelUtility.getString(1, 1, GeneralUtilities.excelpath,"ManageUser");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"Menu"));
		manageUserPage=new ManageUserPage(driver);
		assertEquals(expectedColorOfSearchButton,manageUserPage.colorOfSearchButton(),"Colors are not same");
	 }
	
}



