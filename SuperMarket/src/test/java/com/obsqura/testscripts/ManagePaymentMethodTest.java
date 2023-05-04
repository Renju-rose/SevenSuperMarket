package com.obsqura.testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManagePaymentMethodPage;
import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;
import Utilities.GeneralUtilities;

public class ManagePaymentMethodTest extends Base{
	ManagePaymentMethodPage managePaymentMethodPage ;
	Login login;
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyEditFunctionalityOfManagePayment() 
	{
		String paymentType=ExcelUtility.getString(0, 0, GeneralUtilities.excelpath,"ManagePayment");
		String amount=ExcelUtility.getNumeric(1, 0, GeneralUtilities.excelpath,"ManagePayment");
		login=new Login(driver);
		login.logintoDashboard();
		SelectCategoryList SelectCategoryListobj=new SelectCategoryList(driver);
		SelectCategoryListobj.navigateToMenu(ExcelUtility.getString(6, 0, GeneralUtilities.excelpath,"Menu"));
		managePaymentMethodPage=new ManagePaymentMethodPage(driver);
		managePaymentMethodPage.clickOnEditButton().enterValueInAmountField(paymentType).enterValueInAmountField(amount).clickOnUpdateButton();
		assertTrue(managePaymentMethodPage.AlertMessageFieldDisplayed(),"Amount Field is not getting updated");
		
	}
	

}
