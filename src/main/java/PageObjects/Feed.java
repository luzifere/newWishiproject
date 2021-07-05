package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Feed extends BasePage
{
    public Feed(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//a[contains(text(), 'Feed')])[1]")
    WebElement feed;
    @FindBy(xpath = "//div[@class='feed container-fluid']")
    WebElement feedcontainer;
    @FindBy(xpath = "(//div[@class='prices'])[2]")
    WebElement priceitem;
    @FindBy(xpath = "(//div[contains(text(), 'Subtotal (1 item)')]/following-sibling::div[@class='col'])[1]")
    WebElement pricecheckout;
    @FindBy(xpath = "(//div[@class='feed-item type-look container']//div[@class='col'])[1]")
    WebElement outfit;
    @FindBy(xpath = "(//div[@class='outfit row'])[1]")
    WebElement outfitsrow;
    @FindBy(xpath = "(//div[@class='item'])[1]")
    WebElement item;
    @FindBy(xpath = "//div[@class='item row']")
    WebElement itemrow;
    @FindBy(xpath = "//div[@class='sizes']")
    WebElement sizedropdwon;
    @FindBy(xpath = "//select[@class='form-control']")
    WebElement selectclass;
    @FindBy(xpath = "//button[contains(text(), 'Check out')]")
    WebElement checkoutbutton;
    @FindBy(xpath = "//div[contains(text(), 'Check out')]")
    WebElement checkoutpage;
    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstname;
    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastname;
    @FindBy(xpath = "//div[@class='country']")
    WebElement countrybutton;
    @FindBy(xpath = "//select[@id='country']")
    WebElement selectcountry;
    @FindBy(xpath = "//input[@id='line1']")
    WebElement address;
    @FindBy(xpath = "//input[@id='line2']")
    WebElement apt;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//div[@class='state']")
    WebElement state;
    @FindBy(xpath = "//select[@id='state']")
    WebElement selectstate;
    @FindBy(xpath = "//input[@id='postal_code']")
    WebElement postalcode;
    @FindBy(xpath = "//input[@type='tel']")
    WebElement phone;
    @FindBy(xpath = "(//div[@class='total row']//div[@class='col'])[2]")
    WebElement totalprice;
    @FindBy(xpath = "(//button[contains(text(), 'Place order')])[1]")
    WebElement placeorderbutton;
    @FindBy(xpath = "//h1[contains(text(), 'Thank you for your order.')]")
    WebElement thankyou;
    @FindBy(xpath = "(//div[@class='billing-details']//p)[2]")
    WebElement detailes1;
    @FindBy(xpath = "(//div[@class='billing-details']//p)[3]")
    WebElement detailes2;
    @FindBy(xpath = "(//div[@class='billing-details']//p)[4]")
    WebElement detailes3;
    @FindBy(xpath = "(//div[@class='billing-details']//p)[1]")
    WebElement firsdetailes1;
    @FindBy(xpath = "(//div[@class='billing-details']//p)[2]")
    WebElement firsdetailes2;
    @FindBy(xpath = "(//div[@class='billing-details']//p)[3]")
    WebElement firsdetailes3;
    @FindBy(xpath = "//div[@class='edit-btn']")
    WebElement editdetailedbutton;



    public void ClickFeedButton()
{
    WaitElementDosplayed(feed);
    click(feed);
}
    public boolean FeedContainerDisplayed() {

        try {
            WaitElementDosplayed(feedcontainer);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public  void SelectLook()
    {
        sleep(1500);
        WaitElementDosplayed(outfit);
        WaitElementClicability(outfit);
        click(outfit);
    }
    public boolean OutfitRowDisplayed() {

        try {
            WaitElementDosplayed(outfitsrow);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public  void SelectItem()
    {
        WaitElementDosplayed(item);
        click(item);
    }
    public boolean ItemRowDisplayed() {

        try {
            WaitElementDosplayed(itemrow);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void SelectSize()
    {
        WaitElementDosplayed(sizedropdwon);
        click(sizedropdwon);
        WaitElementDosplayed(selectclass);
        SelectOptions(selectclass,2);
    }
    public void ClickCheckOut()
    {
        WaitElementDosplayed(checkoutbutton);
        WaitElementClicability(checkoutbutton);
        click(checkoutbutton);
    }
    public boolean CheckOutButtonNotClicibilety()
    {
        try {
            WaitElementNotClicability(checkoutbutton);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean CheckOutButtonclicibilety()
    {
        try {
            WaitElementClicability(checkoutbutton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean CheckOutPageDispalyed()
    {
        try {
            WaitElementDosplayed(checkoutpage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void FillFirstName(String text)
    {
        WaitElementDosplayed(firstname);
        clear(firstname);
        sleep(1000);
        filltext(firstname,text);
    }

    public void FillLastName(String text)
    {
        WaitElementDosplayed(lastname);
        clear(lastname);
        sleep(1000);
        filltext(lastname,text);
    }
    public void SelectCountry(int text)
    {
        WaitElementDosplayed(countrybutton);
        WaitElementClicability(countrybutton);
        click(countrybutton);
        SelectOptions(selectcountry,text);
    }
    public void FillAddress(String text)
    {
        WaitElementDosplayed(address);
        clear(address);
        sleep(1000);
        filltext(address,text);
    }
    public void FillApt(String text)
    {
        WaitElementDosplayed(apt);
        clear(apt);
        sleep(1000);
        filltext(apt,text);
    }
    public void FillCity(String text)
    {
        WaitElementDosplayed(city);
        clear(city);
        sleep(1000);
        filltext(city,text);
    }
    public void SelectState(int text)
    {
        WaitElementDosplayed(state);
        WaitElementClicability(state);
        click(state);
        SelectOptions(selectstate,text);
    }
    public void FillPOstalCode(String text)
    {
        WaitElementDosplayed(postalcode);
        clear(postalcode);
        sleep(1000);
        filltext(postalcode,text);
    }
    public void FillPhoneNumber(String text)
    {
        WaitElementDosplayed(phone);
        clear(phone);
        sleep(1500);
        filltext(phone,text);
    }
    public String GetPriceItem() {
        WaitElementDosplayed(priceitem);
        return getText(priceitem);
    }
    public String GetPriceCheckOut() {
        WaitElementDosplayed(pricecheckout);
        return getText(pricecheckout);
    }
    public String GetTotalPriceCheckOut() {
        WaitElementDosplayed(totalprice);
        return getText(totalprice);
    }
    public boolean PlaceOrderButtonNotClicibilety()
    {
        try {
            WaitElementNotClicability(placeorderbutton);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean PlaceOrderButtonclicibilety()
    {
        try {
            WaitElementClicability(placeorderbutton);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public  void ClickPlaceOrder()
    {
        WaitElementDosplayed(placeorderbutton);
        click(placeorderbutton);
    }
    public String ThankYouForYourOrderDisplayed()
    {
        WaitElementDosplayed(thankyou);
        return getText(thankyou);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }
    public String NameCODisplayed()
    {
        WaitElementDosplayed(detailes1);
        return getText(detailes1);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }
    public String CityCODisplayed()
    {
        WaitElementDosplayed(detailes2);
        return getText(detailes2);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }
    public String LastDetailesCODisplayed()
    {
        WaitElementDosplayed(detailes3);
        return getText(detailes3);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }
    public String FirstNameCODisplayed()
    {
        WaitElementDosplayed(firsdetailes1);
        return getText(firsdetailes1);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }
    public String FirstCityCODisplayed()
    {
        WaitElementDosplayed(firsdetailes2);
        return getText(firsdetailes2);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }
    public String FirstLastDetailesCODisplayed()
    {
        WaitElementDosplayed(firsdetailes3);
        return getText(firsdetailes3);
        //Assert.assertTrue(ElementDisplay(EmaileRequired));
    }
    public void ClickEditDetailed()
    {
        WaitElementDosplayed(editdetailedbutton);
        click(editdetailedbutton);
    }

}
