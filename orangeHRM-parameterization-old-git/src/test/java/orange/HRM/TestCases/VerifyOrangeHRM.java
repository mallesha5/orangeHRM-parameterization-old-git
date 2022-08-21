/**
 * 
 */
package orange.HRM.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import configuration.Webdriver;
import orange.HRM.Pages.DashboardPage;
import orange.HRM.Pages.DirectoryPage;
import orange.HRM.Pages.LoginPage;
import orange.HRM.Pages.LogoutPage;
import orange.HRM.Pages.PIMPage;

/**
 * @author Mallesh
 *
 */
public class VerifyOrangeHRM 
{
	
	WebDriver driver;
	
	@Test
	public void VerifyOrangeHRMSearch() throws Exception
	{

		driver = Webdriver.InitializeWebDriver();
		
		LoginPage login = new LoginPage(driver);
		PIMPage pim = new PIMPage(driver);
		DashboardPage dashboard = new DashboardPage(driver);
		LogoutPage logout = new LogoutPage(driver);
		DirectoryPage directory = new DirectoryPage(driver);


		
		
		File src = new File("src\\test\\resources\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int rows = sheet1.getPhysicalNumberOfRows();
		int cols = sheet1.getRow(0).getPhysicalNumberOfCells();
		System.out.println("the no. of row and columns are - "+rows+":"+cols);
		
		
		
		
		
		
		
		login.loginToOrangeHRM("Admin","admin123");
		pim.verifyPIMLogo();
		dashboard.verifyDashboardLogo();
		directory.verifyDirectoryLogo();
		
		FileOutputStream fos = new FileOutputStream("src\\test\\resources\\TestData.xlsx");

		for (int i=1;i<rows;i++)
		{
			
			String searchName = sheet1.getRow(i).getCell(2).getStringCellValue();
			String srcRes = directory.searchDirectory(searchName);
			sheet1.getRow(i).createCell(3).setCellValue(srcRes);
			
			
			directory.clickReset();
			
			
		}
		wb.write(fos);
		wb.close();
		logout.logoutOrangeHRM();
		Webdriver.QuitWebDriver();
	
	}
	
	
}
