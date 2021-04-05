package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage
{
    @FindBy(xpath = "//a[text()[contains(.,'Log in')]]")
    WebElement btnLogin;
    @FindBy(xpath="//div//input[@id='password']")
    WebElement password;
    @FindBy(xpath="//div//input[@id='email']")
    WebElement userName;
    @FindBy(xpath="//div//button[@id='submit']")
    WebElement LoginButtonOfModel;
    @FindBy(xpath="//div[text()[contains(.,'Email is required')]]")
    WebElement EmaileRequired;
    @FindBy(xpath="//div//button[@class='close']")
    WebElement ButtonOfCloseLogin;
    @FindBy(xpath="//div[text()[contains(.,'Password is required')]]")
    WebElement PasswordRequired;

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }


    public void ClickLoginButton ()
        {
            {
                try {
                    //click(btnLogin);
                    ExplicityWaitIsClickable(btnLogin);

                } catch (Exception e) {
                    System.err.println("\nError : ClickLoginButton failed\n");
                    throw e;
                }
            }


        }
    public void Clearpassword()
    {
        {
            try

            {
                clear(password);

            }
            catch(Exception e)
            {
                System.err.println("\nError : Clearpassword failed\n");
                throw e;
            }
        }


    }
    public void Clearusername()
    {
        {
            try

            {
                clear(userName);

            }
            catch(Exception e)
            {
                System.err.println("\nError : Clearusername failed\n");
                throw e;
            }
        }


    }
    @Step("enter password:{password}")
    public void Fillpassword(String pass)
    {
        {
            try

            {
                filltext(password, pass);

            }
            catch(Exception e)
            {
                System.err.println("\nError : Fillpassword failed\n");
                throw e;
            }
        }


    }

    public void Clickloginbuttonn()
    {
        {
            try

            {
                click(LoginButtonOfModel);

            }
            catch(Exception e)
            {
                System.err.println("\nError : Clickloginbuttonn failed\n");
                throw e;
            }
        }


    }
    public String EmaileRequired()
    {

        {
            {
                try

                {
                    return getText(EmaileRequired);
                    //Assert.assertTrue(ElementDisplay(EmaileRequired));

                }
                catch(Exception e)
                {
                    System.err.println("\nError : EmaileRequired failed\n");
                    throw e;
                }
            }


        }
    }

    public String PasswordRequired()
    {

        {
            {
                try

                {
                    return getText(PasswordRequired);


                }
                catch(Exception e)
                {
                    System.err.println("\nError : EmaileRequired failed\n");
                    throw e;
                }
            }


        }
    }
    public void Closebuttonoflogin()
    {
        {
            try

            {
                click(ButtonOfCloseLogin);

            }
            catch(Exception e)
            {
                System.err.println("\nError : Closebuttonoflogin failed\n");
                throw e;
            }
        }


    }
    @Step("enter name:{name}")
    public void Fillusername(String user)
    {
        {
            try

            {
                filltext(userName, user);

            }
            catch(Exception e)
            {
                System.err.println("\nError : Fillusername failed\n");
                throw e;
            }
        }


    }


}

