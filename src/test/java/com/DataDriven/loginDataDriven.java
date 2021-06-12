package com.DataDriven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class loginDataDriven {
    WebDriver driver;
    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @AfterClass
    public void tearDown(){

        driver.quit();
    }
    @DataProvider(name = "DataSet1")
    public Object[][] getData() throws IOException {
        // get the data from excel
        String path=".\\ExcelFiles\\data.xlsx";
        XLUtility xlutil=new XLUtility(path);

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalrows][totalcols];


        for(int i=1;i<=totalrows;i++) //1
        {
            for(int j=0;j<totalcols;j++) //0
            {
                loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
            }

        }

        return loginData;
    }
    @Test(dataProvider = "DataSet1")
    public void loginTest(String email, String pw, String res) {

        System.out.println(email + " " + pw);

        WebElement mail = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
        mail.clear();
        mail.sendKeys(email);

        WebElement pass = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
        pass.clear();
        pass.sendKeys(pw);

        WebElement login = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        login.click();

        String exp_title = "My Account";
        String act_title = driver.getTitle();


        if (res.equals("valid")) {
            if (exp_title.equals(act_title)) {
                System.out.println("Test is PASSED for positive test!!");
                driver.findElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]")).click();
                driver.findElement(By.xpath("//body/div[@id='common-success']/div[1]/aside[1]/div[1]/a[1]")).click();

            } else {

                System.out.println("Test is FAILED for positive test!!");

            }

        }
        if (res.equals("invalid")) {
            if (!exp_title.equals(act_title)) {

                System.out.println("Test is passed for negative test!!");


            } else {

                System.out.println("Test is failed for negative test!!");
                driver.findElement(By.xpath("//body/div[@id='account-account']/div[1]/aside[1]/div[1]/a[13]")).click();
                driver.findElement(By.xpath("//body/div[@id='common-success']/div[1]/aside[1]/div[1]/a[1]")).click();

            }
        }

    }

}

