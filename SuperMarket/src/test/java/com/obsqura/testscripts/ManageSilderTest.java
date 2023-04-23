package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.ManageSliderPage;
import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;

public class ManageSilderTest extends Base{
	ManageSliderPage manageSliderPage;
	Login login;

	@Test
	public void verifyAddingSliderFunctionality() throws IOException 
	{
		String link=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageSlider");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(5, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnNewButton();
		manageSliderPage.enterTextInLinkField(link);
		manageSliderPage.clickOnSaveButton();
	    assertTrue(manageSliderPage.AlertMessageFieldDisplayed(),"Failed to add Slider in Manage Slider");
	}
	@Test
	public void verifyEditButtonFunctionalityInManageSlider() throws IOException
	{
		String link=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageSlider");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(5, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnEditButton();
		manageSliderPage.enterTextInLinkField(link);
		manageSliderPage.clickOnUpdateButton();
	    assertTrue(manageSliderPage.AlertMessageFieldDisplayed(),"Failed to update Slider in Manage Slider");
	}
	@Test
	 public void verifyDeleteButtonFunctionalityUsingAlert() throws IOException
	 {
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(5, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageSliderPage.AlertMessageFieldDisplayed(),"Slider is not getting deleted");
	    }


}
