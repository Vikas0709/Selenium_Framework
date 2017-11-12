package testNG_example;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.PrintUtils;

public class SoftAssert 
{
	
	
  @Test(enabled =false)
  public void HardAssert()
  {
	  PrintUtils.logMesaage("Step_1");
	  PrintUtils.logMesaage("Step_2");
	  PrintUtils.logMesaage("Step_3");
	  Assert.fail();
	  PrintUtils.logMesaage("Step_4");
	  PrintUtils.logMesaage("Step_5");
	  PrintUtils.logMesaage("Step_6");
  }
  
  
  @Test(enabled =true)
  public void SoftAssert()
  {
	  PrintUtils.logMesaage("Step_1");
	  PrintUtils.logMesaage("Step_2");
	  PrintUtils.logMesaage("Step_3");
	  org.testng.asserts.SoftAssert obj = new org.testng.asserts.SoftAssert();
	  
	  
	  obj.assertEquals(true, true);
	  
	  PrintUtils.logMesaage("Step_4");
	  PrintUtils.logMesaage("Step_5");
	  obj.assertEquals(true, true);
	  PrintUtils.logMesaage("Step_6");
	  
	  obj.assertAll();
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
