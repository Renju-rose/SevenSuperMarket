package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.ManageSliderPage;
import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;

public class ManageProductTest extends Base{
	ManageProductPage manageProductPage ;
	Login login;
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifySearchFunctionalityOfManageProduct() 
	{
		String title=ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"ManageProduct");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(2, 0, GeneralUtilities.excelpath,"Menu"));
		manageProductPage=new ManageProductPage(driver);
		manageProductPage.clickOnSearchButton().enterValueInTitleField(title).clickOnFilterSearchButton();
		assertTrue(manageProductPage.productCodeButtonIsDisplayed(),"Searched Content-title:Red Meat is not found");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyDeleteFuncionalityOfManageProduct() 
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(2, 0, GeneralUtilities.excelpath,"Menu"));
		manageProductPage=new ManageProductPage(driver);
		manageProductPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageProductPage.AlertMessageFieldDisplayed(),"Product List not deleted");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyStatusChangeActiveAndInActiveInManageSlider() 
	{
		 login=new Login(driver);
		 login.logintoDashboard();
		 SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		 SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(2, 0, GeneralUtilities.excelpath,"Menu"));
		 manageProductPage=new ManageProductPage(driver);
		 manageProductPage.clickOnStatus();
		 assertTrue(manageProductPage.AlertMessageFieldDisplayed(),"Status is not changing properly");
	 }

	
	

}
