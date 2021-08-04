package TestsObjects;

import PageObjects.BookingsPage;
import PageObjects.Feed;
import PageObjects.LoginPage;
import PageObjects.SignUpPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class BuyItemByNewUser extends setup
{
    float priceitem;
    float pricecheckout;
    float totalprice;
    String firstname ="Yinon";
    String lastname ="test";
    String address ="tel-aviv";
    String apt ="valy";
    String city ="rishon le zoin";
    String postal ="65465465";
    String phone ="546546546546";

    @Attachment
    @Story("DoLogin")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,groups={"sanity-group"})
    public void OpenFeed()
    {
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
    @Story("Select Item")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 3,groups={"sanity-group"})
    public void SelectItem()
    {
        Feed feed = new Feed(driver);
        feed.SelectItem();
        this.priceitem = Float.parseFloat(feed.GetPriceItem().substring(1));
        Assert.assertTrue(feed.ItemRowDisplayed(),"item row not displayed");
        Assert.assertTrue(feed.CheckOutButtonNotClicibilety(),"checkout button clickable");
    }
    @Attachment
    @Story("Select Size")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 4,groups={"sanity-group"})
    public void SelectSize() {
        Feed feed = new Feed(driver);
        feed.SelectSize();
        Assert.assertTrue(feed.CheckOutButtonclicibilety(), "checkout button not clickable");
        feed.ClickCheckOut();
    }
    @Attachment
    @Story("signup")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 5,groups={"sanity-group"})
    public void Signup()
    {
        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
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
        Feed feed = new Feed(driver);
        Assert.assertTrue(feed.CheckOutPageDispalyed(),"checkout page not displayed");
        this.pricecheckout = Float.parseFloat(feed.GetPriceCheckOut().substring(1));
        Assert.assertEquals(this.priceitem,pricecheckout);
    }
    @Attachment
    @Story("Select Size")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 6,groups={"sanity-group"})
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
    @Test(priority = 7,groups={"sanity-group"})
    public void PlaceOreder()
    {
        Feed feed = new Feed(driver);
        int total = (int) Math.round(pricecheckout*1.1);
        this.totalprice = Float.parseFloat(feed.GetTotalPriceCheckOut().substring(1));
        Assert.assertEquals(this.totalprice,total);
        BookingsPage bookings = new BookingsPage(driver);
        String cardnumber = this.configFileReader.getCardNumber();
        bookings.FillPayment(cardnumber);
        Assert.assertTrue(feed.PlaceOrderButtonclicibilety(),"checkout button not clickable");
        feed.ClickPlaceOrder();
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
