package testcases;

import org.openqa.selenium.WebDriver;

import common.PrintUtils;
import selenium.WebDriverGenerics;

public class LoginToFB extends WebDriverGenerics{

	
	
	public WebDriver driver = null;
	
	public void login()
	{
		PrintUtils.logMesaage("Validated Login functionality");
		
		driver=openBrowser(driver, "CHROME", "https://www.facebook.com/");
		enterTxtById(driver, "email", "bala");
	}
	
	public static void main(String[] args) {
		
		LoginToFB obj = new LoginToFB();
		obj.login();
	}
}
