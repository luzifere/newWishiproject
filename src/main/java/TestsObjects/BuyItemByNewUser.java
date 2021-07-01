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

    @Attachment
    @Story("DoLogin")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1,groups={"sanity-group"})
    public void DoLogin() {
        /*
        LoginPage login = new LoginPage(driver);
        login.ClickLoginButton();
        login.Clearpassword();
        login.Clearusername();
        login.Fillusername("wishites111@wishi.com21181");
        login.Fillpassword("123456");
        login.Clickloginbuttonn();
        login.LoginSucceeded();

         */
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
        feed.FillFirstName("Yinon");
        feed.FillLastName("test");
        feed.SelectCountry(35);
        feed.SelectCountry(41);
        feed.FillAddress("tel-aviv");
        feed.FillApt("valy");
        feed.FillCity("rishon le zoin");
        feed.SelectState(47);
        feed.FillPOstalCode("65465465");
        feed.FillPhoneNumber("546546546546");
    }
    @Attachment
    @Story("Place oreder")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 7,groups={"sanity-group"})
    public void PlaceOreder()
    {
        Feed feed = new Feed(driver);
        float total = (float) (pricecheckout*1.1);
        this.totalprice = Float.parseFloat(feed.GetTotalPriceCheckOut().substring(1));
        Assert.assertEquals(this.totalprice,total);
        String cardnumber = this.configFileReader.getCardNumber();
        BookingsPage bookings = new BookingsPage(driver);
        bookings.FillPayment(cardnumber);
        Assert.assertTrue(feed.PlaceOrderButtonclicibilety(),"checkout button not clickable");
    }

}
