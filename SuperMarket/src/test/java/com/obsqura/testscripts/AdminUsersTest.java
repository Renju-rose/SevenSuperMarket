package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.pages.AdminUsersPage;
import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.GeneralUtilities;

public class AdminUsersTest extends Base{
	AdminUsersPage adminUsersPage;
	Login login;
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifySaveFunctionalityOfAdminUsers() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(7, 0, GeneralUtilities.excelpath,"Menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton().enterValueInUserNameField(FakerUtility.firstNameFakerSample()).enterValueInPasswordField(FakerUtility.lastNameFakerSample()).clickOnUserTypeButton().clickOnSaveButton();
	    assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"New User is not get added");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyEditFunctionalityOfAdminUsers() throws IOException
	{
		String username=ExcelUtility.getString(2, 1, GeneralUtilities.excelpath,"AdminUsers");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(7, 0, GeneralUtilities.excelpath,"Menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnEditButton().enterValueInUserNameField(FakerUtility.firstNameFakerSample()).clickOnUpdateButton();
	    assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"UserName field is not get updated");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyDeleteButtonFunctionalityInAdminUsers() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(3, 0, GeneralUtilities.excelpath,"Menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"Users are not getting deleted");
	}

}
