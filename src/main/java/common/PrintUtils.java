package common;

import org.testng.Reporter;

public class PrintUtils {

	/**
	 * @author Balamurugan
	 * @category test
	 */
	
	public  static void logMesaage(String Value)
	{
		System.out.println(Value);
		Reporter.log(Value);
		ExtentReport.testStep(Value, "pass");
		
	}
	
	public static void logError(String Value)
	{
		System.err.println(Value);
		Reporter.log(Value);
		ExtentReport.testStep(Value, "fail");
	}
}
