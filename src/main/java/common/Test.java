package common;

public class Test extends ExtentReport{

	public static void main(String[] args)
	{
		ExtentReport r  = new ExtentReport();
		r.startReport();
		r.setTestName("Bala", "Test");
		r.testStep("Testcase passed", "pass");
		r.endReport();

	}

}
