package VinothVijayakumar;


	

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
//How to read excel files using Apache POI
/*public class ReadExcel {*/

public class ExcelFunctions {
	/*@Parameters({ "TestInstance" })
	@Test()*/
	

	public ExcelFunctions() throws Exception {


	
/* public static void main (String [] args) throws IOException{*/
                        //I have placed an excel file 'Test.xlsx' in my D Driver 
 FileInputStream fis = new FileInputStream("C:\\Users\\X403377\\Test\\Testing\\src\\VinothVijayakumar\\Myte.xlsx");
 @SuppressWarnings("resource")
XSSFWorkbook workbook = new XSSFWorkbook(fis);
 XSSFSheet sheet = workbook.getSheetAt(0);
                        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
                        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
 Row row = sheet.getRow(0);
 Cell cell = row.getCell(0);
                       System.out.println(cell);
                   //    XSSFCell DROP = (sheet.getRow(0).getCell(0));
 System.out.println(sheet.getRow(0).getCell(0));
 //String cellval = cell.getStringCellValue();
 //System.out.println(cellval);
 
 } 
}


