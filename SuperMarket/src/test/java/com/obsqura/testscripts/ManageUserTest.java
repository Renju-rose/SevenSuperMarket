package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;

public class ManageUserTest extends Base{
	
	ManageUserPage manageUserPage ;
	Login login;
	@Test
	public void verifyManageUserNavigation() throws IOException 
	{
		String expectedUrl=ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageUser");
		login=new Login(driver);
		login.verifyingUsingValidCredentials();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageUserPage=new ManageUserPage(driver);
		manageUserPage.clickOnManageUser();
		assertEquals(expectedUrl,manageUserPage.getUrlOfManageUser(),"Url's are not same");
	}
	@Test
	public void verifyColorofSearchButton() throws IOException
	{
		String expectedColorOfSearchButton=ExcelUtility.getString(1, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"ManageUser");
		login=new Login(driver);
		login.verifyingUsingValidCredentials();
		manageUserPage=new ManageUserPage(driver);
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"Menu"));
		manageUserPage=new ManageUserPage(driver);
		assertEquals(expectedColorOfSearchButton,manageUserPage.colorOfSearchButton(),"Colors are not same");
	 }
	
}



