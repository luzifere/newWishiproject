package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftPage extends BasePage
{
    public GiftPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@id='gift-card']")
    WebElement gigtcardbutton;
    @FindBy(xpath = "(//button//span)[1]")
    WebElement mini;
    @FindBy(xpath = "(//button//span)[2]")
    WebElement major;
    @FindBy(xpath = "(//button//span)[3]")
    WebElement unlimited;
    @FindBy(xpath = "//input[@placeholder='Custom']")
    WebElement custom;
    @FindBy(xpath = "//input[@placeholder='Recipient Name']")
    WebElement recipientname;
    @FindBy(xpath = "//input[@placeholder='Recipient Email']")
    WebElement recipientmail;
    @FindBy(xpath = "//input[@placeholder='Sender Name']")
    WebElement sendername;
    @FindBy(xpath = "//input[@placeholder='Sender Email']")
    WebElement sendermail;
    @FindBy(xpath = "//textarea[@placeholder='Write a personal message (optional)']")
    WebElement comment;
    @FindBy(xpath = "(//button[contains(text(), 'Continue')])[1]")
    WebElement continuebutton;
    @FindBy(xpath = "//p[@class='error custom']")
    WebElement errormessage;
    @FindBy(xpath = "(//div[@class='total row']//p)[2]")
    WebElement totalgift;
    @FindBy(xpath = "//input[@placeholder='First name']")
    WebElement firstnameCO;
    @FindBy(xpath = "//input[@placeholder='Last name']")
    WebElement lastnameCO;
    @FindBy(xpath = "//div[@class='details container-fluid']")
    WebElement detailedcontainer;
    @FindBy(xpath = "//div[@class='card-design col-sm-6 col-12']//p")
    WebElement pricecardconfirm;
    @FindBy(xpath = "//div[@class='card-design col']//p")
    WebElement pricecardpayment;
    @FindBy(xpath = "//div[@class='checkout-form container-fluid']//button")
    WebElement buybutton;



    public void ClickGiftButton() {
        WaitElementDosplayed(gigtcardbutton);
        WaitElementClicability(gigtcardbutton);
        click(gigtcardbutton);
    }
    public void ClickCustom() {
        WaitElementDosplayed(custom);
        WaitElementClicability(custom);
        click(custom);
    }
    public boolean MiniClicable() {

        try {
            WaitElementDosplayed(mini);
            WaitElementClicability(mini);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean MajorClicable() {

        try {
            WaitElementDosplayed(major);
            WaitElementClicability(major);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean unlimitedClicable() {

        try {
            WaitElementDosplayed(unlimited);
            WaitElementClicability(unlimited);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void ClickMiniButton() {
        WaitElementDosplayed(mini);
        WaitElementClicability(mini);
        click(mini);
    }
    public void ClickMajorButton() {
        WaitElementDosplayed(major);
        WaitElementClicability(major);
        click(major);
    }
    public void ClickUnlimitedButton() {
        WaitElementDosplayed(unlimited);
        WaitElementClicability(unlimited);
        click(unlimited);
    }
    public void FillCustomPrice(String text) {
        WaitElementDosplayed(custom);
        clear(custom);
        filltext(custom,text);
    }
    public String ErrorMessageDisplayed() {
        WaitElementDosplayed(errormessage);
        return getText(errormessage);
    }
    public void FillRecipientName(String text)
    {
        WaitElementDosplayed(recipientname);
        filltext(recipientname,text);
    }
    public void FillRecipientMail(String text)
    {
        WaitElementDosplayed(recipientmail);
        filltext(recipientmail,text);
    }
    public void FillComment(String text)
    {
        WaitElementDosplayed(comment);
        filltext(comment,text);
    }
    public String GetSenderName()
    {
        WaitElementDosplayed(sendername);
        return sendername.getAttribute("value");
    }
    public String GetSenderMail()
    {
        WaitElementDosplayed(sendermail);
        return sendermail.getAttribute("value");

    }
    public void ClickContinue()
    {
        WaitElementDosplayed(continuebutton);
        click(continuebutton);
    }
    public String GetTextMini()
    {
        WaitElementDosplayed(mini);
        return getText(mini);

    }
    public String GetTextmajor()
    {
        WaitElementDosplayed(major);
        return getText(major);

    }
    public String GetTextUnlimited()
    {
        WaitElementDosplayed(unlimited);
        return getText(unlimited);

    }
    public String GetTotalgiftPayment()
    {
        WaitElementDosplayed(totalgift);
        return getText(totalgift);

    }
    public String GetTextfirstname()
    {
        WaitElementDosplayed(firstnameCO);
        return firstnameCO.getAttribute("value");

    }
    public String GetTextlastname()
    {
        WaitElementDosplayed(lastnameCO);
        return lastnameCO.getAttribute("value");

    }
    public boolean GiftPageLoaded() {
        try {
            WaitElementDosplayed(detailedcontainer);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public String GetPriceCaerdCheckOut()
    {
        WaitElementDosplayed(pricecardpayment);
        return getText(pricecardpayment);

    }
    public String GetPriceCaerdConfirm()
    {
        WaitElementDosplayed(pricecardconfirm);
        return getText(pricecardconfirm);

    }
    public void ClickBuyButton() {
        WaitElementDosplayed(buybutton);
        WaitElementClicability(buybutton);
        click(buybutton);
    }
    public String GetTextCustomPrice()
    {
        WaitElementDosplayed(custom);
        return custom.getAttribute("value");

    }


}

