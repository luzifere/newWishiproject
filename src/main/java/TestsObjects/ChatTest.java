package TestsObjects;

import PageObjects.LoginPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilitis.Listener;

@Listeners(Listener.class)
public class ChatTest extends setup
{
    @Attachment
    @Story("DoLogin")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,groups={"sanity-group"})
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
