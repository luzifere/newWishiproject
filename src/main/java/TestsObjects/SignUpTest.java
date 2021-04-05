package TestsObjects;

import PageObjects.BasePage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;
@Epic("SignUp")
public class SignUpTest extends setup
{
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

    }

}
