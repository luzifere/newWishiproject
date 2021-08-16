package TestsObjects;

import PageObjects.BookingsPage;
import PageObjects.GiftPage;
import PageObjects.OnBoardingPage;
import PageObjects.SignUpPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class BookGiftCardCustomTest extends setup
{
    String newusermaile;
    int number;
    String firstname= "yinon";
    String lastname= "Wishi";
    String pricecard;
    String custom;


    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
    public void DoSignUp() {

        Random num = new Random();
          int number = num.nextInt(2000000 - 1000000 + 1) + 1000000;
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName(firstname+" "+lastname);
        sign.ClearEmail();
        this.newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile + number);
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
    public void SelectGift() {
        GiftPage gift = new GiftPage(driver);
        gift.ClickGiftButton();
        gift.GiftPageLoaded();
        gift.MiniClicable();
        gift.MajorClicable();
        gift.unlimitedClicable();
        gift.ClickMajorButton();
        gift.ClickMiniButton();
        gift.ClickCustom();
       gift.FillCustomPrice("1000");
        this.custom = gift.GetTextCustomPrice();
        gift.FillRecipientName("Yinon");
        gift.FillRecipientMail("Yinon@wishi.me");
        String expected = firstname +" "+ lastname;
        String actual = gift.GetSenderName();
        System.out.println(actual);
        Assert.assertEquals(actual, expected);
        String expectedmail = this.newusermaile + number;
        String actualmail = gift.GetSenderMail();
        System.out.println(actualmail);
        Assert.assertEquals(actualmail, expectedmail);
        gift.FillComment("coment test");
        gift.ClickContinue();

    }
    @Attachment
    @Story("Check Out")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 8,groups={"sanity-group"})
    public void CheckOut()
    {
        GiftPage gift = new GiftPage(driver);
        String totalgift = gift.GetTotalgiftPayment().substring(1);
        String pricecardCO = gift.GetPriceCaerdCheckOut().substring(1);
        Assert.assertEquals(custom, totalgift);
        Assert.assertEquals(custom, pricecardCO);
        String firstnameCO = gift.GetTextfirstname();
        String lastnameCO = gift.GetTextlastname();
        Assert.assertEquals(firstnameCO, firstname);
        Assert.assertEquals(lastnameCO, lastname);
        String cardnumber = this.configFileReader.getCardNumber();
        BookingsPage bookings = new BookingsPage(driver);
        bookings.FillPayment(cardnumber);
        gift.ClickBuyButton();
        String pricecardConfirm = gift.GetPriceCaerdConfirm().substring(1);
        Assert.assertEquals(pricecardCO, pricecardConfirm);
    }



        /*
        Assert.assertEquals(actualS, expectedS);
        Assert.assertTrue(bookings.CleanOutDisplayed(), "Clean not disaplayed");
        Assert.assertTrue(bookings.MiniDisplayed(),"Mini not displayed" );
        Assert.assertTrue(bookings.MajorDisplayed(),"Majot not displayed" );
        bookings.ClickCleanOut();
        bookings.ClickBackButton();
        bookings.ClickCleanOut();
        String expectedCO = "Got it! I recommend to choose Wishi Major.\n" +
                "It’s perfect for a closet clean out.";
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
        Assert.assertTrue(bookings.ComplatBookingNotClicibilety(),"Complate Booking clicibilety" );
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
        //bookings.ClickComplateBooking();
        //Assert.assertTrue(bookings.LetsGoButtonDisplayed(),"letsgo button not displayed");

         */
    }


