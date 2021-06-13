package TestsObjects;

import PageObjects.OnBoardingPage;
import PageObjects.SignUpPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class OnBoardingTest extends setup {



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
        String newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile+ number);
        //sign.FillEmail("wishitestyinon@wishitest.com" + number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String expected = "LET'S GET STYLING";
        String actual = sign.LetsGetButtonDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actual,expected);

    }
    @Attachment
    @Story("Select Famale")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, groups = {"sanity-group"})
    public void SelectFamale()
    {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.LetsGet();
        ob.SelectMale();
        ob.ClickBack();
        ob.SelectFamale();
        ob.BodyTypePageLOaded();
        ob.SelectBodyType("petite");
    }
}
