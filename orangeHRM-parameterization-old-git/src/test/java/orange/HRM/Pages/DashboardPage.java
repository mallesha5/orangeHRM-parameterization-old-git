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
 */
public class DashboardPage 
{
	WebDriver driver;
	
	By logo = By.xpath("//*[@class=\"head\"]/h1");
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyDashboardLogo()
	{
		String logoText = driver.findElement(logo).getText();
		System.out.println(logoText);
		Assert.assertEquals(logoText, "Dashboard");
	}
	
}
