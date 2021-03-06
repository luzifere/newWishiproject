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

public class BookingsCOTests extends setup
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
        bookings.ClickCleanOut();
        bookings.ClickBackButton();
        bookings.ClickCleanOut();
        String expectedCO = "Got it! I recommend to choose Wishi Major.\n" +
                "It???s perfect for a closet clean out.";
        String expectedPC = "Major";
        String expectedPP = "90";
        String actualCO = bookings.ChatRowCODisplayed();
        String actualPC = bookings.PlanCardCleanOutDisplayed();
        String actualPP = bookings.PlanPriceMajorDisplayed();
        Assert.assertEquals(actualCO,expectedCO );
        Assert.assertEquals(actualPC,expectedPC );
        Assert.assertEquals(actualPP,expectedPP );
        bookings.SelectMajorButton();
        bookings.ClickBackButton();
        bookings.SelectMajorButton();
       // Assert.assertTrue(bookings.ComplatBookingNotClicibilety(),"Complate Booking clicibilety" );
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
        String expectedCOP = "Closet clean out package";
        String actualCOP = bookings.CleanPacegeDisplayed();
        Assert.assertEquals(actualCOP,expectedCOP );
        String expectedCOPR = "$90";
        String actualCOPR = bookings.PlanPriceDisplayed();
        Assert.assertEquals(actualCOPR,expectedCOPR );
        bookings.ClickAddCode();
        bookings.FilleCoupon("Wishitest");
        bookings.ClickSubmit();
        String expectedPPR0 = "0";
        String actualPPR0 = bookings.PlanPriceDisplayed();
        Assert.assertEquals(expectedPPR0, expectedPPR0);
        Assert.assertTrue(bookings.ComplatBookingclicibilety(),"Complate Booking not clicibilety" );
       // bookings.ClickComplateBooking();
       // Assert.assertTrue(bookings.LetsGoButtonDisplayed(),"letsgo button not displayed");
    }
    }

