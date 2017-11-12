package seleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Test {

	public static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		String URL = "http://www.DemoQA.com";
 		String Node = "http://192.168.1.8:4444/wd/hub";
 		System.out.println("test");
 		DesiredCapabilities cap = DesiredCapabilities.chrome();
 		cap.setBrowserName("chrome");
 		cap.setPlatform(Platform.VISTA);
 
 		driver = new RemoteWebDriver(new URL(Node), cap);
 
 		driver.navigate().to(URL);
 	
 		driver.quit();

	}

}
