package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChatPage extends BasePage
{
    public ChatPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath="//div//form//textarea[@class='textarea']")
    WebElement Chatfield;
    @FindBy(xpath="//div[@class='desktop-send']")
    WebElement sendbutton;



    public void FillChat(String text)
    {
            filltext(Chatfield, text);
    }
    public void ClickSend ()
    {
        click(sendbutton);
    }
    
}
