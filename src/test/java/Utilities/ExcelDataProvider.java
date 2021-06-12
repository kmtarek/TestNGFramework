package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExcelDataProvider {

    WebDriver driver;

    @BeforeTest
    public  void setDriver()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @Test(dataProvider = "TestData1")
    public  void test1(String email, String pw) throws InterruptedException {

        System.out.println(email + " || " +pw);

        WebElement mail= driver.findElement(By.name("email"));
        mail.sendKeys(email);

        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys(pw);

        Thread.sleep(3000);
        mail.clear();
        pass.clear();
    }

    @DataProvider(name = "TestData1")
    public Object[][] getData() throws IOException {

        String excelPath= "C://Users//Asus//IdeaProjects//TestNGframework//ExcelFiles//data.xlsx";

        Object data[][] = TestExcelData(excelPath, "Sheet1");
        return data;


    }

public  static Object[][] TestExcelData(String pathway, String SheetName) throws IOException {

    ExcelUtil excel = new ExcelUtil(pathway, SheetName);

    int rowCount = excel.getRowCount();
    int colCount = excel.getColCount();

    Object data[][] = new Object[rowCount-1][colCount];

    for(int i=1; i<rowCount; i++){
        for(int j=0; j<colCount; j++){

            String cellData = excel.getCellDataString(i, j);
            //System.out.print(cellData);
            data[i-1][j] = cellData;

        }
        //System.out.println();
    }
    return data;
}

}
