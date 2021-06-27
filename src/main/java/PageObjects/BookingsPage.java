package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;


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
    @FindBy(xpath = "(//div[contains(text(), 'leo stylist')])[1]")
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
    @FindBy(xpath = "//div[@class='price-summary row']//div[contains(text(), '$')]")
    WebElement planprice;


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
    public void ClickCleanOut()
    {
        WaitElementDosplayed(cleanout);
        click(cleanout);

    }
    public void ClickMini()
    {
        WaitElementDosplayed(mini);
        click(mini);
    }
    public void ClickMajor()
    {
        WaitElementDosplayed(major);
        click(major);
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

}
