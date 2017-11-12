package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.SkipException;

public class Excel_Config
{
	public static String TestcaseID=null;
	public static String TestcaseNAME=null;
	public static String TestDesc=null;
	public static String TestDatas=null;
	public static String RunMode=null;
	public static String Status=null;
	
	public static String excelFilePath =".\\src\\test\\resources\\ExcelDatas\\TestDatas.xlsx"; 
	public static String excelSheetName=null;
	public static HashMap<String, String> hashMap =null;
	
	public static String TestCaseNameForUpdate=null;
			
	public void setSheetName(String SheetName)
	{
		excelSheetName=SheetName;
	}
	
	
	public void getTestData(String Methodname) throws Exception 
	{
		File file = new File(excelFilePath);
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sh =wb.getSheet(excelSheetName);
		
		for(int i=1; i<=sh.getLastRowNum(); i++)
		{
		
		TestcaseID=sh.getRow(i).getCell(0).getStringCellValue();
		TestcaseNAME=sh.getRow(i).getCell(1).getStringCellValue();
		TestCaseNameForUpdate=TestcaseNAME;
		if(TestcaseNAME.equals(Methodname))
		{
			TestDesc=sh.getRow(i).getCell(2).getStringCellValue();
			TestDatas=sh.getRow(i).getCell(3).getStringCellValue();
			RunMode=sh.getRow(i).getCell(4).getStringCellValue();
			if(RunMode.toUpperCase().equals("YES"))
			{
			splitData(TestDatas);
			ExtentReport.setTestName(TestcaseNAME, TestDesc);
			PrintUtils.logMesaage(hashMap.entrySet().toString());
			break;
			}else 
			{
				PrintUtils.logError("Testcase Skipped due to Run Mode set with NO");
				throw new SkipException("TestCase Skipped");
			}
		}
		
		
		}
	}
	
	//UserName=Bala#Pasword=test123#Expectedtitle=Login
	
	public  HashMap<String, String> splitData(String data)
	{
		try{
			hashMap = new HashMap<String,String>();
			for (int i=0; i<data.split("#").length; i++)
			{
				String keyValue =data.split("#")[i].toString();
			
				String key =keyValue.split("=")[0].toString();
				String value =keyValue.split("=")[1].toString();
				hashMap.put(key,value);
			}
		}catch(Exception e){
			PrintUtils.logError(e.getMessage());
		}
		
		return hashMap;
	}
	
	public static void updateResult() throws Exception
	{
		try {
			FileInputStream file = new FileInputStream(excelFilePath);

			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sh = wb.getSheet(excelSheetName);
			// Cell cell = null;

			int rowCount =sh.getLastRowNum();
			int iTotalTestCases =rowCount+1;

			for(int i=1; i<=sh.getLastRowNum(); i++)
			{
				try
				{	
					TestcaseNAME= sh.getRow(i).getCell(1).getStringCellValue();	
					
					if(TestcaseNAME.equalsIgnoreCase(TestCaseNameForUpdate))
					{
						if(ResultClass.resultStaus.contains(false))
						{	
							sh.getRow(i).getCell(5).setCellValue("FAIL");

						}else
						{
							sh.getRow(i).getCell(5).setCellValue("PASS");
						}
						
						if(ResultClass.resultStaus.isEmpty())
						{
							sh.getRow(i).getCell(5).setCellValue("Skipped");
						}
						file.close();
						FileOutputStream outFile =new FileOutputStream(new File(excelFilePath));
						wb.write(outFile);
						outFile.close();
						break;
					}	
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println("Unable to Update Result to Testcase ID :: "+TestcaseID);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
