/**
 * 
 */
package orange.HRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author Mallesh
 * 
 * This class will store all the locators and methods of directory page
 *
 */
public class DirectoryPage 
{
WebDriver driver;
String returnStr = null;
	
	By directoryLink = By.linkText("Directory");
	By logoDirectory = By.className("oxd-topbar-header-breadcrumb-module");
	By searchNameField = By.xpath("//div[contains(@class, \"oxd-autocomplete-text-input\")]/input");
	By searchButton = By.xpath("//button[@type=\"submit\"]");
	By resultsListName = By.className("orangehrm-directory-card-header");
	By resetButton = By.xpath("//button[@type=\"reset\"]");
	By autoCompleteOption = By.className("oxd-autocomplete-option");
	
	public DirectoryPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyDirectoryLogo()
	{
		driver.findElement(directoryLink).click();
		String logoText = driver.findElement(logoDirectory).getText();
		Assert.assertEquals(logoText, "Directory");
	}
	
	public String searchDirectory(String srcStr) throws Exception
	{
		driver.findElement(searchNameField).sendKeys(srcStr);
		Thread.sleep(5000);
		String autoCompleteValue = driver.findElement(autoCompleteOption).getText();
		System.out.println("the auto complete text = "+autoCompleteValue);
		
		if (autoCompleteValue.equals("No Records Found")) {
			returnStr = "Not Found";
		}
		else
		{
			driver.findElement(autoCompleteOption).click();
			driver.findElement(searchButton).click();
			Thread.sleep(3000);
			String searchResultName = driver.findElement(resultsListName).getText();
			System.out.println("the result text is ="+searchResultName);
			returnStr = "Found";	
		}
		
		return returnStr;
	}
	
	public void clickReset()
	{
		if (returnStr.equals("Found"))
		{
			driver.findElement(resetButton).click();
		}
		else
		{
			String selectAll = Keys.chord(Keys.CONTROL, "a");
			driver.findElement(searchNameField).sendKeys(selectAll);
			driver.findElement(searchNameField).sendKeys(Keys.BACK_SPACE);
		}
	}
}
