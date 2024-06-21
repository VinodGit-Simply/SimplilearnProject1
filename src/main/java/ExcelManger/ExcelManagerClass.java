package ExcelManger;

import FilerReaderManager.PropertiesReader;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExcelManagerClass {

  PropertiesReader pr = new PropertiesReader();

  Properties prop;
    String excel_testdata_path;

    public Object[][] getExcelTestData() throws IOException {

      prop = pr.ReadProperties();

      excel_testdata_path = prop.getProperty("excel_testdata_path");
       System.out.println("test data path :"+excel_testdata_path);
      File fil = new File(excel_testdata_path);

      FileInputStream fis = new FileInputStream(fil);
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(0);


      int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
      System.out.println("sheet.getFirstRowNum()" + sheet.getFirstRowNum());
      System.out.println("sheet.getLastRowNum()"+sheet.getLastRowNum());
      System.out.println("row count :"+rowcount);
      XSSFRow row = sheet.getRow(1);

      int cellcount = row.getLastCellNum() - row.getFirstCellNum();
     System.out.println("cell count :"+cellcount);
      String[][] testdata = new String[rowcount][cellcount];

      for (int i = 1; i < rowcount + 1; i++) {

        for (int j = 0; j < cellcount; j++) {
          testdata[i-1][j] = sheet.getRow(i).getCell(j).toString();
        }
      }
      return testdata;
    }

public Object[] getExcelData1() throws IOException {
  prop = pr.ReadProperties();

  excel_testdata_path = prop.getProperty("excel_testdata_path");

  File fil = new File(excel_testdata_path);

  FileInputStream fis = new FileInputStream(fil);
  XSSFWorkbook wb = new XSSFWorkbook(fis);
  XSSFSheet sheet = wb.getSheetAt(0);


  int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
  System.out.print("Rowcount1 :"+rowcount);
  XSSFRow row = sheet.getRow(1);

  int cellcount = row.getLastCellNum() - row.getLastCellNum();

Object testdata1[] = new Object[rowcount];

for(int i=1;i<rowcount+1;i++){

  testdata1[i-1] = sheet.getRow(i).getCell(0).toString();
  System.out.print("testdata1 :"+testdata1[i-1]);
}
  System.out.print("testdata1 complete :"+testdata1.toString());
return  testdata1;

  }

  public Object[] getExcelData2() throws IOException {
    prop = pr.ReadProperties();

    excel_testdata_path = prop.getProperty("excel_testdata_path");

    File fil = new File(excel_testdata_path);

    FileInputStream fis = new FileInputStream(fil);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheetAt(1);


    int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
    System.out.print("Rowcount2 :"+rowcount);
    XSSFRow row = sheet.getRow(1);

    int cellcount = row.getLastCellNum() - row.getLastCellNum();

    Object testdata2[] = new Object[rowcount];

    for(int i=1;i<rowcount+1;i++){

      testdata2[i-1] = sheet.getRow(i).getCell(0).toString();
      System.out.print("testdata2 :"+testdata2[i-1]);
    }
    System.out.print("testdata complete2 :"+testdata2.toString());
    return  testdata2;

  }


}
