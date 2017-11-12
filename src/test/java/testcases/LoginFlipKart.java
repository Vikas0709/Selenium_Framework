package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.Excel_Config;
import common.PrintUtils;
import common.PropertiesFileReader;
import testRunner.TestNGBaseRunner;

public class LoginFlipKart extends TestNGBaseRunner
{
	PropertiesFileReader prop=null;
	Excel_Config e = new Excel_Config();
	 
	@BeforeClass
	public void beforeClass()
	{
		PrintUtils.logMesaage("Before class called to read prop file");
		prop= new PropertiesFileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepo\\flipkart.properties");
		
		e.setSheetName("Login");
	}
	
  @Test()
  public void validateLoginPage() throws Exception
  {
	  e.getTestData("validateLoginPage");
	  
	  PrintUtils.logMesaage(Excel_Config.hashMap.get("UserName"));
	  PrintUtils.logMesaage(Excel_Config.hashMap.get("Pasword"));
	  
	 // enterTxtByXpath(driver, prop.getProp("Email"), Excel_Config.hashMap.get("UserName"));
	 // enterTxtByXpath(drssiver, prop.getProp("pasword"), Excel_Config.hashMap.get("Pasword"));
	  
	  if(driver.getTitle().equals(Excel_Config.hashMap.get("Expectedtitle")))
	  {
		  PrintUtils.logMesaage("Title matched");
		  testStatus(true);
	  }
	  else 
	  {
		  PrintUtils.logError("Title not Mactched");
		  testStatus(false);
	  }
	  endTestcase();
	  
  }
  
  @Test()
  public void validateLoginPage_1() throws Exception
  {
	  e.getTestData("validateLoginPage_1");
	  
	 // enterTxtByXpath(driver, prop.getProp("Email"), Excel_Config.hashMap.get("UserName"));
	 // enterTxtByXpath(drssiver, prop.getProp("pasword"), Excel_Config.hashMap.get("Pasword"));
	  
	  if(driver.getTitle().equals(Excel_Config.hashMap.get("Expectedtitle")))
	  {
		  PrintUtils.logMesaage("Title matched");
		  testStatus(true);
	  }
	  else 
	  {
		  PrintUtils.logError("Title not Mactched");
		  testStatus(false);
	  }
	  endTestcase();
	  
  }
}
