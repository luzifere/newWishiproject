package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage
{
    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//div//a[contains(text(), 'Sign up')]")
    WebElement SignButton;
    @FindBy(xpath="//div//input[@id='name']")
    WebElement FullName;
    @FindBy(xpath="//div//input[@id='password']")
    WebElement password;
    @FindBy(xpath="//div//input[@id='email']")
    WebElement Email;
    @FindBy(xpath="//button[@id='submit']")
    WebElement SignUpPUBtn;
    @FindBy(xpath="//div//button[@class='d-none d-sm-flex btn btn-warning']")
    WebElement LetsGet;

    public void ClickSignUpButton  ()
    {
        {
            try {
                //click(btnLogin);
                ExplicityWaitIsClickable(SignButton);

            } catch (Exception e) {
                System.err.println("\nError : ClickSignButton failed\n");
                throw e;
            }
        }


    }
    public void ClickSignUpPUBtnButton  ()
    {
        {
            try {
                //click(btnLogin);
                ExplicityWaitIsClickable(SignUpPUBtn);

            } catch (Exception e) {
                System.err.println("\nError : ClickSignUpPUBtn failed\n");
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
    public void ClearFullName()
    {
        {
            try

            {
                clear(FullName);

            }
            catch(Exception e)
            {
                System.err.println("\nError : ClearFullName failed\n");
                throw e;
            }
        }


    }
    public void ClearEmail()
    {
        {
            try

            {
                clear(Email);

            }
            catch(Exception e)
            {
                System.err.println("\nError : ClearEmail failed\n");
                throw e;
            }
        }


    }
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
    public void FillFullName(String name)
    {
        {
            try

            {
                filltext(FullName, name);

            }
            catch(Exception e)
            {
                System.err.println("\nError : FillFullName failed\n");
                throw e;
            }
        }


    }
    public void FillEmail(String email)
    {
        {
            try

            {
                filltext(Email , email);

            }
            catch(Exception e)
            {
                System.err.println("\nError : FillEmail failed\n");
                throw e;
            }
        }


    }
    public String LetsGetButtonDisplayed()
    {

        {
            {
                try

                {
                    return getText(LetsGet);
                    //Assert.assertTrue(ElementDisplay(EmaileRequired));

                }
                catch(Exception e)
                {
                    System.err.println("\nError : LetsGetButtonDisplayed failed\n");
                    throw e;
                }
            }


        }
    }

}
