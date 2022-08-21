package orange.HRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Mallesh
 * 
 * This class will store all the locators and methods of pim page
 *
 */

public class PIMPage {
	
WebDriver driver;
	
	By logo = By.className("oxd-topbar-header-breadcrumb-module");
	
	public PIMPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyPIMLogo()
	{
		String logoText = driver.findElement(logo).getText();
		Assert.assertEquals(logoText, "PIM");
	}

}
