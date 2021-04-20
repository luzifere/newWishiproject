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
    String expected = "Password is required";
    String expected1 = "Email is required";

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
        Assert.assertEquals(actual, expected1);
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
        login.Fillusername("yinon@wishi.me");
        login.Clickloginbuttonn();
        String actual = login.PasswordRequired();
        Assert.assertEquals(actual, expected);
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
        login.Clickloginbuttonn();
        String actual = login.EmaileRequired();
        Assert.assertEquals(actual, expected1);
        String actualP = login.PasswordRequired();
        Assert.assertEquals(actualP, expected);
        login.Closebuttonoflogin();

    }
}
