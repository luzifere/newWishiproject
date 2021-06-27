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

public class BookingsMajorTests extends setup
{
    String stylist = "leo stylist";

    @Attachment
    @Story("DoLogin")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,groups={"sanity-group"})
    public void DoLogin() {
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillusername("wishites111@wishi.com21181");
        login.Fillpassword("123456");
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
        String expectedS = stylist;
        String actualS = bookings.StylistNameDisplayed();
        System.out.println(actualS);
        Assert.assertEquals(actualS, expectedS);
        Assert.assertTrue(bookings.CleanOutDisplayed(), "Clean not disaplayed");
        Assert.assertTrue(bookings.MiniDisplayed(),"Mini not displayed" );
        Assert.assertTrue(bookings.MajorDisplayed(),"Majot not displayed" );
        bookings.ClickMajor();
        String expectedCOMINI = "Wishi Major";
        String expectedPCMAJOR = "Major";
        String expectedPPMAJOR = "90";
        String expectedPCMINI = "Mini";
        String expectedPPMINI = "40";
        String actualCOMINI = bookings.ChatRowCODisplayed();
        String actualPCMAJOR = bookings.PlanCardMajorDisplayed();
        String actualPPMAJOR = bookings.PlanPriceMajorDisplayed();
        String actualPCMINI = bookings.PlanCardMiniDisplayed();
        String actualPPMINI = bookings.PlanPriceMiniDisplayed();
        Assert.assertEquals(expectedCOMINI, expectedCOMINI);
        Assert.assertEquals(expectedPCMINI, expectedPCMINI);
        Assert.assertEquals(expectedPPMINI, expectedPPMINI);
        Assert.assertEquals(expectedPCMAJOR, expectedPCMAJOR);
        Assert.assertEquals(expectedPPMAJOR, expectedPPMAJOR);
        bookings.SelectMajorButton();
        String expectedCHS = "YOUR ORDER SUMMARY";
        String actualCHS = bookings.CardHaederSummaryDisplayed();
        Assert.assertEquals(expectedCHS, expectedCHS);
    }
    @Attachment
    @Story("CheckOut")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4,groups={"sanity-group"})
    public void CheckOut()
    {
        BookingsPage bookings = new BookingsPage(driver);
        String expectedPP = "Wishi Major package";
        String actualCOP = bookings.MajorPacegeDisplayed();
        Assert.assertEquals(expectedPP, expectedPP);
        String expectedPPR = "90";
        String actualPPR = bookings.CleanPriceDisplayed();
        Assert.assertEquals(expectedPPR, expectedPPR);

    }
    }

