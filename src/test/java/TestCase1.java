import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestCase1 {

public  WebDriver driver;

@Test
public void setDriver()
{
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//resources//chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://demo.opencart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
}
@Test(priority = 1)
public void register() throws InterruptedException {
    WebElement myAcctt = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
    myAcctt.click();
    WebElement rgr = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
    //Actions actions = new Actions(driver);
    //actions.moveToElement(myAcctt).moveToElement(rgr).click().perform();
    Thread.sleep(3000);
    rgr.click();
    Thread.sleep(3000);
}
@Test(priority = 2)
public void  sendData() throws IOException {
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//resources//data.properties");
    Properties pr = new Properties();
    pr.load(fis);

    WebElement fname = driver.findElement(By.xpath("//input[@id='input-firstname']"));
    fname.sendKeys(pr.getProperty("FirstName"));

    WebElement lname = driver.findElement(By.xpath("//input[@id='input-lastname']"));
    lname.sendKeys(pr.getProperty("LastName"));

    WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
    email.sendKeys(pr.getProperty("email"));

    WebElement tel = driver.findElement(By.xpath("//input[@id='input-telephone']"));
    tel.sendKeys(pr.getProperty("telephone"));

    WebElement pw = driver.findElement(By.xpath("//input[@id='input-password']"));
    pw.sendKeys(pr.getProperty("password"));

    WebElement pwc = driver.findElement(By.xpath("//input[@id='input-confirm']"));
    pwc.sendKeys(pr.getProperty("password"));

    WebElement rButtonY = driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
    rButtonY.click();

    WebElement chkBox = driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
    chkBox.click();

    WebElement cont = driver.findElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
    cont.submit();

    String acTitle = driver.getTitle();
    String expTitle = "Your Account Has Been Created!";
    if (acTitle.equals(expTitle)) {
        System.out.println("Title Verified");
    } else {

        System.out.println("Title Verified failed");
    }


}
    @Test(priority = 3)
    public void tearDown()
{
    driver.quit();
}

}
