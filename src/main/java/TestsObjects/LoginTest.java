package TestsObjects;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObjects.LoginPage;
import utilitis.Listener;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)
@Epic("Login")
@Feature("do login")
public class LoginTest extends setup {
    String expectedPR = "Password is required";
    String expectedER = "Email is required";
    String expectedPI = "The password you entered is incorrect";
    String expected1IE = "Invalid email";


    @Story("Fill pass without fill email")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void FillPasswordWithOutToFillEmail()
    {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillpassword("156523784");
        login.Clickloginbuttonn();
        String actual = login.EmaileRequired();
        Assert.assertEquals(actual, expectedER);
        login.Closebuttonoflogin();
    }

    @Attachment
    @Story("Fill Email WithOut To Fill Password")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, groups = {"sanity-group"})
    public void FillEmailWithOutToFillPassword()
    {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillusername("yinon@wishi.me");
        login.Clickloginbuttonn();
        String actual = login.PasswordRequired();
        Assert.assertEquals(actual, expectedPR);
        login.Closebuttonoflogin();
    }
    @Attachment
    @Story("ClickLoginwWithOutToFillAnyFields")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3,groups={"sanity-group"})
    public void ClickLoginwWithOutToFillAnyFields()
    {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Clickloginbuttonn();
        String actual = login.EmaileRequired();
        Assert.assertEquals(actual, expectedER);
        String actualP = login.PasswordRequired();
        Assert.assertEquals(actualP, expectedPR);
        login.Closebuttonoflogin();
    }
    @Attachment
    @Story("FillCorrectEmailWithWrongPassword")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4,groups={"sanity-group"})
    public void FillCorrectEmailWithWrongPassword()
    {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillusername("plan@wishitest.com");
        login.Fillpassword("123123123");
        login.Clickloginbuttonn();
        String actual = login.PasswordIncorrect();
        Assert.assertEquals(actual, expectedPI);
        login.Closebuttonoflogin();
    }
    @Attachment
    @Story("FillCorrectPasswordWithWrongEmail")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5,groups={"sanity-group"})
    public void FillCorrectPasswordWithWrongEmail()
    {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillusername("jhfgjhfjf@wishi.me");
        login.Fillpassword("156523784");
        login.Clickloginbuttonn();
        String actual = login.InvalidEmail();
        Assert.assertEquals(actual, expected1IE);
        login.Closebuttonoflogin();

    }
    @Attachment
    @Story("FillCorrectPasswordWithWrongEmail")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6,groups={"sanity-group"})
    public void FillCorrectPasswordWithHebLettersEmail()
    {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillusername("ששששש@wishi.me");
        login.Fillpassword("156523784");
        login.Clickloginbuttonn();
        String actual = login.InvalidEmail();
        Assert.assertEquals(actual, expected1IE);
        login.Closebuttonoflogin();

    }
    @Attachment
    @Story("FillCorrectPasswordWithWrongEmail")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 7,groups={"sanity-group"})
    public void DoLogin()
    {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillusername("wishi.test@wishi.com");
        login.Fillpassword("123456");
        login.Clickloginbuttonn();
        login.LoginSucceeded();
    }
}
