package Myte;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
  public static final String currentDir = System.getProperty("user.dir");
  
  public static String testDataExcelPath = null;
  
  private static XSSFWorkbook excelWBook;
  
  private static XSSFSheet excelWSheet;
  
  private static XSSFCell cell;
  
  private static XSSFRow row;
  
  public static int rowNumber;
  
  public static int columnNumber;
  
  public static void setRowNumber(int pRowNumber) {
    rowNumber = pRowNumber;
  }
  
  public static int getRowNumber() {
    return rowNumber;
  }
  
  public static void setColumnNumber(int pColumnNumber) {
    columnNumber = pColumnNumber;
  }
  
  public static int getColumnNumber() {
    return columnNumber;
  }
  
  public static void setExcelFileSheet(String sheetName) {
    testDataExcelPath = "C:\\TestData\\Myte.xlsx";
    try {
      FileInputStream ExcelFile = new FileInputStream(testDataExcelPath);
      excelWBook = new XSSFWorkbook(ExcelFile);
      excelWSheet = excelWBook.getSheet(sheetName);
    } catch (Exception e) {
      try {
        throw e;
      } catch (IOException e1) {
        e1.printStackTrace();
      } 
    } 
  }
  
  public static String getCellData(int RowNum, int ColNum) {
    try {
      cell = excelWSheet.getRow(RowNum).getCell(ColNum);
      String Data = cell.getStringCellValue();
      return Data;
    } catch (Exception e) {
      throw e;
    } 
  }
  
  public static int mumericgetCellData(int RowNum, int ColNum) {
    try {
      cell = excelWSheet.getRow(RowNum).getCell(ColNum);
      int Data = (int)cell.getNumericCellValue();
      return Data;
    } catch (Exception e) {
      throw e;
    } 
  }
  
  public static XSSFRow getRowData(int RowNum) {
    try {
      row = excelWSheet.getRow(RowNum);
      return row;
    } catch (Exception e) {
      throw e;
    } 
  }
  
  public static void setCellData(String value, int RowNum, int ColNum) {
    try {
      row = excelWSheet.getRow(RowNum);
      cell = row.getCell(ColNum);
      if (cell == null) {
        cell = row.createCell(ColNum);
        cell.setCellValue(value);
      } else {
        cell.setCellValue(value);
      } 
      FileOutputStream fileOut = new FileOutputStream(testDataExcelPath);
      excelWBook.write(fileOut);
      fileOut.flush();
      fileOut.close();
    } catch (Exception e) {
      try {
        throw e;
      } catch (IOException e1) {
        e1.printStackTrace();
      } 
    } 
  }
}
