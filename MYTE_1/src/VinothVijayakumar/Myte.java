package VinothVijayakumar;

/*import java.util.ArrayList;


import java.util.List;*/

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/*import org.openqa.selenium.chrome.ChromeOptions;*/
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;


public class Myte {
	@Parameters({ "TestInstance" })
	@Test()
	public void Test(@Optional("1") String TestInstance) throws Exception {


		//ExcelFunctions excel = new ExcelFunctions();
		WebElement element;
		
		//System.setProperty("webdriver.chrome.driver", "C:\\QMS_R4_SE_Resources\\ChromeDriver_83\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		//C:\Program Files (x86)\Google\Chrome\Application
		
	/*	System.setProperty("webdriver.chrome.driver", "C:\\Vinoth_Imp\\Chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	*/	
		
		//Change chrome driver path accordingly
		System.setProperty("webdriver.chrome.driver", "C:\\Vinoth_Imp\\Chrome\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9014");
		WebDriver driver = new ChromeDriver(options);
		
		System.out.println(driver.getTitle());
		
		
		//driver.get("https://myte.accenture.com/");

		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		ExcelUtil.setExcelFileSheet("MYTE");
		
		String CellGetContent = ExcelUtil.getCellData(0, 0);
		System.out.println(CellGetContent);
		
		
		
		
	/*	
	 * element = driver.findElement(By.id("userNameInput"));
	 * element.isDisplayed();
		element.getText().trim();
		System.out.println(element.getText().trim());
		String Firstvalue=ExcelUtil.getCellData(1, 1);
		System.out.println(Firstvalue);
		element.sendKeys(Firstvalue);
		*/
	
		try {
		element = driver.findElement(By.xpath("//*[@title='Authorize employees to use a charge code']"));
		element.click();
		}catch(NoSuchElementException exception) {
			
			System.out.println("Skipping");
		}
		/****************************************************************************************************************/			
		
		Thread.sleep(3000);
		try {
		
		element = driver.findElement(By.xpath("//*[@id=\"ctl00_Authorizarion\"]/span"));
		element.click();
		} catch(NoSuchElementException exception) {
			
			System.out.println("Skipping");
		}
		
		
		Thread.sleep(3000);
		
		/****************************************************************************************************************/			
		
		//Dropdown Option Select
		
		String Dropdown=ExcelUtil.getCellData(1, 1);
		
		System.out.println(Dropdown);
			
		
		Select chargecode = new Select(driver.findElement(By.id("ctl00_MainContentPlaceHolder_cmb_Assignment")));
		
		chargecode.selectByVisibleText(Dropdown);
		
		Thread.sleep(2000);
		
		/****************************************************************************************************************/			
		
		//Deleting all Records
		
		
		element = driver.findElement(By.id("ctl00_MainContentPlaceHolder_btAccentureUserDeleteAll"));
		element.click();
		
		
		Thread.sleep(2000);
		
		/****************************************************************************************************************/			
		//Clicking on Add Multiple Record
		
		element = driver.findElement(By.id("ctl00_MainContentPlaceHolder_LinkButton1"));
		element.click();
		/****************************************************************************************************************/				
		//Adding Admin User First
		
		element = driver.findElement(By.id("ctl00_MainContentPlaceHolder_txt_EmployeeList"));
		
		
		String AdminUser=ExcelUtil.getCellData(1, 2);
		
		System.out.println(AdminUser);
		
		AdminUser.replace(" ", ";");
			
		element.sendKeys(AdminUser);
		
		element = driver.findElement(By.id("ctl00_MainContentPlaceHolder_btn_Add"));
		
		element.click();
		
		Thread.sleep(2000);
		
		/****************************************************************************************************************/			
		
		//Checking all boxes for Admin Rights
		
		List<WebElement> chkbox = driver.findElements(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_grd_AuthorizedUsers']//td[@type='checkbox']"));
		
		
		for(int i=0;i<=chkbox.size();i++) {
			chkbox.get(i).click();
		}
		
		
		//Clicking on Add Multiple Record
		
				element = driver.findElement(By.id("ctl00_MainContentPlaceHolder_LinkButton1"));
				element.click();
				
	/****************************************************************************************************************/			
				//Adding Other User First
				
				element = driver.findElement(By.id("ctl00_MainContentPlaceHolder_txt_EmployeeList"));
				
				
				String otherUser=ExcelUtil.getCellData(1, 3);
				
				System.out.println(AdminUser);
				
				otherUser.replace(" ", ";");
					
				element.sendKeys(otherUser);
				
				element = driver.findElement(By.id("ctl00_MainContentPlaceHolder_btn_Add"));
				
				element.click();
				
				Thread.sleep(2000);
 /******************************************************************************************************************/				
		System.out.println("Record is added");	
				
		/*driver.quit();*/
	}

}
