package selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import common.PrintUtils;
import common.ResultClass;

public class WebDriverGenerics extends ResultClass
{


	public WebDriver openBrowser(WebDriver driver,String browserName, String URL)
	{

		try {
			if(browserName.equalsIgnoreCase("Chrome"))
			{
				//Chrome Browser
				
				System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				driver = new ChromeDriver();
				PrintUtils.logMesaage("Chrome Browser launched successfully");

			}else if(browserName.equalsIgnoreCase("IE"))

			{

				System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

			else if(browserName.equalsIgnoreCase("firefox"))
			{
				System.err.println("download and Set firefox driver path");
				System.setProperty("webdriver.greko.driver", "./driver/IEDriverServer.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(URL);
			PrintUtils.logMesaage("URL Launched");
			
		} catch (Exception e) 
		{
			PrintUtils.logError(e.getMessage());
			PrintUtils.logError("Exception at openBrowser() method");
		}
		
		return driver;
	}


	public void clickByID(WebDriver driver, String locatorValue)
	{
		try{
			driver.findElement(By.id(locatorValue)).click();
			
			PrintUtils.logMesaage("element correctly clicked with given id ::"+locatorValue);
		}catch (Exception e)
		{
			PrintUtils.logError("element not clicked with given id ::"+locatorValue);
		}
	}

	public void clickByName(WebDriver driver, String locatorValue)
	{
		try{
			driver.findElement(By.name(locatorValue)).click();
			
			PrintUtils.logMesaage("elemnt clicked correctly with given name ::"+locatorValue);
			
		}catch (Exception e)
		{
			PrintUtils.logError("element not clicked with given name ::"+locatorValue);
		}
	}


	public void clickByXPath(WebDriver driver, String locatorValue)

	{

		try{
			driver.findElement(By.xpath(locatorValue)).click();
			
			PrintUtils.logMesaage("elemnt clicked with given xpath::"+locatorValue);
			
		}catch (Exception e)
		{
			PrintUtils.logError("element not clicked with given xpath ::"+locatorValue);
		}

	}
	

	public void clickByLinkText(WebDriver driver, String linkText)

	{

		try{
			driver.findElement(By.linkText(linkText)).click();
			
			PrintUtils.logMesaage("elemnt clicked with given linkText::"+linkText);
			
		}catch (Exception e)
		{
			PrintUtils.logError("element not clicked with given linkText ::"+linkText);
		}

	}

// Function for Send Keys
	
	public void enterTxtById(WebDriver driver, String locatorValue, String sendkeyValue)
	{

		try {
			WebElement element = driver.findElement(By.id(locatorValue));
			element.clear();
			element.sendKeys(sendkeyValue);
			
			PrintUtils.logMesaage("Element correctly entered to the ID::"+locatorValue);
			
		} catch (Exception e)
		{
			PrintUtils.logError("Element not Enterted by ID ::" + locatorValue );
		}
	}


	public void enterTxtByname(WebDriver driver, String locatorValue, String sendkeyValue)
	{
		try {
			WebElement element = driver.findElement(By.name(locatorValue));
			element.clear();
			element.sendKeys(sendkeyValue);

			PrintUtils.logMesaage("Element correctly entered by Name ::"+locatorValue);

		} catch (Exception e) {

			PrintUtils.logError("Element not Enterted by Name ::" + locatorValue );
		}
	}

	public void enterTxtByXpath(WebDriver driver, String locatorValue, String sendkeyValue)
	{
		try {
			WebElement element = driver.findElement(By.xpath(locatorValue));
			highLightElement(driver, element);
			element.clear();
			element.sendKeys(sendkeyValue);

			PrintUtils.logMesaage("Element correctly entered by XPath ::"+locatorValue);

		} catch (Exception e) {

			PrintUtils.logError("Element not Enterted by XPath ::" + locatorValue );

		}
	}


	public void navigateBack(WebDriver driver)
	{

		try {
			driver.navigate().back();

			PrintUtils.logMesaage("Backward Navigation successful");

		} catch (Exception e) {

			PrintUtils.logError("Backward Navigation failed" );
		}

	}

	public void navigateForward(WebDriver driver)
	{

		try {
			driver.navigate().forward();
			
			PrintUtils.logMesaage("Forward Navigation successful");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Forward Navigation failed" );
		}

	}

	public void refreshBrowser(WebDriver driver)
	{

		try {
			driver.navigate().refresh();
			
			PrintUtils.logMesaage("Refresh Browser successful");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Refresh Browser failed" );
		}

	}

	public void navigateToURL(WebDriver driver, String URL) 
	{
		driver.navigate().to(URL);
		PrintUtils.logMesaage("URL Navigated Successfully ::"+URL);
	}
	public void quitBrowser(WebDriver driver)
	{

		try {
			driver.quit();
			
			PrintUtils.logMesaage("All open Browser Quit successfully");

		} catch (Exception e) {
			
			PrintUtils.logError("All open Browser Quit failed" );
			
		}

	}

	public void closeBrowser(WebDriver driver)
	{

		try {
			driver.close();
			
			PrintUtils.logMesaage("Active Browser Closed successfully");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Active Browser not closed" );
		}

	}

	public String getTitle(WebDriver driver)
	{
		String Title = driver.getTitle();
		
		try {
			
			PrintUtils.logMesaage("The page Title is ::" + Title);
			
									
		} catch (Exception e) {
			
			PrintUtils.logError("The Page Title not identified" );
		}
		
		return Title;

	}

	public String getCurrentUrl(WebDriver driver)
	{
		String Url = driver.getCurrentUrl();
		try {
			
			PrintUtils.logMesaage("The page URL is ::" + Url);
			
		} catch (Exception e) {
			
			PrintUtils.logError("The Page URL not identified" );
		}
		return Url;
	}

	public void switchToFrameByIndex(WebDriver driver, int index)

	{

		try {
			driver.switchTo().frame(index);
			
			PrintUtils.logMesaage("Switched to Frame successfully by Index");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Unable to switch to Frame successfully by Index" );
		}


	}

	public void switchToFrameByNameOrID(WebDriver driver, String NameorID )

	{

		try {
			
			driver.switchTo().frame(NameorID);
			
			PrintUtils.logMesaage("Switched to Frame successfully by Name");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Unable to switch to Frame successfully by Name" );
		}


	}

	// Need explanation - By WebElement
	
	public void switchToFrameByWebElement(WebDriver driver, WebElement Element )

	{

		try {
			driver.switchTo().frame(Element);
			
			PrintUtils.logMesaage("Switched to Frame successfully by Element");
			
		} catch (Exception e) {
			
			
			PrintUtils.logError("Unable to switch to Frame successfully by Name" );
		}


	}


	public void switchToFrameByDefaultContent(WebDriver driver)

	{

		try {
			driver.switchTo().defaultContent();
			
			PrintUtils.logMesaage("Switched to Default Window successfully");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Unable to switch to Default Window successfully" );
		}


	}



	public void acceptAlert(WebDriver driver)

	{

		try {
			Alert at = driver.switchTo().alert();
			at.accept();
			
			PrintUtils.logMesaage("Alert accepted successfully");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Alert not accepted successfully" );
		}


	}

	public void dismissAlert(WebDriver driver)

	{

		try {
			Alert dismiss = driver.switchTo().alert();
			dismiss.dismiss();
			
			PrintUtils.logMesaage("Alert dismissed successfully");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Alert not dismissed successfully" );
			
		}


	}

	public void sendKeysToAlert(WebDriver driver, String AlertSendKeys)

	{

		try {
			
			Alert sendkey = driver.switchTo().alert();
			sendkey.sendKeys(AlertSendKeys);
			
			PrintUtils.logMesaage("Alert sendkeys successfully");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Alert Send keys not dismissed" );
			
		}


	}

	public String getTextToAlert(WebDriver driver)

	{
		Alert Gettext = driver.switchTo().alert();
		String value = Gettext.getText();
		
		try {
			
			PrintUtils.logMesaage("GetTexttoAlert successfull");
			
		} catch (Exception e) {
			
			PrintUtils.logError("GetTexttoAlert not successfull");
			
		}

		return value;
	}

	// Some web applications have many frames or multiple windows. 
	// Selenium WebDriver assigns an alphanumeric id to each window as soon as the WebDriver object is instantiated. 
	// This unique alphanumeric id is called window handle. 
	// Selenium uses this unique id to switch control among several windows.
	
	public String getParentWindowName(WebDriver driver)

	{
		String ParentSessionID = driver.getWindowHandle();
		
		try {
			
			PrintUtils.logMesaage("Parent Window name is :: " + ParentSessionID);
			
		} catch (Exception e) {
			
			PrintUtils.logError("Parent window name is not captured successfully");
		}

		return (ParentSessionID);
	}
	

	public void switchToLastWindow(WebDriver driver)

	{

		Set<String> AllWindows = driver.getWindowHandles();

		for (String Window : AllWindows) {

			try {
				driver.switchTo().window(Window);
				
				PrintUtils.logMesaage("Switched to Window successfully");
				
				
			} catch (Exception e) {
				
				PrintUtils.logError("Unable to Switch to Window successfully");
			}

		}

	}


	public void switchToParentWindow(WebDriver driver, String ParentID)

	{

		try {
			driver.switchTo().window(ParentID);
			
			PrintUtils.logMesaage("Switched to Parent Window successfully");
			
		} catch (Exception e) {
			
			PrintUtils.logError("Unable to Switch to Parent Window successfully");
		}


	}

	// Dropdown
	
	public void selectionByValue(WebDriver driver, String locatorType, String LocatorValue, String dropdownValue)
	{

		WebElement element =null;

		switch(locatorType)
		{
		case "ID": element=driver.findElement(By.id(LocatorValue));
		break;

		case "Name":  element=driver.findElement(By.name(LocatorValue));
		break;

		case "Class":  element=driver.findElement(By.className(LocatorValue));
		break;

		case "Xpath":  element=driver.findElement(By.xpath(LocatorValue));
		break;

		}


		Select st = new Select(element);

		try {
			st.selectByValue(dropdownValue);
			
			PrintUtils.logMesaage("Successfully selected dropdown by Value");
			
		} catch (Exception e) {
			
			
			PrintUtils.logError("Unable to Select dropdown by Value");
			
		}

	}

	// SelectByIndex (Input a number for dropdownValue
	
	public void selectionByIndex(WebDriver driver, String locatorType, String LocatorValue, int dropdownValue)
	{

		WebElement element =null;

		switch(locatorType)
		{
		case "ID": element=driver.findElement(By.id(LocatorValue));
		break;

		case "Name":  element=driver.findElement(By.name(LocatorValue));
		break;

		case "Class":  element=driver.findElement(By.className(LocatorValue));
		break;

		case "Xpath":  element=driver.findElement(By.xpath(LocatorValue));
		break;

		}


		Select st = new Select(element);

		try {
			st.selectByIndex(dropdownValue);
			
			PrintUtils.logMesaage("Successfully selected dropdown by Index");
			
		} catch (Exception e) {
			
			
			PrintUtils.logError("Unable to Select dropdown by Index");
			
		}

	}

	
	// SelectByvisible Text
	
	public void selectionByVisibleText(WebDriver driver, String locatorType, String LocatorValue, String dropdownValue)
	{

		WebElement element =null;

		switch(locatorType)
		{
		case "ID": element=driver.findElement(By.id(LocatorValue));
		break;

		case "Name":  element=driver.findElement(By.name(LocatorValue));
		break;

		case "Class":  element=driver.findElement(By.className(LocatorValue));
		break;

		case "Xpath":  element=driver.findElement(By.xpath(LocatorValue));
		break;

		}


		Select st = new Select(element);

		try {
			st.selectByVisibleText(dropdownValue);
			
			PrintUtils.logMesaage("Successfully selected dropdown by VisibleText");
			
		} catch (Exception e) {
			
			
			PrintUtils.logError("Unable to Select dropdown by VisibleText");
			
		}

	}
	
	// GetText
	
	public String getTextmethod(WebDriver driver, String locatorType, String LocatorValue)
	{

		WebElement element =null;

		switch(locatorType)
		{
		case "ID": element=driver.findElement(By.id(LocatorValue));
		break;

		case "Name":  element=driver.findElement(By.name(LocatorValue));
		break;

		case "Class":  element=driver.findElement(By.className(LocatorValue));
		break;

		case "Xpath":  element=driver.findElement(By.xpath(LocatorValue));
		break;

		}
		
		String Text = element.getText();
		return Text;
									
	}
	
	
	// GetAttribute
	
	public String getAttributeMethod(WebDriver driver, String locatorType, String LocatorValue, String AttributeValue)
	{

		WebElement element =null;

		switch(locatorType)
		{
		case "ID": element=driver.findElement(By.id(LocatorValue));
		break;

		case "Name":  element=driver.findElement(By.name(LocatorValue));
		break;

		case "Class":  element=driver.findElement(By.className(LocatorValue));
		break;

		case "Xpath":  element=driver.findElement(By.xpath(LocatorValue));
		break;

		}
		
		String AttributeVal = element.getAttribute(AttributeValue);
		return AttributeVal;
									
	}
	
	//GetFirstSelected option from drop down
	
	public void getFirstSelectedOption(WebDriver driver, String locatorType, String LocatorValue)
	{

		WebElement element =null;

		switch(locatorType)
		{
		case "ID": element=driver.findElement(By.id(LocatorValue));
		break;

		case "Name":  element=driver.findElement(By.name(LocatorValue));
		break;

		case "Class":  element=driver.findElement(By.className(LocatorValue));
		break;

		case "Xpath":  element=driver.findElement(By.xpath(LocatorValue));
		break;

		}


		Select st = new Select(element);

		try {
			st.getFirstSelectedOption();
			
			PrintUtils.logMesaage("Successfully selected the First option");
			
		} catch (Exception e) {
			
			
			PrintUtils.logError("Unable to Select the first option");
			
		}

	}
	
	//movetoelement  (ByActionClass)
	//Need to be checked
	
	public void mouseAction(WebDriver driver, String locatorType, String LocatorValue)
	
	{
		
		WebElement element =null;

		switch(locatorType)
		{
		case "ID": element=driver.findElement(By.id(LocatorValue));
		break;

		case "Name":  element=driver.findElement(By.name(LocatorValue));
		break;

		case "Class":  element=driver.findElement(By.className(LocatorValue));
		break;

		case "Xpath":  element=driver.findElement(By.xpath(LocatorValue));
		break;

		}
		Actions act = new Actions(driver);

		try {

			act.moveToElement(element).perform();
			Thread.sleep(5000);
			
			PrintUtils.logMesaage("Successfully moved to the element");
			
		} catch (Exception e) {
			
			
			PrintUtils.logError("Unable to move to the element");
			}
					
	}
	
	public void assertFail() 
	{
		
		Assert.fail();
	}
	// movetoElementandclick


	// Java Script funtions
	public static  void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');", element);
		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) {
			PrintUtils.logMesaage("highLightElement method :: "+e.getMessage());
		} 
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element); 
	}
	
	public void ClickElementByJavaScript(WebDriver driver,WebElement element)
	{
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			PrintUtils.logMesaage("Element Clicked By JavaScript Executor with element");
			
		} catch (Exception e) 
		{
			PrintUtils.logMesaage("Element Not Clicked By JavaScript Executor with element " );
		}
	}
	
	public static void scrollElementIntoView(WebDriver driver, WebElement Element) throws Exception
	{
		// used to scroll the element into view 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Element);
	}
}
