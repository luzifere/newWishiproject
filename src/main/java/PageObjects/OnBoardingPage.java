package PageObjects;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
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

    public void BodyTypePageLOaded() {
        WaitElementDosplayed(bodyType);
    }

    public void SelectBodyType(String text) {
        System.out.println(text);
        System.out.println(bodytype.size());
        System.out.println(bodytype);

        for (WebElement element : bodytype) {
            System.out.println(element);
            System.out.println(element.getText());
            if (element.getText().toLowerCase().contains(text))
            {
                System.out.println(element.getText());
                System.out.println(element);
                WaitElementDosplayed(element);
                click(element);
                sleep(1000);
            }
        }
    }
}

