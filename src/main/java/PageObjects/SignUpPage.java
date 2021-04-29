package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div//a[contains(text(), 'Sign up')]")
    WebElement SignButton;
    @FindBy(xpath = "//div//input[@id='name']")
    WebElement FullName;
    @FindBy(xpath = "//div//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//div//input[@id='email']")
    WebElement Email;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement SignUpPUBtn;
    @FindBy(xpath = "//div//button[@class='d-none d-sm-flex btn btn-warning']")
    WebElement LetsGet;
    @FindBy(xpath = "//div[contains(text(), 'You are using invalid characters')]")
    WebElement invalid_characters;
    @FindBy(xpath = "//div[contains(text(), 'please enter a valid email address')]")
    WebElement valid_emailp;
    @FindBy(xpath = "//div[contains(text(), 'Please enter a valid email address')]")
    WebElement valid_emailP;
    @FindBy(xpath = "//div[contains(text(), 'Password must have at least 6 characters')]")
    WebElement must6characters;
    @FindBy(xpath = "//div[contains(text(), 'Please enter your last name')]")
    WebElement lastname;
    @FindBy(xpath = "//div//button[@class='close']")
    WebElement ButtonOfClosesignup;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    WebElement Warning;


    public void ClickSignUpButton() {

        ExplicityWaitIsClickable(SignButton);
    }

    public void ClickSignUpPUBtnButton() {

        ExplicityWaitIsClickable(SignUpPUBtn);
    }

    public void Clearpassword() {

        clear(password);

    }

    public void ClearFullName() {
        {
            try {
                clear(FullName);

            } catch (Exception e) {
                System.err.println("\nError : ClearFullName failed\n");
                throw e;
            }
        }


    }

    public void ClearEmail() {
        {
            try {
                clear(Email);

            } catch (Exception e) {
                System.err.println("\nError : ClearEmail failed\n");
                throw e;
            }
        }


    }

    @Step("enter password:{password}")
    public void Fillpassword(String pass) {
        {
            try {
                filltext(password, pass);

            } catch (Exception e) {
                System.err.println("\nError : Fillpassword failed\n");
                throw e;
            }
        }


    }

    @Step("enter fullname:{fullname}")
    public void FillFullName(String name) {
        {
            try {
                filltext(FullName, name);

            } catch (Exception e) {
                System.err.println("\nError : FillFullName failed\n");
                throw e;
            }
        }


    }

    @Step("enter email:{Email}")
    public void FillEmail(String email) {
        {
            try {
                filltext(Email, email);

            } catch (Exception e) {
                System.err.println("\nError : FillEmail failed\n");
                throw e;
            }
        }


    }

    public String LetsGetButtonDisplayed() {


        WaitElementDosplayed(LetsGet);
        return getText(LetsGet);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }

    public void Closebuttonofsignup() {
        ExplicityWaitIsClickable(ButtonOfClosesignup);
    }

    public String invalid_characters() {
        WaitElementDosplayed(invalid_characters);
        return getText(invalid_characters);
    }

    public String InvalidEmailP() {
        WaitElementDosplayed(valid_emailP);
        return getText(valid_emailP);
    }

    public String InvalidEmailp() {
        WaitElementDosplayed(valid_emailp);
        return getText(valid_emailp);
    }

    public String must6characters() {
        WaitElementDosplayed(must6characters);
        return getText(must6characters);
    }


    public String lastname() {
        WaitElementDosplayed(lastname);
        return getText(lastname);


    }

    public String namemaycontain1() {
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='invalid-feedback']"));
        System.out.println(list.size());

        for (WebElement elements : list) {
            WaitElementDosplayed(elements);
            String elementtext = elements.getText();
            if (elementtext.contains("name may only contain letters")) {
                return elementtext;
            }


        }

        return null;
    }

    public String namemaycontain() {

        String text = null;
        {
            WaitElementDosplayed(Warning);
            if (Warning.getText().contains("name may only contain letters")) {
                WaitElementDosplayed(Warning);
                text = getText(Warning);
                System.out.println(text);
            }
        }
        return text;
    }
}








