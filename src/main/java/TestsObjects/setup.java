package TestsObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class setup
{
    WebDriver driver;

    @BeforeClass (groups = {"sanity-group"})
    public void testing()
    {
        //System.setProperty("webdriver.chrome.driver", "/Users/yinonwishi/Desktop/CromeDriver/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://qa.wishi.me/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Point point = new Point(0, -1000);
        driver.manage().window().setPosition(point);
        Dimension dimension = new Dimension(1600, 1200);
        driver.manage().window().setSize(dimension);

        // driver.manage().window().maximize();

    }
    @AfterClass (groups = {"sanity-group"})
    public void close()
    {
        driver.close();
    }
}
