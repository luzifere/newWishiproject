package TestsObjects;

import PageObjects.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class BuyItemByNewUserFromCart extends setup
{
    int priceitem;
    int pricecheckout;
    int totalprice;
    String firstname ="Yinon";
    String lastname ="test";
    String address ="tel-aviv";
    String apt ="valy";
    String city ="rishon le zoin";
    String postal ="65465465";
    String phone ="546546546546";
    int cartcount;
    int shopbuttons;
    int counter= 0;


    @Attachment
    @Story("DoLogin")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,groups={"sanity-group"})
    public void openFeed() {

        Feed feed = new Feed(driver);
        feed.ClickFeedButton();
        Assert.assertTrue(feed.FeedContainerDisplayed(),"feed container not displayed");
    }
    @Attachment
    @Story("Select Look")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2,groups={"sanity-group"})
    public void SelectLook()
    {
        Feed feed = new Feed(driver);
        feed.SelectLook();
        Assert.assertTrue(feed.OutfitRowDisplayed(),"outfits row not displayed");
    }
    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3, groups = {"sanity-group"})
    public void DoSignUp()
    {
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
    @Test(priority = 4, groups = {"sanity-group"})
    public void SelectFamale() {
        OnBoardingPage ob = new OnBoardingPage(driver);
        ob.LetsGet();
        ob.SelectFamale();
        ob.BodyTypePageLoaded();

    }

    @Attachment
    @Story("Select Bodytype")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5, groups = {"sanity-group"})
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
    @Test(priority = 6, groups = {"sanity-group"})
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
    @Test(priority = 7, groups = {"sanity-group"})
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
        Feed feed = new Feed(driver);
        feed.ClickFeedButton();
    }

    @Attachment
    @Story("Select Item")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 8,groups={"sanity-group"})
    public void SelectItem()
    {

        Feed feed = new Feed(driver);
        feed.SelectLook();
        Assert.assertTrue(feed.OutfitRowDisplayed(),"outfits row not displayed");
        feed.AddToCart(0);
        this.counter++;
        feed.AddToCart(0);
        this.counter++;
        this.cartcount= Integer.parseInt(feed.CounterOfTheCart());
       // Assert.assertEquals(cartcount,counter);
        feed.OpenCart();
        this.shopbuttons= (feed.NumOfShopButtons());
        Assert.assertEquals(cartcount,shopbuttons);
        feed.ShopCartButton(0);

    }
    @Attachment
    @Story("Select Size")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 9,groups={"sanity-group"})
    public void SelectSize() {
        Feed feed = new Feed(driver);
        this.priceitem = (int) Float.parseFloat(feed.GetPriceItem().substring(1));
        Assert.assertTrue(feed.ItemRowDisplayed(),"item row not displayed");
        Assert.assertTrue(feed.CheckOutButtonNotClicibilety(),"checkout button clickable");
        feed.SelectSize();
        Assert.assertTrue(feed.CheckOutButtonclicibilety(), "checkout button not clickable");
        feed.ClickCheckOut();
        Assert.assertTrue(feed.CheckOutPageDispalyed(),"checkout page not displayed");
        this.pricecheckout = (int) Float.parseFloat(feed.GetPriceCheckOut().substring(1));
        Assert.assertEquals(this.priceitem,pricecheckout);
    }
    @Attachment
    @Story("Select Size")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 10,groups={"sanity-group"})
    public void FillDetails() {
        Feed feed = new Feed(driver);
        Assert.assertTrue(feed.PlaceOrderButtonNotClicibilety(), "place oreder button clickable");
        feed.FillFirstName(firstname);
        feed.FillLastName(lastname);
        feed.SelectCountry(35);
        feed.SelectCountry(41);
        feed.FillAddress(address);
        feed.FillApt(apt);
        feed.FillCity(city);
        feed.SelectState(47);
        feed.FillPOstalCode(postal);
        feed.FillPhoneNumber(phone);
    }


    @Attachment
    @Story("Place oreder")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 11,groups={"sanity-group"})
    public void PlaceOreder()
    {
        Feed feed = new Feed(driver);
        Assert.assertTrue(feed.PlaceOrderButtonNotClicibilety(),"checkout button not clickable");
        int total = (int) Math.round(pricecheckout*1.1);
        this.totalprice = (int) Float.parseFloat(feed.GetTotalPriceCheckOut().substring(1));
        Assert.assertEquals(this.totalprice,total);
        String cardnumber = this.configFileReader.getCardNumber();
        BookingsPage bookings = new BookingsPage(driver);
        bookings.FillPayment(cardnumber);
        Assert.assertTrue(feed.PlaceOrderButtonclicibilety(),"checkout button not clickable");
        feed.ClickPlaceOrder();
        String expectedTY = "Thank you for your order.";
        this.counter--;
        String actualTY = feed.ThankYouForYourOrderDisplayed();
        System.out.println(actualTY);
        Assert.assertEquals(actualTY,expectedTY);
        String expected = firstname+" "+lastname;
        String actual = feed.NameCODisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        String expected1 = address;
        String actual1 = feed.CityCODisplayed();
        System.out.println(actual1);
        Assert.assertEquals(actual1,expected1);
        String expected2 = city+", WA "+postal;
        String actual2 = feed.LastDetailesCODisplayed();
        System.out.println(actual2);
        Assert.assertEquals(actual2,expected2);
        feed.ClickFeedButton();
        this.cartcount= Integer.parseInt(feed.CounterOfTheCart());
       // Assert.assertEquals(cartcount,counter);
        feed.OpenCart();
        this.shopbuttons= (feed.NumOfShopButtons());
        Assert.assertEquals(cartcount,shopbuttons);
        feed.ShopCartButton(0);

    }
    @Attachment
    @Story("Select Size")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 12,groups={"sanity-group"})
    public void SelectSizenextitem() {
        Feed feed = new Feed(driver);
        this.priceitem = (int) Float.parseFloat(feed.GetPriceItem().substring(1));
        Assert.assertTrue(feed.ItemRowDisplayed(),"item row not displayed");
        Assert.assertTrue(feed.CheckOutButtonNotClicibilety(),"checkout button clickable");
        feed.SelectSize();
        Assert.assertTrue(feed.CheckOutButtonclicibilety(), "checkout button not clickable");
        feed.ClickCheckOut();
        Assert.assertTrue(feed.CheckOutPageDispalyed(),"checkout page not displayed");
        this.pricecheckout = (int) Float.parseFloat(feed.GetPriceCheckOut().substring(1));
        Assert.assertEquals(this.priceitem,pricecheckout);
    }

    @Attachment
    @Story("Select Size")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 13,groups={"sanity-group"})
    public void ValidateDetailsnextItem() {
        Feed feed = new Feed(driver);
        String expected = firstname+" "+lastname;
        String actual = feed.FirstNameCODisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        String expected1 = address+" "+apt;
        String actual1 = feed.FirstCityCODisplayed();
        System.out.println(actual1);
        Assert.assertEquals(actual1,expected1);
        String expected2 = city+", WA "+postal;
        String actual2 = feed.FirstLastDetailesCODisplayed();
        System.out.println(actual2);
        Assert.assertEquals(actual2,expected2);

    }
    @Attachment
    @Story("Place oreder")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 14,groups={"sanity-group"})
    public void PlaceOrederNextItem()
    {
        Feed feed = new Feed(driver);
        Assert.assertTrue(feed.PlaceOrderButtonclicibilety(),"checkout button not clickable");
        int total = (int) Math.round(pricecheckout*1.1);
        this.totalprice = (int) Float.parseFloat(feed.GetTotalPriceCheckOut().substring(1));
        Assert.assertEquals(this.totalprice,total);
        feed.ClickPlaceOrder();
        this.counter--;
        String expectedTY = "Thank you for your order.";
        String actualTY = feed.ThankYouForYourOrderDisplayed();
        System.out.println(actualTY);
        Assert.assertEquals(actualTY,expectedTY);
        String expected = firstname+" "+lastname;
        String actual = feed.NameCODisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        String expected1 = address;
        String actual1 = feed.CityCODisplayed();
        System.out.println(actual1);
        Assert.assertEquals(actual1,expected1);
        String expected2 = city+", WA "+postal;
        String actual2 = feed.LastDetailesCODisplayed();
        System.out.println(actual2);
        Assert.assertEquals(actual2,expected2);
    }


}
