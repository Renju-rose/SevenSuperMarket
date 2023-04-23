package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import com.obsqura.pages.DeliveryBoyPage;
import Utilities.ExcelUtility;
import Utilities.WaitUtility;

public class DeliveryBoyTest extends Base{
	DeliveryBoyPage deliveryBoyPage;
	Login login;
	@Test
	public void verifyDeliveryBoyNavigation() throws IOException
	{
		login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"Alert Message is not displayed");
		
	}
	
    @Test
	public void verifyDeliveryBoySaveFunctionality() throws IOException
	{
		String name=ExcelUtility.getString(1, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		String username=ExcelUtility.getString(2, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		String password=ExcelUtility.getString(3, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
     	login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		deliveryBoyPage.clickOnNewButton();
		deliveryBoyPage.enterTextInNameField(name);
		deliveryBoyPage.enterTextInUserNameField(username);
		deliveryBoyPage.enterTextInPasswordField(password);
	    deliveryBoyPage.clickSaveDeliveryBoyButton();
		assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"Alert Message is not displayed");
		
	}
    @Test
	public void verifyFontWeightofSearchButton() throws IOException
	{
		String expectedColorOfSearchButton=ExcelUtility.getNumeric(0, 1, System.getProperty("user.dir") + constants.Constants.EXCELFILE,"DeliveryBoy");
		login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		assertEquals(expectedColorOfSearchButton,deliveryBoyPage.fontWeightOfSearchButton(),"Colors are not same");
	 }
    @Test
    public void verifyResetButtonFunctionality() throws IOException
    {
    	login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		deliveryBoyPage.clickOnResetButton();
		assertTrue(deliveryBoyPage.AlertMessageFieldDisplayed(),"Alert Message is not displayed");
    }
    @Test
    public void verifyDeleteButtonFunctionalityUsingAlert() throws IOException
    {
    	login=new Login(driver);
		login.logintoDashboard();
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickDeliveryBoyMoreInfo();
		deliveryBoyPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(deliveryBoyPage.AlertFieldDisplayed(),"Alert Message is not displayed");
    }
	
	
	
}
