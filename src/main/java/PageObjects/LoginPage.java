package PageObjects;

import io.qameta.allure.Step;
import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[text()[contains(.,'Log in')]]")
    WebElement btnLogin;
    @FindBy(xpath = "//div//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//div//input[@id='email']")
    WebElement userName;
    @FindBy(xpath = "//div//button[@id='submit']")
    WebElement LoginButtonOfModel;
    @FindBy(xpath = "//div[text()[contains(.,'Email is required')]]")
    WebElement EmaileRequired;
    @FindBy(xpath = "//div//button[@class='close']")
    WebElement ButtonOfCloseLogin;
    @FindBy(xpath = "//div[text()[contains(.,'Password is required')]]")
    WebElement PasswordRequired;
    @FindBy(xpath = "//div[text()[contains(.,'The password you entered is incorrect')]]")
    WebElement PasswordIncorrect;
    @FindBy(xpath = "//div[text()[contains(.,'Invalid email')]]")
    WebElement InvalidEmail;
    @FindBy(xpath = "//div[text()[contains(.,'Inbox')]]")
    WebElement inbox;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void ClickLoginButton() {
        {
            ExplicityWaitIsClickable(btnLogin);
        }
    }

    public void Clearpassword() {
        clear(password);
    }


    public void Clearusername() {
        clear(userName);
    }

    @Step("enter password:{password}")
    public void Fillpassword(String pass) {
        filltext(password, pass);
    }

    public void Clickloginbuttonn() {
        ExplicityWaitIsClickable(LoginButtonOfModel);
    }

    public String EmaileRequired() {
        WaitElementDosplayed(EmaileRequired);
        return getText(EmaileRequired);
    }

    public String PasswordRequired() {
        WaitElementDosplayed(PasswordRequired);
        return getText(PasswordRequired);
    }

    public String PasswordIncorrect() {
       //sleep(1500);
        WaitElementDosplayed(PasswordIncorrect);
        return getText(PasswordIncorrect);
    }

    public String InvalidEmail() {
        WaitElementDosplayed(InvalidEmail);
        return getText(InvalidEmail);
    }

    public void Closebuttonoflogin() {
        ExplicityWaitIsClickable(ButtonOfCloseLogin);
    }

    @Step("enter name:{name}")
    public void Fillusername(String user) {
        {
            filltext(userName, user);
        }
    }
    public void LoginSucceeded(){
        WaitElementDosplayed(inbox);



    }


}

