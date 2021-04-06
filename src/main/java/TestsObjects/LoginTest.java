package TestsObjects;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObjects.LoginPage;

@Listeners(TestsObjects.Listener.class)
@Epic("Login")
@Feature("do login")
public class LoginTest extends setup
{
       @Attachment
       @Story("Fill pass without fill email")
       @Severity(SeverityLevel.NORMAL)
       @Test(priority = 3, groups = {"sanity-group"})
        public void FillPasswordWithOutToFillEmail() {
            LoginPage login = new LoginPage(driver);
            login.ClickLoginButton();
            login.Clearpassword();
            login.Clearusername();
            login.Fillpassword("156523784");
            login.Clickloginbuttonn();
            String expected = "Email is required";
            String actual = login.EmaileRequired();
           Assert.assertEquals(actual,expected);
        }
    @Attachment
    @Story("Fill Email WithOut To Fill Password")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4,groups={"sanity-group"})
    public void FillEmailWithOutToFillPassword()
    {
        LoginPage login = new LoginPage(driver);
        login.Closebuttonoflogin();
        login.ClickLoginButton();
        login.Fillusername("yinon@wishi.me");
        login.Clickloginbuttonn();
        String expected = "Password is required";
        String actual = login.PasswordRequired();
        Assert.assertEquals(actual,expected);
    }
    }
