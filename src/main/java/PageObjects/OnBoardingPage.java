package PageObjects;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnBoardingPage extends BasePage {
    @FindBy(xpath = "//div//button[@id='intro-btn']")
    WebElement LetsGetButton;
    @FindBy(xpath = "//div//label[contains(text(), 'Female')]")
    WebElement famale;
    @FindBy(xpath = "//div//label[contains(text(), 'Male')]")
    WebElement male;
    @FindBy(xpath = "//div//label[contains(text(), 'Non Binary')]")
    WebElement neutral;
    @FindBy(xpath = "//*[@id='back']")
    WebElement backbutton;
    @FindBy(xpath = "//*[label]")
    List<WebElement> bodytype;
    @FindBy(xpath = "//*[label]")
    WebElement bodyType;
    @FindBy(xpath = "(//button[contains(text(), 'SKIP')])[1]")
    WebElement skipbutton;
    @FindBy(xpath = "(//button[contains(text(), 'NEXT')])[1]")
    WebElement nextbutton;
    @FindBy(xpath = "//label[@for='chic0']")
    WebElement hellnochic;
    @FindBy(xpath = "//label[@for='chic1']")
    WebElement somtimechic;
    @FindBy(xpath = "//label[@for='chic2']")
    WebElement loveitchic;
    @FindBy(xpath = "//label[@for='Boho0']")
    WebElement hellnoboho;
    @FindBy(xpath = "//label[@for='Boho1']")
    WebElement somtimeboho;
    @FindBy(xpath = "//label[@for='Boho2']")
    WebElement loveitboho;
    @FindBy(xpath = "//label[@for='Classic0']")
    WebElement hellnoClassic;
    @FindBy(xpath = "//label[@for='Classic1']")
    WebElement somtimeClassic;
    @FindBy(xpath = "//label[@for='Classic2']")
    WebElement loveitClassic;
    @FindBy(xpath = "//label[@for='Rock0']")
    WebElement hellnorock;
    @FindBy(xpath = "//label[@for='Rock1']")
    WebElement somtimerock;
    @FindBy(xpath = "//label[@for='Rock2']")
    WebElement loveitrock;
    @FindBy(xpath = "//label[@for='Trendy0']")
    WebElement hellnotrendy;
    @FindBy(xpath = "//label[@for='Trendy1']")
    WebElement somtimetrendy;
    @FindBy(xpath = "//label[@for='Trendy2']")
    WebElement loveittrendy;
    @FindBy(xpath = "//label[@for='streetwear0']")
    WebElement hellnostreetwear;
    @FindBy(xpath = "//label[@for='streetwear1']")
    WebElement somtimestreetwear;
    @FindBy(xpath = "//label[@for='streetwear2']")
    WebElement loveitstreetwear;
    @FindBy(xpath = "//label[@for='sexy0']")
    WebElement hellnosexy;
    @FindBy(xpath = "//label[@for='sexy1']")
    WebElement somtimesexy;
    @FindBy(xpath = "//label[@for='sexy2']")
    WebElement loveitsexy;
    @FindBy(xpath = "//label[@for='eclectic0']")
    WebElement hellnoeclectic;
    @FindBy(xpath = "//label[@for='eclectic1']")
    WebElement somtimeeclectic;
    @FindBy(xpath = "//label[@for='eclectic2']")
    WebElement loveiteclectic;
    @FindBy(xpath = "//label[@for='Tomboy0']")
    WebElement hellnotomboy;
    @FindBy(xpath = "//label[@for='Tomboy1']")
    WebElement somtimetomboy;
    @FindBy(xpath = "//label[@for='Tomboy2']")
    WebElement loveittomboy;
    @FindBy(xpath = "//label[@for='minimal0']")
    WebElement hellnominimal;
    @FindBy(xpath = "//label[@for='minimal1']")
    WebElement somtimeminimal;
    @FindBy(xpath = "//label[@for='minimal2']")
    WebElement loveitminimal;
    @FindBy(xpath = "//label[@for='Feminine0']")
    WebElement hellnofeminime;
    @FindBy(xpath = "//label[@for='Feminine1']")
    WebElement somtimefeminime;
    @FindBy(xpath = "//label[@for='Feminine2']")
    WebElement loveitfeminime;
    @FindBy(xpath = "//label[@for='streetstyle0']")
    WebElement hellnostreetstyle;
    @FindBy(xpath = "//label[@for='streetstyle1']")
    WebElement somtimestreetstyle;
    @FindBy(xpath = "//label[@for='streetstyle2']")
    WebElement loveitstreetstyle;
    @FindBy(xpath = "//label[@for='Rugged0']")
    WebElement hellnorugged;
    @FindBy(xpath = "//label[@for='Rugged1']")
    WebElement somtimerugged;
    @FindBy(xpath = "//label[@for='Rugged2']")
    WebElement loveitrugged;
    @FindBy(xpath = "//label[@for='Edgy0']")
    WebElement hellnoedgy;
    @FindBy(xpath = "//label[@for='Edgy1']")
    WebElement somtimeedgy;
    @FindBy(xpath = "//label[@for='Edgy2']")
    WebElement loveitedgy;
    @FindBy(xpath = "//label[@for='Hipster0']")
    WebElement hellnohipster;
    @FindBy(xpath = "//label[@for='Hipster1']")
    WebElement somtimehipster;
    @FindBy(xpath = "//label[@for='Hipster2']")
    WebElement loveithipster;
    @FindBy(xpath = "//label[@for='Elegant0']")
    WebElement hellnoelegant;
    @FindBy(xpath = "//label[@for='Elegant1']")
    WebElement somtimeelegant;
    @FindBy(xpath = "//label[@for='Elegant2']")
    WebElement loveitelegant;
    @FindBy(xpath = "//div//button[contains(text(), 'MEET MY MATCH')]")
    WebElement meetyoutmatch;
    @FindBy(xpath = "//div[@class='brands-list container']")
    WebElement brandslist;
    @FindBy(xpath = "(//button[@id='styling-button'])[1]")
    WebElement reversletsstart;



    public OnBoardingPage(WebDriver driver) {
        super(driver);
    }

    public void LetsGet() {
        WaitElementDosplayed(LetsGetButton);
        click(LetsGetButton);
    }

    public void SelectFamale() {
        WaitElementDosplayed(famale);
        click(famale);
    }

    public void SelectMale() {
        WaitElementDosplayed(male);
        click(male);
    }

    public void SelectNatural() {
        WaitElementDosplayed(neutral);
        click(neutral);
    }

    public void ClickBack() {
        WaitElementDosplayed(backbutton);
        click(backbutton);
    }
    public void ClickSkip() {
        WaitElementDosplayed(skipbutton);
        click(skipbutton);
    }
    public void ClickNext() {
        WaitElementDosplayed(nextbutton);
        click(nextbutton);
    }
    public void BodyTypePageLoaded() {
        WaitElementDosplayed(bodyType);
    }
    public void BrandsPageLoaded() {
        WaitElementDosplayed(brandslist);
    }

    public void SelectBodyType(String text) {
        System.out.println(text);
        System.out.println(bodytype.size());
        System.out.println(bodytype);

        for (WebElement element : bodytype) {
            //System.out.println(element);
            //System.out.println(element.getText());
            if (element.getText().toLowerCase().contains(text))
            {
                //System.out.println(element.getText());
                //System.out.println(element);
                WaitElementDosplayed(element);
                click(element);
            }
        }
    }
    public void SelectHellNoChick() {
        WaitElementDosplayed(hellnochic);
        click(hellnochic);
    }
    public void SelectSomtimeChick() {
        WaitElementDosplayed(somtimechic);
        click(somtimechic);
    }
    public void SelectLoveItChick() {
        WaitElementDosplayed(loveitchic);
        click(loveitchic);
    }
    public void SelectHellNoBoho() {
        WaitElementDosplayed(hellnoboho);
        click(hellnoboho);
    }
    public void SelectSomtimeBoho() {
        WaitElementDosplayed(somtimeboho);
        click(somtimeboho);
    }
    public void SelectLoveItBoho() {
        WaitElementDosplayed(loveitboho);
        click(loveitboho);
    }
    public void SelectHellNoClassic() {
        WaitElementDosplayed(hellnoClassic);
        click(hellnoClassic);
    }
    public void SelectSomtimeClassic() {
        WaitElementDosplayed(somtimeClassic);
        click(somtimeClassic);
    }
    public void SelectLoveItClassic() {
        WaitElementDosplayed(loveitClassic);
        click(loveitClassic);
    }
    public void SelectHellNoRock() {
        WaitElementDosplayed(hellnorock);
        click(hellnorock);
    }
    public void SelectSomtimeRock() {
        WaitElementDosplayed(somtimerock);
        click(somtimerock);
    }
    public void SelectLoveItRock() {
        WaitElementDosplayed(loveitrock);
        click(loveitrock);
    }
    public void SelectHellNoTrendy() {
        WaitElementDosplayed(hellnotrendy);
        click(hellnotrendy);
    }
    public void SelectSomtimeTrendy() {
        WaitElementDosplayed(somtimetrendy);
        click(somtimetrendy);
    }
    public void SelectLoveItTrendy() {
        WaitElementDosplayed(loveittrendy);
        click(loveittrendy);
    }
    public void SelectHellNoStreetWear() {
        WaitElementDosplayed(hellnostreetwear);
        click(hellnostreetwear);
    }
    public void SelectSomtimeStreetWear() {
        WaitElementDosplayed(somtimestreetwear);
        click(somtimestreetwear);
    }
    public void SelectLoveItStreetWear() {
        WaitElementDosplayed(loveitstreetwear);
        click(loveitstreetwear);
    }
    public void SelectHellNoSexy() {
        WaitElementDosplayed(hellnosexy);
        click(hellnosexy);
    }
    public void SelectSomtimeSexy() {
        WaitElementDosplayed(somtimesexy);
        click(somtimesexy);
    }
    public void SelectLoveItSexy() {
        WaitElementDosplayed(loveitsexy);
        click(loveitsexy);
    }
    public void SelectHellNoElectic() {
        WaitElementDosplayed(hellnoeclectic);
        click(hellnoeclectic);
    }
    public void SelectSomtimeElectic() {
        WaitElementDosplayed(somtimeeclectic);
        click(somtimeeclectic);
    }
    public void SelectLoveItElectic() {
        WaitElementDosplayed(loveiteclectic);
        click(loveiteclectic);
    }
    public void SelectHellNoTomboy() {
        WaitElementDosplayed(hellnotomboy);
        click(hellnotomboy);
    }
    public void SelectSomtimeTomboy() {
        WaitElementDosplayed(somtimetomboy);
        click(somtimetomboy);
    }
    public void SelectLoveItTomboy() {
        WaitElementDosplayed(loveittomboy);
        click(loveittomboy);
    }
    public void SelectHellNoMinimal() {
        WaitElementDosplayed(hellnominimal);
        click(hellnominimal);
    }
    public void SelectSomtimeMinimal() {
        WaitElementDosplayed(somtimeminimal);
        click(somtimeminimal);
    }
    public void SelectLoveItMinimal() {
        WaitElementDosplayed(loveitminimal);
        click(loveitminimal);
    }
    public void SelectHellNoFeminime() {
        WaitElementDosplayed(hellnofeminime);
        click(hellnofeminime);
    }
    public void SelectSomtimeFeminime() {
        WaitElementDosplayed(somtimefeminime);
        click(somtimefeminime);
    }
    public void SelectLoveItFeminime() {
        WaitElementDosplayed(loveitfeminime);
        click(loveitfeminime);
    }
    public void SelectHellNoStreetStyle() {
        WaitElementDosplayed(hellnostreetstyle);
        click(hellnostreetstyle);
    }
    public void SelectSomtimeStreetStyle() {
        WaitElementDosplayed(somtimestreetstyle);
        click(somtimestreetstyle);
    }
    public void SelectLoveItStreetStyle() {
        WaitElementDosplayed(loveitstreetstyle);
        click(loveitstreetstyle);
    }
    public void SelectHellNoRugged() {
        WaitElementDosplayed(hellnorugged);
        click(hellnorugged);
    }
    public void SelectSomtimeRugged() {
        WaitElementDosplayed(somtimerugged);
        click(somtimerugged);
    }
    public void SelectLoveItRugged() {
        WaitElementDosplayed(loveitrugged);
        click(loveitrugged);
    }
    public void SelectHellNoEdgy() {
        WaitElementDosplayed(hellnoedgy);
        click(hellnoedgy);
    }
    public void SelectSomtimeEdgy() {
        WaitElementDosplayed(somtimeedgy);
        click(somtimeedgy);
    }
    public void SelectLoveItEdgy() {
        WaitElementDosplayed(loveitedgy);
        click(loveitedgy);
    }
    public void SelectHellNoHipster() {
        WaitElementDosplayed(hellnohipster);
        click(hellnohipster);
    }
    public void SelectSomtimeHipster() {
        WaitElementDosplayed(somtimehipster);
        click(somtimehipster);
    }
    public void SelectLoveItHipster() {
        WaitElementDosplayed(loveithipster);
        click(loveithipster);
    }
    public void SelectHellNoElegant() {
        WaitElementDosplayed(hellnoelegant);
        click(hellnoelegant);
    }
    public void SelectSomtimeElegant() {
        WaitElementDosplayed(somtimeelegant);
        click(somtimeelegant);
    }
    public void SelectLoveItElegant() {
        WaitElementDosplayed(loveitelegant);
        click(loveitelegant);
    }
    public void ClickReversOnBoarding() {
        WaitElementDosplayed(reversletsstart);
        click(reversletsstart);
    }

    public void SelectBrands(String text)
    {
        String Elemet = ("//div[@id='brand_text1']");
        Elemet = Elemet.replace("text1", text);
        WebElement BrandsButton = driver.findElement(By.xpath(Elemet));
        WaitElementDosplayed(BrandsButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", BrandsButton);
        WaitElementDosplayed(BrandsButton);
        click(BrandsButton);
    }
    public void ClickMeetMatch() {
        WaitElementDosplayed(meetyoutmatch);
        click(meetyoutmatch);
    }

}

