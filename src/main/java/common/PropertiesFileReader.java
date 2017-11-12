package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesFileReader {

	Properties obj = new Properties();
	
	public PropertiesFileReader(String filePath)
	{
		File file = new File(filePath);
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
		PrintUtils.logError("Verfiy path of properties file");
		}
		
		try {
			obj.load(fis);
		} catch (IOException e) 
		{
			PrintUtils.logError("Unable to load key value in Properties class");
		}
		
	}
	
	public String getProp(String Key)
	{
		String value= obj.getProperty(Key);
		return value;
	}
	
}
