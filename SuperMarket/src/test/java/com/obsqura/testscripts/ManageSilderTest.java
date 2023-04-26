package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.ManageSliderPage;
import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;

public class ManageSilderTest extends Base{
	ManageSliderPage manageSliderPage;
	Login login;

	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyAddingSliderFunctionality() throws IOException 
	{
		String link=ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"ManageSlider");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(5, 0, GeneralUtilities.excelpath,"Menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnNewButton().enterTextInLinkField(link).clickOnSaveButton();
		assertTrue(manageSliderPage.AlertMessageFieldDisplayed(),"Failed to add Slider in Manage Slider");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyEditButtonFunctionalityInManageSlider() throws IOException
	{
		String link=ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"ManageSlider");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(5, 0, GeneralUtilities.excelpath,"Menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnEditButton().enterTextInLinkField(link).clickOnUpdateButton();
		assertTrue(manageSliderPage.AlertMessageFieldDisplayed(),"Failed to update Slider in Manage Slider");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	 public void verifyDeleteButtonFunctionalityUsingAlert() throws IOException
	 {
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(5, 0, GeneralUtilities.excelpath,"Menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageSliderPage.AlertMessageFieldDisplayed(),"Slider is not getting deleted");
	  }
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyStatusChangeActiveAndInActiveInManageSlider() throws IOException
	{
		 login=new Login(driver);
		 login.logintoDashboard();
		 SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		 SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(5, 0, GeneralUtilities.excelpath,"Menu"));
		 manageSliderPage=new ManageSliderPage(driver);
		 manageSliderPage.clickOnStatus();
		 assertTrue(manageSliderPage.AlertMessageFieldDisplayed(),"Status is not changing properly");
	 }


}
