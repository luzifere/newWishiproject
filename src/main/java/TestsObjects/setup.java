package TestsObjects;

import dataProvider.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import utilitis.Listener;

import java.util.concurrent.TimeUnit;

@Listeners(Listener.class)
public class setup
{
    WebDriver driver;
    protected ConfigFileReader configFileReader;



    @BeforeClass (groups = {"sanity-group"})
    protected void setupCapability(ITestContext testContext) {
        configFileReader= new ConfigFileReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        testContext.setAttribute("WebDriver", this.driver);
        //driver.get("https://qa.wishi.me/");
        driver.get(configFileReader.getApplicationUrl());
        RestAssured.baseURI = "https://api-stage.wishi.me/api/slim/";
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json").build();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
