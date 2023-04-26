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
import Utilities.GeneralUtilities;

public class LoginTest extends Base
{
	LoginPage loginpage;
	@Test (retryAnalyzer = generaltests.Retry.class)
	@Parameters({"username","password"})
	public void verifyingUsingValidCredentials(String username,String password) throws IOException
	{
		String expectedTitle=ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"loginpage");
		loginpage=new LoginPage(driver);
		loginpage.enterTextInUserNameField(username).enterPasswordInPasswordField(password).clickSignInButton();
		assertEquals(expectedTitle,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}
	@Test(dataProvider="LoginProvider")
	public void verifyLoginPage(String username,String password) throws IOException
	{
		String expectedUrl=ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"loginpage");
		loginpage=new LoginPage(driver);
		loginpage.enterTextInUserNameField(username).enterPasswordInPasswordField(password).clickSignInButton();
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
    @Test (retryAnalyzer = generaltests.Retry.class)
    public void verifyingUsingValidUserNameAndInvalidPassword() throws IOException
	{
    	String username=ExcelUtility.getString(4, 0, GeneralUtilities.excelpath,"loginpage");
		String password=ExcelUtility.getString(5, 0, GeneralUtilities.excelpath,"loginpage");
		String expectedTitle=ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"loginpage");
		loginpage=new LoginPage(driver);
		loginpage.enterTextInUserNameField(username).enterPasswordInPasswordField(password).clickSignInButton();
		assertNotEquals(expectedTitle,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyingUsingInvalidCredentials() throws IOException
	{
		String username=ExcelUtility.getString(4, 0, GeneralUtilities.excelpath,"loginpage");
		String password=ExcelUtility.getString(5, 0, GeneralUtilities.excelpath,"loginpage");
		String expectedTitle=ExcelUtility.getString(1, 0, GeneralUtilities.excelpath,"loginpage");
		loginpage=new LoginPage(driver);
		loginpage.enterTextInUserNameField(username).enterPasswordInPasswordField(password).clickSignInButton();
		assertNotEquals(expectedTitle,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}
	
}
