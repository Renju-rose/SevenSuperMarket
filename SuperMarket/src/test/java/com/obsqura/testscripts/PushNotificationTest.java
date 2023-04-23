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
	@Test (groups = { "smoke", "regression" })
	public void verifyPushNotificationNavigation() throws IOException 
	{
		String expectedUrl=ExcelUtility.getString(2, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnSendButton();
		assertEquals(expectedUrl,pushNotificationPage.getUrlOfPushNotification(),"Url's are not same");
	}
	@Test (groups = { "smoke" })
	public void verifyEnterValueInPushNotification() throws IOException 
	{
		String title=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		String description=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickPushNotification();
		pushNotificationPage.enterValueInTitleField(title);
		pushNotificationPage.enterValueInDescriptionField(description);
	    pushNotificationPage.clickOnSendButton();
		assertTrue(pushNotificationPage.AlertMessageFieldDisplayed(),"Push Notification Message is not send successfully");
	}
	@Test  (groups = { "regression" })
	public void verifyIfDescriptionisAlignedBelowTitle() throws IOException 
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		assertTrue(pushNotificationPage.greaterLocationComparisonOfDescriptionFieldAndTitleField(),"Description Field is not aligned above Title Field");
	}

}
