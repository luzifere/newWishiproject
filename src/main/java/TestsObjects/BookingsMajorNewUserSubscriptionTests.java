package TestsObjects;

import PageObjects.BookingsPage;
import PageObjects.OnBoardingPage;
import PageObjects.SignUpPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class BookingsMajorNewUserSubscriptionTests extends setup
{
    String stylist = "Elad style";

    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void DoSignUp() {

        Random random = new Random();
        int number = random.nextInt(2000000 - 1000000 + 1) +1000000;
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

    }

    @Attachment
    @Story("Select Bodytype")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, groups = {"sanity-group"})
    public void SelectBodytype() {
        OnBoardingPage ob = new OnBoardingPage(driver);
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
        ob.SelectLoveItBoho();
        ob.SelectSomtimeClassic();
        ob.SelectHellNoRock();
        ob.SelectLoveItTrendy();
        ob.SelectSomtimeStreetWear();
        ob.SelectSomtimeSexy();
        ob.SelectSomtimeElectic();
        ob.SelectLoveItTomboy();
        ob.SelectSomtimeMinimal();
        ob.SelectHellNoFeminime();

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

    @Attachment
    @Story("Serch Stylist")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6,groups={"sanity-group"})
    public void SerchStylist()
    {
        BookingsPage bookings = new BookingsPage(driver);
        String stylist = this.configFileReader.getStylistName();
        bookings.SearchStylist(stylist);
        String expectedS = stylist;
        String actualS = bookings.BookStylistPageDisplayed();
        System.out.println(actualS);
        Assert.assertEquals(actualS, expectedS);
    }
    @Attachment
    @Story("Book Stylist")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 7,groups={"sanity-group"})
    public void BookStylist()
    {
        BookingsPage bookings = new BookingsPage(driver);
        bookings.ClickBookStylistButton();
        bookings.ClickBackButton();
        bookings.ClickBookStylistButton();
        String expectedS = stylist;
        String actualS = bookings.StylistNameDisplayed();
        System.out.println(actualS);
        Assert.assertEquals(actualS, expectedS);
        Assert.assertTrue(bookings.CleanOutDisplayed(), "Clean not disaplayed");
        Assert.assertTrue(bookings.MiniDisplayed(),"Mini not displayed" );
        Assert.assertTrue(bookings.MajorDisplayed(),"Majot not displayed" );
        bookings.ClickMajor();
        bookings.ClickBackButton();
        bookings.ClickMajor();
        Assert.assertTrue(bookings.MajorSelectedDisplayed(), "major not selected");
        String expectedCOMINI = "Got it! I recommend to choose Wishi Major.\n" +
                "It’s perfect for a style refresh.";
        String expectedPCMAJOR = "Major";
        String expectedPPMAJOR = "90";
        String expectedPCMINI = "Mini";
        String expectedPPMINI = "40";
        String actualCOMINI = bookings.ChatRowCODisplayed();
        String actualPCMAJOR = bookings.PlanCardMajorDisplayed();
        String actualPPMAJOR = bookings.PlanPriceMajorDisplayed();
        String actualPCMINI = bookings.PlanCardMiniDisplayed();
        String actualPPMINI = bookings.PlanPriceMiniDisplayed();
        Assert.assertEquals(actualCOMINI,expectedCOMINI);
        Assert.assertEquals(actualPCMINI,expectedPCMINI);
        Assert.assertEquals(actualPPMINI,expectedPPMINI);
        Assert.assertEquals(actualPCMAJOR,expectedPCMAJOR );
        Assert.assertEquals(actualPPMAJOR,expectedPPMAJOR );
        bookings.SelectMajorButton();
        bookings.ClickBackButton();
        bookings.SelectMajorButton();
        String expectedCHS = "YOUR ORDER SUMMARY";
        String actualCHS = bookings.CardHaederSummaryDisplayed();
        Assert.assertEquals( actualCHS,expectedCHS);
    }
    @Attachment
    @Story("CheckOut")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 8,groups={"sanity-group"})
    public void CheckOut()
    {
        BookingsPage bookings = new BookingsPage(driver);
        String expectedPP = "Wishi Major package";
        String actualPP = bookings.MajorPacegeDisplayed();
        Assert.assertEquals(actualPP,expectedPP );
        String expectedPPR = "$81";
        String actualPPR = bookings.PlanPriceDisplayed();
        Assert.assertEquals(actualPPR,expectedPPR );
        Assert.assertTrue(bookings.StartYourTrialNotClicibilety(),"startyourtrial clicibilety" );
        String cardnumber = this.configFileReader.getCardNumber();
        bookings.FillPayment(cardnumber);
        Assert.assertTrue(bookings.StartYourTrialclicibilety(),"startyourtrial not clicibilety" );
        //bookings.ClickStartYourTrialButton();
       // Assert.assertTrue(bookings.LetsGoButtonDisplayed(),"letsgo button not displayed");
    }
    }

