package testNG_example;

import org.testng.Assert;
import org.testng.annotations.*;

import common.PrintUtils;

public class Annotation_Basics
{
 
	
	@BeforeSuite
	public void beforeSuite() 
	{
		PrintUtils.logMesaage("BeforeSutie");
	}
	
	@BeforeTest
	public void beforeTest() 
	{
		PrintUtils.logMesaage("BeforeTest");
	}
	
	@BeforeClass
	public void beforeClass() 
	{
		PrintUtils.logMesaage("BeforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		PrintUtils.logMesaage("BeforeMetod");
	}
	
	@Test(priority=2)
	public void testcase_1() 
	{
		PrintUtils.logMesaage("testcase_1");
	}
	
	

	@Test(priority=1)
	public void testcase_2() 
	{
		PrintUtils.logMesaage("testcase_2");
	}
	
	@Test(enabled=true)
	public void testcase_3() 
	{
		PrintUtils.logMesaage("testcase_3");
		int i=0;
		if(i==10)
		{
			PrintUtils.logMesaage("Value Matched");
		}else 
		{
			PrintUtils.logError("Value not macthed");
			Assert.fail();
		}
		
		PrintUtils.logMesaage("Step_2");
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		PrintUtils.logMesaage("AfterMethod");
	}
	
	
	@AfterClass
	public void afterClass() 
	{
		PrintUtils.logMesaage("AfterClass");
	}
	
	@AfterTest
	public void afterTest() 
	{
		PrintUtils.logMesaage("AfterTest");
	}
	

	@AfterSuite
	public void afterSuite() 
	{
		PrintUtils.logMesaage("AfterSuite");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
