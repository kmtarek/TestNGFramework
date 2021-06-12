package Utilities;

import java.io.IOException;

public class ExcelUtilDemo {
    public static void main(String[] args) throws IOException {

        String pathway = System.getProperty("user.dir");
        ExcelUtil excel = new ExcelUtil(pathway+"//ExcelFiles//data.xlsx", "Sheet1");
        excel.getRowCount();
        excel.getColCount();
        excel.getCellDataString(1,0);
        excel.getCellDataString(1,1);
    }
}
