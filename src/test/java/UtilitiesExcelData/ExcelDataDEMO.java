package UtilitiesExcelData;

import java.io.IOException;

public class ExcelDataDEMO {

    public static void main(String[] args) throws IOException {

        String halfPath = System.getProperty("user.dir");
        ExcelUtilSECOND dataExcel = new ExcelUtilSECOND(halfPath+"//ExcelFiles//data.xlsx", "Sheet1");
        dataExcel.countRows();
        dataExcel.countColums();

        String data = dataExcel.getCellValueString(1, 0);
        System.out.println(data);

    }
}
