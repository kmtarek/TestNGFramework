package ListenersPack;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class BaseClassScreenSHOTS {

    WebDriver driver;
    public static void takeShotsFullPage(WebDriver driver, String name) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File trg = new File(System.getProperty("user.dir")+"//ScreenShots//" +name + ".png");
        FileUtils.copyFile(src, trg);
    }
public  void takeShotsELEMENT(WebDriver driver, WebElement element, String name)
{
    File src = element.getScreenshotAs(OutputType.FILE);
    File trg = new  File(System.getProperty("user.dir")+"//ScreenShots//)" +name + ".png");

}


}
