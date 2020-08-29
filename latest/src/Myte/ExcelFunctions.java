package Myte;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFunctions {
  public ExcelFunctions() throws Exception {
    FileInputStream fis = new FileInputStream("C:\\TestData\\Myte.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    XSSFSheet sheet = workbook.getSheetAt(0);
    XSSFRow xSSFRow = sheet.getRow(0);
    Cell cell = xSSFRow.getCell(0);
    System.out.println(cell);
    System.out.println(sheet.getRow(0).getCell(0));
  }
}
