package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.PrintUtils;
import common.PropertiesFileReader;
import testRunner.TestNGBaseRunner;

public class ForgetPassword extends TestNGBaseRunner
{
	PropertiesFileReader prop=null;
 
	@BeforeClass
	public void beforeClass()
	{
		PrintUtils.logMesaage("Before class called to read prop file");
		prop= new PropertiesFileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepo\\ForgetPassword_OR.properties");
	}
	
  @Test(enabled=false)
  public void validatePageTitle()
  {
	  
	  String ActualTitle =getTitle(driver);
	  PrintUtils.logMesaage("ActualPage Title::"+ActualTitle);
	  if(ActualTitle.equals("Bala"))
	  {
		  PrintUtils.logMesaage("Title Matched");
	  }else 
	  {
		  PrintUtils.logError("TitleNot Macthd");
		  assertFail();
		  
	  }
  }
  
  @Test
  public void verifyButtonLink() 
  {

	  clickByLinkText(driver, prop.getProp("SelPayGrd"));
	  clickByXPath(driver, prop.getProp("Button_Xpath"));
	  int i =20;
	  
	  if(i==200)
	  {
		  PrintUtils.logMesaage("Matched");
		  testStatus(true);
	  }
	  else 
	  {
		  PrintUtils.logError("Not Matched");
		  testStatus(false);
	  }
	  
	  String name ="Bala";
	  if(name.equals("Bala"))
	  {
		  PrintUtils.logMesaage("Matched");
		  testStatus(true);
	  }
	  else 
	  {
		  PrintUtils.logError("Not Matched");
		  testStatus(false);
	  }
	  
	  endTestcase();
	  
  }
  
  
  @Test
  public void verifyCheckBoxLink()
  {

	  clickByLinkText(driver, prop.getProp("SelPayGrd"));
	  clickByXPath(driver, prop.getProp("CheckBox_Xpath"));
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
