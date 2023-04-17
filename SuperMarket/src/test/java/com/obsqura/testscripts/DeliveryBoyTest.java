package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.HomePage;

import Utilities.ExcelUtility;
import Utilities.WaitUtility;

public class DeliveryBoyTest extends Base{
	DeliveryBoyPage deliveryBoyPage;
	Login login;
	@Test
	public void verifyDeliveryBoyNavigation() throws IOException
	{
		String expectedUrl=ExcelUtility.getString(7, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		login=new Login(driver);
		login.verifyingUsingValidCredentials();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		assertEquals(expectedUrl,deliveryBoyPage.getUrlofSavedDeliveryBoy(),"Urls are not same");
		
	}
	@Test
	public void verifyFontWeightofSearchButton() throws IOException
	{
		String expectedColorOfSearchButton=ExcelUtility.getNumeric(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		login=new Login(driver);
		login.verifyingUsingValidCredentials();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		assertEquals(expectedColorOfSearchButton,deliveryBoyPage.fontWeightOfSearchButton(),"Colors are not same");
	 }

	public void verifyDeliveryBoyNavigationdd() throws IOException
	{
		String expectedUrl=ExcelUtility.getString(4, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		String name=ExcelUtility.getString(1, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		String username=ExcelUtility.getString(2, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		String password=ExcelUtility.getString(3, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
     	login=new Login(driver);
		login.verifyingUsingValidCredentials();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		deliveryBoyPage.clickOnNewButton();
		assertTrue(deliveryBoyPage.NameFieldDisplayed(),"Name field is not Displayed");
		deliveryBoyPage.enterTextInNameField(name);
		assertTrue(deliveryBoyPage.UserNameFieldDisplayed(),"User Name field is not Displayed");
		deliveryBoyPage.enterTextInUserNameField(username);
		assertTrue(deliveryBoyPage.PasswordFieldDisplayed(),"Password field is not Displayed");
		deliveryBoyPage.enterTextInPasswordField(password);
		assertTrue(deliveryBoyPage.SaveDeliveryBoyButtonEnabled(),"SignIn Buutton is not Enabled");
		deliveryBoyPage.clickSaveDeliveryBoyButton();
		assertEquals(expectedUrl,deliveryBoyPage.getUrlofSavedDeliveryBoy(),"Urls are not same");
		
	}
	
	
	
}
