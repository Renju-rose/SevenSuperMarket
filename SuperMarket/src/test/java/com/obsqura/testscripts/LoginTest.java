package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.obsqura.pages.LoginPage;
import Utilities.ExcelUtility;

public class LoginTest extends Base
{
	LoginPage loginpage;
	@Test
	@Parameters({"username","password"})
	public void verifyingUsingValidCredentials(String username,String password) throws IOException
	{
		String expectedTitle=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		loginpage=new LoginPage(driver);
		assertTrue(loginpage.UserNameFieldDisplayed(),"UserName field is not Displayed");
		loginpage.enterTextInUserNameField(username);
		assertTrue(loginpage.PasswordFieldDisplayed(),"Password field is not Displayed");
		loginpage.enterPasswordInPasswordField(password);
		assertTrue(loginpage.SignInButtonEnabled(),"SignIn Button is not Enabled");
		loginpage.clickSignInButton();
		assertEquals(expectedTitle,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}
	@Test(dataProvider="LoginProvider")
	public void verifyLoginPage(String username,String password) throws IOException
	{
		String expectedUrl=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		loginpage=new LoginPage(driver);
		assertTrue(loginpage.UserNameFieldDisplayed(),"UserName field is not Displayed");
		loginpage.enterTextInUserNameField(username);
		assertTrue(loginpage.PasswordFieldDisplayed(),"Password field is not Displayed");
		loginpage.enterPasswordInPasswordField(password);
		assertTrue(loginpage.SignInButtonEnabled(),"SignIn Button is not Enabled");
		loginpage.clickSignInButton();
		assertNotEquals(expectedUrl,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromDataprovider()
	{
	    return new Object[][] 
	    	{
	    	    {"Renju","admin"},
	            {"Allen","allen123"},
	            {"admin","12345"},
	           
	        };

	    }
    @Test
    public void verifyingUsingValidUserNameAndInvalidPassword() throws IOException
	{
    	String username=ExcelUtility.getString(4, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String password=ExcelUtility.getString(5, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String expectedTitle=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		loginpage=new LoginPage(driver);
		assertTrue(loginpage.UserNameFieldDisplayed(),"UserName field is not Displayed");
		loginpage.enterTextInUserNameField(username);
		assertTrue(loginpage.PasswordFieldDisplayed(),"Password field is not Displayed");
		loginpage.enterPasswordInPasswordField(password);
		assertTrue(loginpage.SignInButtonEnabled(),"SignIn Button is not Enabled");
		loginpage.clickSignInButton();
		assertNotEquals(expectedTitle,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}
	@Test
	public void verifyingUsingInvalidCredentials() throws IOException
	{
		String username=ExcelUtility.getString(4, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String password=ExcelUtility.getString(5, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String expectedTitle=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		loginpage=new LoginPage(driver);
		assertTrue(loginpage.UserNameFieldDisplayed(),"UserName field is not Displayed");
		loginpage.enterTextInUserNameField(username);
		assertTrue(loginpage.PasswordFieldDisplayed(),"Password field is not Displayed");
		loginpage.enterPasswordInPasswordField(password);
		assertTrue(loginpage.SignInButtonEnabled(),"SignIn Button is not Enabled");
		loginpage.clickSignInButton();
		assertNotEquals(expectedTitle,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}
	
}
