package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.testng.annotations.Test;

import com.obsqura.pages.ManageOrderPage;
import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;

public class ManageOrderTest extends Base{
	ManageOrderPage manageOrderPage;
	Login login;
	@Test
	public void verifyPushNotificationNavigation() throws IOException 
	{
		String expectedUrl=ExcelUtility.getString(2, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"PushNotification");
		login=new Login(driver);
		login.logintoDashboard();
		manageOrderPage=new ManageOrderPage(driver);
		manageOrderPage.getSelectedPayment();
		
	}

}
