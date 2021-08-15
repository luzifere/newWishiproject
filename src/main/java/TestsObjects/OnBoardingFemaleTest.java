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

public class OnBoardingFemaleTest extends setup {


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
        ob.SelectMale();
        ob.ClickBack();
        ob.SelectFamale();
        ob.BodyTypePageLoaded();

    }

    @Attachment
    @Story("Select Bodytype")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, groups = {"sanity-group"})
    public void SelectBodytype() {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.ClickSkip();
        ob.ClickBack();
        ob.SelectBodyType("petite");
        ob.SelectBodyType("fit");
        ob.SelectBodyType("tall");
        ob.SelectBodyType("petite");
        ob.ClickNext();
    }
    @Attachment
    @Story("Select Bodytype")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4, groups = {"sanity-group"})
    public void SelctStyle() {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.SelectHellNoChick();
        ob.ClickBack();
        ob.SelectLoveItChick();
        ob.SelectLoveItBoho();
        ob.ClickBack();
        ob.SelectHellNoBoho();
        ob.SelectSomtimeClassic();
        ob.ClickBack();
        ob.SelectLoveItClassic();
        ob.SelectHellNoRock();
        ob.ClickBack();
        ob.SelectSomtimeRock();
        ob.SelectLoveItTrendy();
        ob.ClickBack();
        ob.SelectHellNoTrendy();
        ob.SelectSomtimeStreetWear();
        ob.ClickBack();
        ob.SelectLoveItStreetWear();
        ob.ClickSkip();
        ob.ClickBack();
        ob.SelectSomtimeSexy();
        ob.SelectSomtimeElectic();
        ob.ClickBack();
        ob.SelectHellNoElectic();
        ob.SelectLoveItTomboy();
        ob.ClickBack();
        ob.SelectSomtimeTomboy();
        ob.SelectSomtimeMinimal();
        ob.ClickBack();
        ob.SelectHellNoMinimal();
        ob.SelectHellNoFeminime();
        ob.ClickBack();
        ob.SelectLoveItFeminime();
    }
    @Attachment
    @Story("Select Brands")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5, groups = {"sanity-group"})
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
        ob.SelectBrands("Nanushka");
        ob.SelectBrands("Ulla Johnson");
        ob.SelectBrands("NILI LOTAN");
        ob.SelectBrands("Vince");
        ob.ClickMeetMatch();
        String expected = "Your Stylists Match!";
        SignUpPage sign= new SignUpPage(driver);
        String actual = sign.YourStylistsMatchDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
    }


    }

