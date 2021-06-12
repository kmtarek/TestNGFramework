package Utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtil {
    static String pathway;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public  ExcelUtil(String excelPathway, String sheetName) throws IOException {

        workbook = new XSSFWorkbook(excelPathway);
        sheet = workbook.getSheet(sheetName);

    }


    public int getRowCount()  {
        int rowCount=0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();

        }catch (Exception e){

            System.out.println(e.getMessage());
        }
        return rowCount;
    }

    public int getColCount()  {
        int colCount=0;
        try {
    colCount = sheet.getRow(0).getPhysicalNumberOfCells();

    }catch (Exception e){
        System.out.println(e.getMessage());
    }
        return colCount;
    }

    public String getCellDataString(int rowNum, int colNum)  {
        String cellData=null;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return cellData;
    }

    public  double getCellDataNumber(int rowNum, int colNum) throws IOException {
        double cellData=0;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return cellData;
    }
}
