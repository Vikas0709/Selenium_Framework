package firstTestcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import selenium.WebDriverGenerics;

public class LowestPrice extends WebDriverGenerics 
{
	WebDriver driver =null;
	
	public void mouseAction() throws IOException, InterruptedException
	 {
		 
		 WebElement ele =driver.findElement(By.xpath("//a[@class='MenuBarItemSubmenu']"));
		 
		Actions act = new Actions(driver);
		
		act.moveToElement(ele).perform();
		
		
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Dog Food']"))).click().build().perform();
		
		WebElement dropdown =driver.findElement(By.id("ctl00__pageBody_ddlSortItemsSLI"));
		Select st = new Select(dropdown);
		st.selectByVisibleText("Lowest Price");
		
		WebElement lowestprice = driver.findElement(By.id("ctl00__pageBody_rptGridViewRowsSLI_ctl00_rptGridViewCellsSLI_ctl00_lblPrice"));
		
		System.out.println(lowestprice.getText());
		
		
			 }
	
	

	public static void main(String[] args) throws IOException, InterruptedException {
		
		LowestPrice obj = new LowestPrice();
		
		obj.driver = obj.openBrowser(obj.driver, "Chrome", "http://www.petstore.com/");
		
		obj.mouseAction();
		
				

	}

}
