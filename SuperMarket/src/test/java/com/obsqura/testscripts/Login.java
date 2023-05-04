package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.obsqura.pages.LoginPage;
import Utilities.ExcelUtility;

public class Login extends Base
{
	Login(WebDriver driver)
	{
		this.driver=driver;
	}
	LoginPage loginpage;
	public void logintoDashboard()
	{
		String expectedTitle=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String username=ExcelUtility.getString(2, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		String password=ExcelUtility.getString(3, 0, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"loginpage");
		loginpage=new LoginPage(driver);
		loginpage.enterTextInUserNameField(username);
		loginpage.enterPasswordInPasswordField(password);
		loginpage.clickSignInButton();
		assertEquals(expectedTitle,loginpage.getTitleofLogin(),"Invalid Username & Password");
	}

}
