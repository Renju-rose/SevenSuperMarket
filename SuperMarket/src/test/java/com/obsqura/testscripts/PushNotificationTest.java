package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;

public class PushNotificationTest extends Base
{
	PushNotificationPage pushNotificationPage;
	Login login;
	@Test (groups = { "smoke", "regression" })
	public void verifyPushNotificationNavigation() 
	{
		String expectedUrl=ExcelUtility.getString(2, 1, GeneralUtilities.excelpath,"PushNotification");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnSendButton();
		assertEquals(expectedUrl,pushNotificationPage.getUrlOfPushNotification(),"Url's are not same");
	}
	@Test (groups = { "smoke" })
	public void verifyEnterValueInPushNotification() 
	{
		String title=ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"PushNotification");
		String description=ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"PushNotification");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickPushNotification().enterValueInTitleField(title).enterValueInDescriptionField(description).clickOnSendButton();
		assertTrue(pushNotificationPage.AlertMessageFieldDisplayed(),"Push Notification Message is not send successfully");
	}
	@Test  (groups = { "regression" })
	public void verifyIfDescriptionisAlignedBelowTitle() 
	{
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"Menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		assertTrue(pushNotificationPage.greaterLocationComparisonOfDescriptionFieldAndTitleField(),"Description Field is not aligned above Title Field");
	}

}
