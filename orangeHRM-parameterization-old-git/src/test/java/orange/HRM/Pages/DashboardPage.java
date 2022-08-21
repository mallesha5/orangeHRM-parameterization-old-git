/**
 * 
 */
package orange.HRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Mallesh
 * 
 * This class will store all the locators and methods of dashboard page
 *
 */
public class DashboardPage 
{
	WebDriver driver;
	
	By dashboardLink = By.linkText("Dashboard");
	By logo = By.className("oxd-topbar-header-breadcrumb-module");
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyDashboardLogo()
	{
		driver.findElement(dashboardLink).click();
		String logoText = driver.findElement(logo).getText();
		Assert.assertEquals(logoText, "Dashboard");
	}
	
}
