package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.pages.HomePage;
import com.obsqura.testscripts.LoginTest;
import Utilities.ExcelUtility;

public class HomeTest extends Base{
	Login login;
	HomePage homePage;
	@Test
	public void verifyManageProduct() throws IOException
	{
		String expectedUrl=ExcelUtility.getString(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"HomePage");
		String expectedStatus=ExcelUtility.getString(1, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"HomePage");
		login=new Login(driver);
		homePage=new HomePage(driver);
		login.verifyingUsingValidCredentials();
	    homePage.clickManageProduct();
	    assertEquals(expectedUrl,homePage.getUrlofManageProduct(),"Urls are not same");
	 }
	@Test (groups = { "smoke", "regression" })
	@Parameters({"title","page"})
	public void verifyManagePages(String title,String page) throws IOException
	{
		String username=ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String password=ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		login=new Login(driver);
		homePage=new HomePage(driver);
		login.verifyingUsingValidCredentials();
		assertTrue(homePage.TitleFieldDisplayed(),"Title field is not Displayed");
		homePage.enterTextInTitleField(title);
		assertTrue(homePage.PageFieldDisplayed(),"Page field is not Displayed");
		homePage.enterTextInPageField(page);
		assertTrue(homePage.SaveButtonEnabled(),"SignIn Buutton is not Enabled");
		homePage.clickSaveButton();
	}
	@Test (groups = { "smoke" })
	@Parameters({"name"})
	public void verifyDeliveryBoy(String name) throws IOException
	{
		String username=ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String password=ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		login=new Login(driver);
		homePage=new HomePage(driver);
		login.verifyingUsingValidCredentials();
		assertTrue(homePage.NameFieldDisplayed(),"Name field is not Displayed");
		homePage.enterTextInNameField(name);
		assertTrue(homePage.UserNameFieldDisplayed(),"User Name field is not Displayed");
		homePage.enterTextInUserNameField(username);
		assertTrue(homePage.PasswordFieldDisplayed(),"Password field is not Displayed");
		homePage.enterTextInPasswordField(password);
		assertTrue(homePage.SaveDeliveryBoyButtonEnabled(),"SignIn Buutton is not Enabled");
		homePage.clickSaveDeliveryBoyButton();
	}
	@Test (groups = { "regression" })
	public void verifyFontWeightofSearchButton() throws IOException
	{
		String expectedFontWeight=ExcelUtility.getString(0, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		login=new Login(driver);
		homePage=new HomePage(driver);
		login.verifyingUsingValidCredentials();
		assertEquals(expectedFontWeight,homePage.fontWeightSearchButton(),"Invalid Username & Password");
		
		
	}
	
	
	
	
}
