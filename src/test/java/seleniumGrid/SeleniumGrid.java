package seleniumGrid;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {
	
	WebDriver driver;
	String baseURL, nodeUrl;
	
	
	@BeforeTest
	public void setUp() throws Exception
	{
		baseURL="https://www.guru99.com/introduction-to-selenium-grid.html";
		nodeUrl="http://192.168.1.8:4444/wd/hub";
		
		DesiredCapabilities cap = new DesiredCapabilities().chrome();
		cap.setBrowserName("");
		cap.setPlatform(Platform.ANY);
		driver = new RemoteWebDriver(new URL(nodeUrl), cap);
		
	}	
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	
	@Test
	public void testcase() {
		
		driver.get(baseURL);
		System.out.println(driver.getTitle());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
