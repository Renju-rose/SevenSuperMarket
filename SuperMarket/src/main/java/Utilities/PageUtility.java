package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility
{
	   public static void clickOnElement(WebElement element) 
	   {
		   element.click();
	   }
	   public static void submitOnElement(WebElement element) 
	   {
		   element.submit();
	   }
	   public boolean isDisplay(WebElement element) 
	   {
			boolean status = element.isDisplayed();
			return status;
	   }
	   public boolean isEnable(WebElement element) 
	   {
			boolean status = element.isEnabled();
			return status;
	    }
	   public boolean isSelect(WebElement element)
	   {
			boolean status = element.isSelected();
			return status;
		}
    	public static WebElement enterText(WebElement element, String value)
    	{
		element.sendKeys(value);
		return element;
		}
		
		public static void sendKey(WebElement element, String s)
		{
			element.sendKeys(s);
		}

		public static String getElementText(WebElement element)
		{
		return element.getText();
		}
		public static List<WebElement> findRowElements(WebElement element)
		{
		return element.findElements(By.tagName("tr"));
		}
		
		public static void clickAndHoldOnElement(WebElement element, WebDriver driver)
     	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
		}

		public static void selectDropdownbyText(WebElement element, String text) 
		{
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}
		public static void getLocationofX1(WebElement element) 
		{
			Point location=element.getLocation();
			int elementLocationX1=location.getX();
		}
		public static void getLocationofX2(WebElement element) 
		{
			Point location=element.getLocation();
			int elementLocationX2=location.getX();
		}
		public static Boolean greaterComparisonX(WebElement element1,WebElement element2)
		{
			Point location1=element1.getLocation();
			Point location2=element2.getLocation();
		    boolean greaterLocation;
			return greaterLocation=location1.getX()>location2.getX();
		}
		public static void getLocationofY1(WebElement element) 
		{
			Point location=element.getLocation();
			int elementLocationY1=location.getY();
		}
		public static void getLocationofY2(WebElement element) 
		{
			Point location=element.getLocation();
			int elementLocationY2=location.getY();
		}
		public static Boolean greaterComparisonY(WebElement element1,WebElement element2)
		{
			Point location1=element1.getLocation();
			Point location2=element2.getLocation();
		    boolean greaterLocation;
			return greaterLocation=location1.getY()>location2.getY();
		}

		public static void selectDropdownbyIndex(WebElement element, int index)
		{
		Select select = new Select(element);
		select.selectByIndex(index);
		}
		public static  void scrollDownOperation(WebDriver driver) 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,729)");
		}
		public static String getAttributeElementOfhref(WebElement element)
		{
			return element.getAttribute("href");
		}
		public static  void scrollIntoView(WebDriver driver) 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object myelement = null;
			js.executeScript("arguments[0].scrollIntoView()", myelement); 
	     }
        public static WebElement enterIntValue(WebElement element, CharSequence[] value)
		{
		element.sendKeys(value);
		return element;
		}

		public static Boolean isElementDisplayed(WebElement element)
		{
		return element.isDisplayed();
		}
		public static Boolean isElementEnabled(WebElement element)
		{
		return element.isEnabled();
		}
		public static Boolean isElementSelected(WebElement element)
		{
			return element.isSelected();
			}
		
		public static void ScrollBy(WebDriver driver)
		{
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,2500)");
		}

		public static void stopPageRefresh(WebDriver driver)
		{
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.stop();");

		}
		public static void clickJavaScript(WebDriver driver,WebElement element)
		{
			JavascriptExecutor Js1 = (JavascriptExecutor)driver;
			Js1.executeScript("arguments[0].click();",element);
		}
		public static void sendKeysJavaScript(WebDriver driver,WebElement element,String input) 
		{
			JavascriptExecutor Js1 = (JavascriptExecutor)driver;
			Js1.executeScript("arguments[0].value='input';", element);
		}
		public String getToolTip(WebElement element) 
		{
			return element.getAttribute("title");
		}

		public void getClickElement(WebElement element)
		{
			element.click();
		}
        public static String getCssValueOfElement(WebElement element,String propertyName)
        {
        	return element.getCssValue(propertyName);
        }
		public void mediumDelay(int x) throws InterruptedException {
			Thread.sleep(x);
		}
		public static void clickAction(WebDriver driver,WebElement element)
		{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
        }
		public static void mouseHoverAction(WebDriver driver,WebElement element)
		{
			Actions action=new Actions(driver);
			action.moveToElement(element).build().perform();
		}
		public static void doubleClick(WebDriver driver,WebElement element)
		{
			Actions action=new Actions(driver);
			action.doubleClick(element).perform();
		}
		public static void rightClickActionAction(WebDriver driver,WebElement element)
		{
			Actions action=new Actions(driver);
			action.contextClick(element).perform();
		}
		public static void clickAndHoldAction(WebDriver driver,WebElement element)
		{
			Actions action=new Actions(driver);
			action.clickAndHold(element).perform();
		}
		public static void dragAndDropAction(WebDriver driver,WebElement source,WebElement target) 
		{
			Actions action=new Actions(driver);
			action.clickAndHold(source).moveToElement(target).release(target).build().perform();
		}

		public void selectFuncbyindex(WebElement element, int index) 
		{
			Select select = new Select(element);
			select.selectByIndex(index);

		}

		public void selectFuncbyValue(WebElement element, String value) 
		{
			Select select1 = new Select(element);
			select1.selectByValue(value);

		}

		public static String selectFuncbyVisibletext(WebElement element, String visibletext) 
		{
			Select select = new Select(element);
			select.selectByVisibleText(visibletext);
			WebElement selectedValue = select.getFirstSelectedOption();
			return (selectedValue.getText());

		}

		public static String FirstSelectedOption(WebElement element)
		{
			Select select1 = new Select(element);
			String firstoption = select1.getFirstSelectedOption().getText();
			return (firstoption);
		}

		public List<WebElement> getAllOptions(Select s)
		{

			List<WebElement> op = s.getOptions();

			return op;

		}
		
		
		public List<String> convertToStringList(List<WebElement> weList)
		{
			List<String> strList = new ArrayList<String>();
			for (int i = 0; i < weList.size(); i++) {

				strList.add(weList.get(i).getText());
			}

			return strList;

		}

		public String stylePropertyValidation(WebElement element, String propertyType)
		{
			return element.getCssValue(propertyType);
		}

		public boolean isSelected(WebElement element) 
		{
			return element.isSelected();
		}

		public static List<String> addList(List<String>list,String s) 
		{

			list.add(s);
			return list;
		}
		public void alertHandlingaccept(WebDriver driver) 
		{
		driver.switchTo().alert().accept();
		}

		public String alerttext(WebDriver driver)
		{
		return (driver.switchTo().alert().getText());
		}	
		
		public boolean getElementTextList(List<WebElement> chkList, String element) 
		{

		boolean value = true;
		for (int i = 0; i < chkList.size(); i++)
		{

		String text = chkList.get(i).getText();

		if (!text.equals(element))

		{
		value = false;

		}
		}

		return value;
		}
		
		public boolean compareLists(List<String> actuallist, List<String> expectedlist) 
		{
		boolean value = true;
		for (int i = 0; i < actuallist.size(); i++) {
		if (!actuallist.get(i).equals(expectedlist.get(i))) {
		value = false;
		}
		}

		return value;
		}
		public void managSliderList(List<WebElement> actuallist, List<WebElement> element)
		{
		for (int i = 0; i < actuallist.size(); i++) {
		String text = actuallist.get(i).getText();
		
		if (!text.equals(element)) {
		break;
		}
		}
		}

		

		

}
