package UtilitiesExcelData;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtilSECOND {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String pathway;

    public ExcelUtilSECOND(String filepath, String sheetName) throws IOException {
        workbook = new XSSFWorkbook(filepath);
        sheet = workbook.getSheet(sheetName);

    }

    public int countRows()
    {
        int rowNums= sheet.getPhysicalNumberOfRows();

        return rowNums;

    }

    public int countColums()
    {
        int colNums = sheet.getRow(0).getPhysicalNumberOfCells();

        return  colNums;

    }

    public String getCellValueString(int rowNum, int colNum)
    {
        String cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return cellValue;

    }

}
