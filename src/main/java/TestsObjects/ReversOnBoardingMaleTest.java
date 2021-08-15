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

public class ReversOnBoardingMaleTest extends setup {




    @Attachment
    @Story("Select Famale")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void SelectMale() {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.ClickReversOnBoarding();
        ob.LetsGet();
        ob.SelectFamale();
        ob.BodyTypePageLoaded();
        ob.ClickBack();
        ob.SelectMale();

    }

    @Attachment
    @Story("Select Style")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, groups = {"sanity-group"})
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
    @Test(priority = 3, groups = {"sanity-group"})
    public void SelectBrands()
    {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.BrandsPageLoaded();
       // ob.sleep(2000);
        ob.SelectBrands("Acne Studios");
        ob.SelectBrands("A.L.C");
        ob.SelectBrands("Michael Kors");
        ob.SelectBrands("Free People");
        ob.SelectBrands("Rag & Bone");
        ob.SelectBrands("Rag & Bone");
        ob.SelectBrands("Rag & Bone");
        ob.SelectBrands("Saint Laurent");
        //ob.SelectBrands("Nanushka");
        //ob.SelectBrands("Ulla Johnson");
        //ob.SelectBrands("NILI LOTAN");
        ob.SelectBrands("Vince");

        ob.ClickMeetMatch();
    }
    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4, groups = {"sanity-group"})
    public void DoSignUp() {

        Random random = new Random();
        int number = random.nextInt(2000000 - 1000000 + 1) +1000000;
        SignUpPage sign = new SignUpPage(driver);
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
        String expected = "Your Stylists Match!";
        String actual = sign.YourStylistsMatchDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
        Assert.assertEquals(actual, expected);

    }


    }

