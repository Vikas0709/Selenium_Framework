package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import common.Excel_Config;
import common.ExtentReport;
import common.PrintUtils;
import selenium.WebDriverGenerics;

public class TestNGBaseRunner extends WebDriverGenerics
{

	public WebDriver driver =null ;
	public WebElement element =null;
	
	public String UAT_URL =null;
	public String SIT_URL =null;
	public String HomePage_URL=null;
	
	@Parameters({"AppURL_SIT","AppURL_UAT"})
	@BeforeSuite
	public void beforeSuite(String SITURL, String UATURL) 
	{
		ExtentReport.startReport();
		ExtentReport.setTestName("Login", "To verify launch Browser");
		PrintUtils.logMesaage("BeforeSuite Called");
		UAT_URL=UATURL;
		SIT_URL=SITURL;
		
	}
	
	@Parameters("BrowserName")
	@BeforeTest
	public void beforeTest(String BrowserName) 
	{
		this.driver= openBrowser(driver, BrowserName, UAT_URL);
		HomePage_URL=getCurrentUrl(driver);
		
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		PrintUtils.logMesaage("BeforeMethod called");
		navigateToURL(driver, HomePage_URL);
		createSoftAssert();
		resultStaus.clear();
		
	}
	
	@AfterMethod
	public void afterMethod() throws Exception 
	{
		PrintUtils.logMesaage("AfterMethod called");
		PrintUtils.logMesaage("ResultStatus :: "+resultStaus);
		//excel report
		ExtentReport.endReport();
		Excel_Config.updateResult();
	}
	
	@AfterTest
	public void afterTest() 
	{
		ExtentReport.setTestName("Logout", "To verify Logout");
		closeBrowser(driver);
	}
	
	
	@AfterSuite
	public void afterSuite() 
	{
		PrintUtils.logMesaage("After Suites called");
		ExtentReport.endReport();
	}
	
	
	
	
	
	
	
	
	
}
