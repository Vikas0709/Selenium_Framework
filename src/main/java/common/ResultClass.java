package common;

import java.util.ArrayList;
import java.util.List;

import org.testng.asserts.SoftAssert;

public class ResultClass
{
	
	public SoftAssert sa = null;
	public static List<Boolean> resultStaus =new ArrayList<Boolean>();
	
	public void createSoftAssert() 
	{
		sa= new SoftAssert();
	}
	
	public  void testStatus(boolean value) 
	{
		// for Excel report
		resultStaus.add(value);
		
		//for TestNG report
		if(value==true)
		{
			sa.assertEquals(value, true);
		}else if(value==false)
		{
			sa.fail();
		}
		
		PrintUtils.logMesaage("Test Step Status:: "+value);
	}

	public void endTestcase() 
	{
		sa.assertAll();
	}
}
