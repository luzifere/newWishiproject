package TestsObjects;

import PageObjects.SignUpPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilitis.Listener;

import java.util.Random;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)

@Epic("SignUp")
public class SignUpTest extends setup
{
    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void DoSignUp()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter<=10000000;counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test test");
        sign.ClearEmail();
        sign.FillEmail("wishitestyinon@wishitest.com" + number);
        sign.Clearpassword();
        sign.Fillpassword("123456");
        sign.ClickSignUpPUBtnButton();
        String expected = "LET'S GET STYLING";
        String actual = sign.LetsGetButtonDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actual,expected);





    }

}

