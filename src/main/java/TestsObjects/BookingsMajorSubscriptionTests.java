package TestsObjects;

import PageObjects.BookingsPage;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingsMajorSubscriptionTests extends setup
{
    String stylist = "Elad style";

    @Attachment
    @Story("DoLogin")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,groups={"sanity-group"})
    public void DoLogin() {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        String username = this.configFileReader.getnewusermaile();
        login.Fillusername(username);
        String password = this.configFileReader.getpassword();
        login.Fillpassword(password);
        login.Clickloginbuttonn();
        login.LoginSucceeded();
        BookingsPage bookings = new BookingsPage(driver);
        bookings.ClickStylistButton();
    }
    @Attachment
    @Story("Serch Stylist")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2,groups={"sanity-group"})
    public void SerchStylist()
    {
        SignUpPage sign = new SignUpPage(driver);
        String expected = "Your Stylists Match!";
        String actual = sign.YourStylistsMatchDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
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
    @Test(priority = 3,groups={"sanity-group"})
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
    @Test(priority = 4,groups={"sanity-group"})
    public void CheckOut()
    {
        BookingsPage bookings = new BookingsPage(driver);
        String expectedPP = "Wishi Major package";
        String actualPP = bookings.MajorPacegeDisplayed();
        Assert.assertEquals(actualPP,expectedPP );
        String expectedPPR = "$81";
        String actualPPR = bookings.PlanPriceDisplayed();
        Assert.assertEquals(actualPPR,expectedPPR );
       // Assert.assertTrue(bookings.StartYourTrialNotClicibilety(),"startyourtrial clicibilety" );
        Assert.assertTrue(bookings.StartYourTrialclicibilety(),"startyourtrial not clicibilety" );
        //bookings.ClickComplateBooking();
        //Assert.assertTrue(bookings.LetsGoButtonDisplayed(),"letsgo button not displayed");
    }
    }

