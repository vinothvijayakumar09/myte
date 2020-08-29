package Myte;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyteFinal {
	@Parameters({ "TestInstance" })
	@Test
	public void Test(@Optional("1") String TestInstance) throws Exception {
		WebElement element = null;
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9014");
		ChromeDriver chromeDriver = new ChromeDriver(options);
		System.out.println(chromeDriver.getTitle());
		ExcelUtil.setExcelFileSheet("MYTE");
		String CellGetContent = ExcelUtil.getCellData(0, 0);
		System.out.println(CellGetContent);
		try {
			element = chromeDriver.findElement(By.xpath("//*[@title='Authorize employees to use a charge code']"));
			element.click();
		} catch (NoSuchElementException exception) {
			System.out.println("skipping");
		}
		Thread.sleep(3000L);
		try {
			element = chromeDriver.findElement(By.xpath("//*[@id=\"ctl00_Authorizarion\"]/span"));
			element.click();
		} catch (NoSuchElementException exception) {
			System.out.println("skipping");
		}
		Thread.sleep(3000L);
		element = null;
		element = chromeDriver.findElement(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_cmb_Assignment']"));
		element.click();
		int Count = ExcelUtil.mumericgetCellData(1, 3);
		List<WebElement> WbseSize = element
				.findElements(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_cmb_Assignment']//option"));
		System.out.println(WbseSize);
		System.out.println(WbseSize.size());
		for (int i = 2; i <= WbseSize.size(); i++) {
			element = null;
			element = chromeDriver
					.findElement(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_cmb_Assignment']//option[" + i + "]"));
			String Charge = element.getText().trim();
			ArrayList<String> ChargeCode = new ArrayList<>();
			ChargeCode.add(Charge);
			String[] Dropdown = element.getText().split("\\(");
			String available = Dropdown[1].trim();
			String Chargsplit = available.replaceAll("\\)", "");
			for (int k = 1; k <= Count; k++) {
				System.out.println("In the loop to select the Wbse");
				String EmployeeCode = ExcelUtil.getCellData(k, 0);
				boolean RowCount = ExcelUtil.getCellData(k, 0).isEmpty();
				try {
					if (!RowCount)
						try {
							if (Chargsplit.equals(EmployeeCode)) {
								System.out.println("Inside if Condition");
								element = null;
								element = chromeDriver.findElement(By.xpath(
										"//*[@id='ctl00_MainContentPlaceHolder_cmb_Assignment']//option[" + i + "]"));
								element.click();
								break;
							}
							if (!Chargsplit.equals(EmployeeCode))
								;
						} catch (NullPointerException exception) {
							System.out.println("skipping");
							break;
						}
				} catch (NullPointerException exception) {
					break;
				}
			}
			try {
				element = null;
				element = chromeDriver.findElement(By.id("ctl00_MainContentPlaceHolder_btAccentureUserDeleteAll"));
				element.click();
			} catch (NoSuchElementException exception) {
				System.out.println("skipping");
			}
			try {
				element = null;
				element = chromeDriver.findElement(By.id("ctl00_MainContentPlaceHolder_LinkButton1"));
				element.click();
			} catch (NoSuchElementException exception) {
				System.out.println("skipping");
			}
			String AdminUsers = ExcelUtil.getCellData(1, 2);
			try {
				element = null;
				element = chromeDriver.findElement(By.id("ctl00_MainContentPlaceHolder_txt_EmployeeList"));
				element.sendKeys(new CharSequence[] { AdminUsers });
			} catch (NoSuchElementException exception) {
				System.out.println("skipping");
			}
			try {
				element = null;
				element = chromeDriver.findElement(By.id("ctl00_MainContentPlaceHolder_btn_Add"));
				element.click();
			} catch (NoSuchElementException exception) {
				System.out.println("skipping");
			}
			List<WebElement> chkbox = chromeDriver.findElements(
					By.xpath("//*[@id='ctl00_MainContentPlaceHolder_grd_AuthorizedUsers']//td[2]//input"));
			int size = chkbox.size();
			for (int m = 1; m <= size; m++) {
				element = chromeDriver.findElement(By.xpath(
						"//*[@id='ctl00_MainContentPlaceHolder_grd_AuthorizedUsers']//tr[" + m + "]//td[2]//input"));
				element.click();
			}
			try {
				element = null;
				element = chromeDriver.findElement(By.id("ctl00_MainContentPlaceHolder_LinkButton1"));
				element.click();
			} catch (NoSuchElementException exception) {
				System.out.println("skipping");
			}
			for (int j = 1, n = 1; j <= Count && n <= Count; j++, n++) {
				String OtherUsers = ExcelUtil.getCellData(j, 1);
				boolean RowCount = ExcelUtil.getCellData(j, 1).isEmpty();
				try {
					if (!RowCount) {
						element = null;
						element = chromeDriver
								.findElement(By.xpath("//*[@id='ctl00_MainContentPlaceHolder_cmb_Assignment']"));
						String Chargsplits = element.getAttribute("value");
						String AfterConcat = OtherUsers.concat(";");
						String EmployeeCode = ExcelUtil.getCellData(n, 0);
						if (Chargsplits.equals(EmployeeCode)) {
							element = null;
							element = chromeDriver.findElement(By.id("ctl00_MainContentPlaceHolder_txt_EmployeeList"));
							element.sendKeys(new CharSequence[] { AfterConcat });
						} else if (!Chargsplits.equals(EmployeeCode)) {

						}
					}
				} catch (NullPointerException exception) {
					System.out.println("breaking");
					break;
				}
			}
			try {
				element = null;
				element = chromeDriver.findElement(By.id("ctl00_MainContentPlaceHolder_btn_Add"));
				element.click();
				System.out.println("Both the Admin and Other Users added successfully");
			} catch (NoSuchElementException exception) {
				System.out.println("skipping");
			}
		}
	}
}
