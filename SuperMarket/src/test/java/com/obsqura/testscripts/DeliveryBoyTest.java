package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import Utilities.GeneralUtilities;
import Utilities.WaitUtility;

public class DeliveryBoyTest extends Base{
	DeliveryBoyPage deliveryBoyPage;
	Login login;
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyDeliveryBoySaveFunctionality() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo().clickOnNewButton().enterTextInNameField(FakerUtility.firstNameFakerSample()).enterTextInUserNameField(FakerUtility.emailFakerSample()).enterTextInPasswordField(FakerUtility.lastNameFakerSample());
		deliveryBoyPage.clickOnSaveDeliveryBoy();
		assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"New Delivery Boy Details is not get added");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyEditFunctionalityOfDeliveryBoy() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo().clickOnEditButton().enterTextInNameField(FakerUtility.firstNameFakerSample()).enterNumberInPhoneNumber(FakerUtility.cellPhoneFakerSample()).enterTextInUserNameField(FakerUtility.emailFakerSample()).enterTextInPasswordField(FakerUtility.lastNameFakerSample());
		deliveryBoyPage.clickOnUpdateButton();
		assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"Delivery Boy Details are not getting updated");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyStatusChangeActiveAndInActive() throws IOException
	{
		 login=new Login(driver);
		 login.logintoDashboard();
		 deliveryBoyPage=new DeliveryBoyPage(driver);
		 deliveryBoyPage.clickDeliveryBoyMoreInfo().clickOnStatus();
		 assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"Status is not changing properly");
	 }
	 @Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyPasswordShowDetailsFunctionality() throws IOException 
	{
		  login=new Login(driver);
		  login.logintoDashboard();
		  SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		  SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"Menu"));
		  deliveryBoyPage=new DeliveryBoyPage(driver);
		  deliveryBoyPage.clickOnPasswordShowDetailsButton();
		  assertTrue(deliveryBoyPage.PasswordShowDetailsIsDisplayed(),"Password Details are not displaying");
	  }
	 @Test (retryAnalyzer = generaltests.Retry.class)
	 public void verifyDeleteButtonFunctionalityUsingAlert() throws IOException
	 {
	    	login=new Login(driver);
			login.logintoDashboard();
			deliveryBoyPage=new DeliveryBoyPage(driver);
			deliveryBoyPage.clickDeliveryBoyMoreInfo().clickOnDeleteButton();
			driver.switchTo().alert().accept();
			assertTrue(deliveryBoyPage.AlertFieldDisplayed(),"Alert Message is not displayed");
	  }
    @Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyFontWeightofSearchButton() throws IOException
	{
		String expectedColorOfSearchButton=ExcelUtility.getNumeric(0, 1, GeneralUtilities.excelpath,"DeliveryBoy");
		login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		assertEquals(expectedColorOfSearchButton,deliveryBoyPage.fontWeightOfSearchButton(),"Colors are not same");
	 }
   
}
