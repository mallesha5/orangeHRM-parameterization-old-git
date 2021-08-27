/**
 * 
 */
package orange.HRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Mallesh
 *
 */
public class LogoutPage 
{
	WebDriver driver;
	
	By logoutMenu = By.id("welcome");
	By logoutBtn = By.linkText("Logout");
	
	public LogoutPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void logoutOrangeHRM()
	{
		
		driver.findElement(logoutMenu).click();
		driver.findElement(logoutBtn).click();
		
		System.out.println(driver.getCurrentUrl());
	}
}
