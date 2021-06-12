import ListenersPack.BaseClassScreenSHOTS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//@Listeners(ListenersPack.ListenersBase.class)

public class TestLogin {

    WebDriver driver;

    @Test(priority = 0, groups = {"sanity"})
    @Parameters({"browser"})
    public  void login(String browser) {

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        }else if(browser.equalsIgnoreCase("Firefox")){

            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//resources//geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        }

        driver.get("https://demo.opencart.com/");

    }
    @Test(priority = 1, groups = {"regression"})
    public void secondTry()
    {
        WebElement my = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        my.click();

        WebElement log = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
        log.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        email.sendKeys("kmtarekfca@yahoo.com");

        WebElement pw = driver.findElement(By.xpath("//input[@id='input-password']"));
        pw.sendKeys("12345");

        WebElement login = driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        login.click();

        try {
            BaseClassScreenSHOTS.takeShotsFullPage(driver,"new image");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test(priority = 2, groups = {"sanity"})
    public void hoverToMP3(){

        WebElement mp3= driver.findElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[8]/a[1]"));
        WebElement item22 = driver.findElement(By.xpath("//a[contains(text(),'test 22 (0)')]"));

        Actions actions= new Actions(driver);
        actions.moveToElement(mp3).moveToElement(item22).click().build().perform();

    }

    @Test(priority = 3, groups = {"regression", "sanity"})
    public void regression(){

        System.out.println("This is a regression & sanity test");


    }

}
