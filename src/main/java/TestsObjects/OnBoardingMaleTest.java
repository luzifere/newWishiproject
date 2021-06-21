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

public class OnBoardingMaleTest extends setup {


    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void DoSignUp() {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName("test test");
        sign.ClearEmail();
        String newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile + number);
        //sign.FillEmail("wishitestyinon@wishitest.com" + number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String expected = "LET'S GET STYLING";
        String actual = sign.LetsGetButtonDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual, expected);

    }

    @Attachment
    @Story("Select Famale")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, groups = {"sanity-group"})
    public void SelectFamale() {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.LetsGet();
        ob.SelectFamale();
        ob.BodyTypePageLoaded();
        ob.ClickBack();
        ob.SelectMale();
    }

    @Attachment
    @Story("Select Bodytype")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, groups = {"sanity-group"})
    public void SelctStyle() {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.SelectHellNoStreetStyle();
        ob.ClickBack();
        ob.SelectLoveItStreetStyle();
        ob.SelectLoveItRugged();
        ob.ClickBack();
        ob.SelectHellNoRugged();
        ob.SelectLoveItEdgy();
        ob.ClickBack();
        ob.SelectSomtimeEdgy();
        ob.SelectLoveItHipster();
        ob.ClickBack();
        ob.SelectLoveItHipster();
        ob.SelectSomtimeElegant();
        ob.ClickBack();
        ob.SelectSomtimeElegant();
    }
    @Attachment
    @Story("Select Brands")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4, groups = {"sanity-group"})
    public void SelectBrands()
    {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.BrandsPageLoaded();
        ob.SelectBrands("Vince");
        ob.SelectBrands("Acne Studios");
        ob.SelectBrands("A.L.C");
        ob.SelectBrands("Michael Kors");
        ob.SelectBrands("Free People");
        ob.SelectBrands("Rag & Bone");
        ob.SelectBrands("Rag & Bone");
        ob.SelectBrands("Rag & Bone");
        ob.SelectBrands("Saint Laurent");
        ob.ClickMeetMatch();
    }


    }
