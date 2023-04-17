package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class PushNotificationTest extends Base
{
	PushNotificationPage pushNotificationPage;
	Login login;
	@Test
	public void verifyPushNotificationNavigation() throws IOException 
	{
		String expectedUrl=ExcelUtility.getString(2, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		login=new Login(driver);
		login.verifyingUsingValidCredentials();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnSendButton();
		assertEquals(expectedUrl,pushNotificationPage.getUrlOfPushNotification(),"Url's are not same");
	}
	@Test
	public void enterValueInPushNotification() throws IOException 
	{
		String expectedUrl=ExcelUtility.getString(3, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		String title=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		String description=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		login=new Login(driver);
		login.verifyingUsingValidCredentials();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickPushNotification();
		assertTrue(pushNotificationPage.isTitleFieldDisplayed(),"Title Field is not displayed");
		pushNotificationPage.enterValueInTitleField(title);
		assertTrue(pushNotificationPage.isDescriptionFieldDisplayed(),"Description Field is not displayed");
		pushNotificationPage.enterValueInDescriptionField(description);
		assertTrue(pushNotificationPage.isSendButtonEnabled(),"Send Button is not Enabled");
		pushNotificationPage.clickOnSendButton();
		assertEquals(expectedUrl,pushNotificationPage.getUrlOfPushNotification(),"Url's are not same");
	}
	

}
