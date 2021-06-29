package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.FindBy;

public class BookingsPage extends BasePage
{
    public BookingsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='search-box']")
    WebElement searchbar;
    @FindBy(xpath = "//input[@id='search-box-input']")
    WebElement textfield;
    @FindBy(xpath = "(//div//a[contains(text(), 'Stylists')])[2]")
    WebElement stylistbutton;
    @FindBy(xpath = "//div//button[@id='book']")
    WebElement bookstylistbutton;
    @FindBy(xpath = "(//div[contains(text(), 'Elad style')])[1]")
    WebElement stylistname;
    @FindBy(xpath = "//div[@class='name row']")
    WebElement stylistnameplan;
    @FindBy(xpath = "//div//label[@for='closet_cleanout']")
    WebElement cleanout;
    @FindBy(xpath = "//div//label[@for='mini']")
    WebElement mini;
    @FindBy(xpath = "//div//label[@for='major']")
    WebElement major;
    @FindBy(xpath = "//div[@class='chat-row row']")
    WebElement chatrowCOut;
    @FindBy(xpath = "(//div[@class='card-header'])[1]")
    WebElement plancardmini;
    @FindBy(xpath = "(//div[@class='card-header'])[2]")
    WebElement plancardmajor;
    @FindBy(xpath = "//div[@class='card-header']")
    WebElement plancardcleanout;
    @FindBy(xpath = "(//div[@class='price'][contains(text(), '40')])[1]")
    WebElement planpricemini;
    @FindBy(xpath = "(//div[@class='price'][contains(text(), '90')])[1]")
    WebElement planpricemajor;
    @FindBy(xpath = "(//div//button[contains(text(), 'Select Wishi Major')])[1]")
    WebElement selectmajor;
    @FindBy(xpath = "(//div//button[contains(text(), 'Select Wishi Mini')])[1]")
    WebElement selectmini;
    @FindBy(xpath = "//div[@class='card-header'][contains(text(), 'YOUR ORDER SUMMARY')]")
    WebElement cardheadersummary;
    @FindBy(xpath = "//div[@class='col'][contains(text(), 'Closet clean out package')]")
    WebElement cleanoutpackage;
    @FindBy(xpath = "//div[@class='col'][contains(text(), 'Wishi Mini package')]")
    WebElement minipackage;
    @FindBy(xpath = "//div[@class='col'][contains(text(), 'Wishi Major package')]")
    WebElement majorpackage;
    @FindBy(xpath = "(//div[@class='price-summary bold row']//div[contains(text(), '$')])[1]")
    WebElement planprice;
    @FindBy(xpath = "(//button[@class='btn btn-dark'][contains(text(), 'Select Wishi Major')])[1]")
    WebElement majorselected;
    @FindBy(xpath = "(//button[@class='btn btn-dark'][contains(text(), 'Select Wishi Mini')])[1]")
    WebElement miniselected;
    @FindBy(xpath = "//div//a[@class='add-code']")
    WebElement addcode;
    @FindBy(xpath = "//div[@class='promotion-code show row']//div//input[@type='text']")
    WebElement inputcode;
    @FindBy(xpath = "//div[@class='promotion-code show row']//div//button[@type='button']")
    WebElement submit;
    @FindBy(xpath = "//div//button[contains(text(), 'complete booking')]")
    WebElement complatebooking;
    @FindBy(xpath = "//div//button[contains(text(), 'Start your free trial')]")
    WebElement startyourtrial;
    @FindBy(xpath = "(//div[@class='col'])[10]")
    WebElement paymentField;
    @FindBy(css = "[name='cardnumber']")
    WebElement CCfield;
    @FindBy(xpath = "//div[@class='back-btn no-text']")
    WebElement backbutton;
    @FindBy(xpath = "//div[@class='radio-button horizontal dark dot  form-check']")
    WebElement onetime;
    @FindBy(xpath = "//div[@class='radio-button horizontal dark dot checked form-check']")
    WebElement monthly;
    @FindBy(xpath = "//a[@id='LetsGoQuiz']")
    WebElement letsgo;



    public void SearchStylist (String text)
    {
        WaitElementDosplayed(searchbar);
        click(searchbar);
        sleep(1000);
        filltext(textfield,text);
        sleep(1000);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        WaitElementDosplayed(stylistname);
    }
    public void ClickStylistButton()
    {
        WaitElementDosplayed(stylistbutton);
        click(stylistbutton);
    }
    public void ClickBookStylistButton()
    {
        WaitElementDosplayed(bookstylistbutton);
       WaitElementClicability(bookstylistbutton);
        click(bookstylistbutton);
    }
    public String BookStylistPageDisplayed() {
        WaitElementDosplayed(stylistname);
        return getText(stylistname);
    }

    public String StylistNameDisplayed() {
        WaitElementDosplayed(stylistnameplan);
        return getText(stylistnameplan);
    }
    public boolean CleanOutDisplayed() {

        try {
            WaitElementDosplayed(cleanout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean MiniDisplayed() {
        try {
            WaitElementDosplayed(mini);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean MajorDisplayed()
    {

        try {
            WaitElementDosplayed(major);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean MajorSelectedDisplayed()
    {

        try {
            WaitElementDosplayed(majorselected);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean MiniSelectedDisplayed()
    {

        try {
            WaitElementDosplayed(miniselected);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public void ClickCleanOut()
    {
        WaitElementDosplayed(cleanout);
        WaitElementClicability(cleanout);
        click(cleanout);
        WaitElementDosplayed(majorselected);


    }
    public void ClickMini()
    {
        WaitElementDosplayed(mini);
        click(mini);
        WaitElementDosplayed(selectmini);
    }
    public void ClickMajor()
    {
        WaitElementDosplayed(major);
        click(major);
        WaitElementDosplayed(selectmajor);
    }
    public String ChatRowCODisplayed() {
        WaitElementDosplayed(chatrowCOut);
        return getText(chatrowCOut);
    }
    public String PlanCardMiniDisplayed() {
        WaitElementDosplayed(plancardmini);
        return getText(plancardmini);
    }
    public String PlanPriceMiniDisplayed() {
        WaitElementDosplayed(planpricemini);
        return getText(planpricemini);
    }
    public String PlanCardMajorDisplayed() {
        WaitElementDosplayed(plancardmajor);
        return getText(plancardmajor);
    }
    public String PlanPriceMajorDisplayed() {
        WaitElementDosplayed(planpricemajor);
        return getText(planpricemajor);
    }
    public String PlanCardCleanOutDisplayed() {
        WaitElementDosplayed(plancardcleanout);
        return getText(plancardcleanout);
    }
    public void SelectMajorButton()
    {
        WaitElementDosplayed(selectmajor);
        WaitElementClicability(selectmajor);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectmajor);
        click(selectmajor);
    }
    public void SelectMiniButton()
    {
        WaitElementDosplayed(selectmini);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectmini);
        click(selectmini);
    }
    public String CardHaederSummaryDisplayed() {
        WaitElementDosplayed(cardheadersummary);
        return getText(cardheadersummary);
    }
    public String CleanPacegeDisplayed() {
        WaitElementDosplayed(cleanoutpackage);
        return getText(cleanoutpackage);
    }
    public String MiniPacegeDisplayed() {
        WaitElementDosplayed(minipackage);
        return getText(minipackage);
    }
    public String MajorPacegeDisplayed() {
        WaitElementDosplayed(majorpackage);
        return getText(majorpackage);
    }
    public String CleanPriceDisplayed() {
        WaitElementDosplayed(planprice);
        return getText(planprice);
    }
    public void ClickAddCode()
    {
        WaitElementDosplayed(addcode);
        click(addcode);
    }
    public void FilleCoupon(String text)
    {
        WaitElementDosplayed(inputcode);
        filltext(inputcode,text);
    }
    public void ClickSubmit()
    {
        WaitElementDosplayed(submit);
        click(submit);
        WaitElementClicability(complatebooking);
    }
    public boolean ComplatBookingNotClicibilety()
    {
        try {
            WaitElementNotClicability(complatebooking);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean StartYourTrialNotClicibilety()
    {
        try {
            WaitElementNotClicability(startyourtrial);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public boolean ComplatBookingclicibilety()
    {
        try {
            WaitElementClicability(complatebooking);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean StartYourTrialclicibilety()
    {
        try {
            WaitElementDosplayed(startyourtrial);
            WaitElementClicability(startyourtrial);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void ClickComplateBooking()
    {
        WaitElementDosplayed(complatebooking);
        click(complatebooking);
    }
    public void ClickStartYourTrialButton()
    {
        WaitElementDosplayed(startyourtrial);
        click(startyourtrial);
    }
    public void ClickBackButton()
    {
       WaitElementDosplayed(backbutton);
        click(backbutton);
    }
    public void SelectOneTime()
    {
        WaitElementDosplayed(onetime);
        click(onetime);
        sleep(1000);
        WaitElementDosplayed(addcode);
        WaitElementClicability(addcode);
    }
    public void SelectMonthly()
    {
        WaitElementDosplayed(monthly);
        click(monthly);
        WaitElementDosplayed(addcode);
        WaitElementClicability(addcode);
    }

    public void Switch_to_strype ()
    {
        WebElement fr = driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(fr);

    }
    public void FillPayment(String text)
    {
        click(paymentField);
        Switch_to_strype();
        //click(paymentField);
        filltext(CCfield,text);
        driver.switchTo().defaultContent();
    }
    public boolean LetsGoButtonDisplayed()
    {
        try {
            WaitElementClicability(letsgo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
