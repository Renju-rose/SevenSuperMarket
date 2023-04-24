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
import Utilities.WaitUtility;

public class DeliveryBoyTest extends Base{
	DeliveryBoyPage deliveryBoyPage;
	Login login;
	 @Test (retryAnalyzer = Retry.class)
	   public void verifyStatusChangeActiveAndInActive() throws IOException
	   {
		   login=new Login(driver);
		   login.logintoDashboard();
		   deliveryBoyPage=new DeliveryBoyPage(driver);
		   deliveryBoyPage.clickDeliveryBoyMoreInfo().clickOnStatus();
		   assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"Status is not changing properly");
	   }
	 @Test (retryAnalyzer = Retry.class)
		public void verifyPasswordShowDetailsFunctionality() throws IOException 
		{
			login=new Login(driver);
			login.logintoDashboard();
			SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
			SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
			deliveryBoyPage=new DeliveryBoyPage(driver);
			deliveryBoyPage.clickOnPasswordShowDetailsButton();
			assertTrue(deliveryBoyPage.PasswordShowDetailsIsDisplayed(),"Password Details are not displaying");
		}
	 @Test (retryAnalyzer = Retry.class)
	    public void verifyDeleteButtonFunctionalityUsingAlert() throws IOException
	    {
	    	login=new Login(driver);
			login.logintoDashboard();
			deliveryBoyPage=new DeliveryBoyPage(driver);
			deliveryBoyPage.clickDeliveryBoyMoreInfo().clickOnDeleteButton();
			driver.switchTo().alert().accept();
			assertTrue(deliveryBoyPage.AlertFieldDisplayed(),"Alert Message is not displayed");
	    }
		
    @Test (retryAnalyzer = Retry.class)
	public void verifyFontWeightofSearchButton() throws IOException
	{
		String expectedColorOfSearchButton=ExcelUtility.getNumeric(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		assertEquals(expectedColorOfSearchButton,deliveryBoyPage.fontWeightOfSearchButton(),"Colors are not same");
	 }
    @Test (retryAnalyzer = Retry.class)
    public void verifyResetButtonFunctionality() throws IOException
    {
    	login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo().clickOnResetButton();
		assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"Alert Message is not displayed");
    }
    
}
