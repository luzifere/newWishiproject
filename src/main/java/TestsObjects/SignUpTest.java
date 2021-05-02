package TestsObjects;

import PageObjects.SignUpPage;
import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilitis.Listener;

import java.util.Random;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)

@Epic("SignUp")
public class SignUpTest extends setup

{
    String expectedLN = "Please enter your last name";
    String expectedIC = "You are using invalid characters";
    String expectedM6C = "Password must have at least 6 characters";
    String expectedIE = "Please enter a valid email address";
    String expectedIEp = "please enter a valid email address";
    String expectedMC = "name may only contain letters, whitespace, and the ' or - special characters";

    @Story("Fill Email Witout Shtudel")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2,groups={"sanity-group"})
    public void FillEmailWitoutShtudel()
    {
        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test test");
        sign.ClearEmail();
        sign.FillEmail("wishitestyinonwishitest.com" + number);
        sign.Clearpassword();
        sign.Fillpassword("123456");
        sign.ClickSignUpPUBtnButton();
        String actual = sign.InvalidEmailP();
        Assert.assertEquals(actual, expectedIE);
        sign.Closebuttonofsignup();


    }
    @Story("Fill Email Without Dot Com")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3,groups={"sanity-group"})
    public void FillEmailWithoutDotCom()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test test");
        sign.ClearEmail();
        sign.FillEmail("wishitest@yinonwishitestcom" + number);
        sign.Clearpassword();
        sign.Fillpassword("123456");
        sign.ClickSignUpPUBtnButton();
        String actual = sign.InvalidEmailp();
        Assert.assertEquals(actual, expectedIEp);
        sign.Closebuttonofsignup();

    }
    @Story("Fill Pssword With Lessthan 6 Characters")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4,groups={"sanity-group"})
    public void FillPsswordWithLessthan6Characters()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test test");
        sign.ClearEmail();
        String newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile+ number);
        sign.Clearpassword();
        sign.Fillpassword("12345");
        sign.ClickSignUpPUBtnButton();
        String actual = sign.must6characters();
        Assert.assertEquals(actual, expectedM6C);
        sign.Closebuttonofsignup();

    }
    @Story("Fill Mail With Special Carecters")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5,groups={"sanity-group"})
    public void FillMailWithSpecialCarecters()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test test");
        sign.ClearEmail();
        sign.FillEmail("!@#$%@nwishitest.com" + number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String actual = sign.invalid_characters();
        Assert.assertEquals(actual, expectedIC);
        sign.Closebuttonofsignup();

    }
    @Story("Fill Mail With Hebrew Carecters")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6,groups={"sanity-group"})
    public void FillMailWithHebrewCarecters()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test test");
        sign.ClearEmail();
        sign.FillEmail("aדגגכדכ@stme.sdf" + number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String actual = sign.InvalidEmailp();
        Assert.assertEquals(actual, expectedIEp);
        sign.Closebuttonofsignup();

    }
    @Story("Fill Name With Special Carecters")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7,groups={"sanity-group"})
    public void FillNameWithSpecialCarecters()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "!@#$% test");
        String newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile+ number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String actual = sign.invalid_characters();
        Assert.assertEquals(actual, expectedIC);
        sign.Closebuttonofsignup();

    }
    @Story("Fill Name With Hebrew Carecters")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8,groups={"sanity-group"})
    public void FillNameWithHebrewCarecters()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "יוני test");
        String newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile+ number);
        //sign.FillEmail("wishitestyinon@wishitest.com" + number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String actual = sign.namemaycontain();
        Assert.assertEquals(actual, expectedMC);
        sign.Closebuttonofsignup();

    }
    @Story("Fill Name WithOut Last Name")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9,groups={"sanity-group"})
    public void FillNameWithOutLastName()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test");
        String newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile+ number);
        //sign.FillEmail("wishitestyinon@wishitest.com" + number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String actual = sign.lastname();
        Assert.assertEquals(actual, expectedLN);
        sign.Closebuttonofsignup();

    }
    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10, groups = {"sanity-group"})
    public void DoSignUp()
    {

        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter<=10000000;counter++)
            number = num.nextInt(700000);
        SignUpPage sign = new SignUpPage(driver);
        sign.ClickSignUpButton();
        sign.ClearFullName();
        sign.FillFullName( "test test");
        sign.ClearEmail();
        String newusermaile = this.configFileReader.getnewusermaile();
        sign.FillEmail(newusermaile+ number);
        //sign.FillEmail("wishitestyinon@wishitest.com" + number);
        sign.Clearpassword();
        String password = this.configFileReader.getpassword();
        sign.Fillpassword(password);
        sign.ClickSignUpPUBtnButton();
        String expected = "LET'S GET STYLING";
        String actual = sign.LetsGetButtonDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actual,expected);
    }
    @Story("Create User")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11,groups={"sanity-group"})
    public void CreateUser()

    {
        Random num = new Random();
        int number = 1000000;
        for (int counter = 5800000; counter <= 10000000; counter++)
            number = num.nextInt(700000);
        String uuid = given()
                .body("""
                        {
                        "email":"freez+700@wishitest.me""" + number + """
                        ","full_name":"nadav Carmel",
                        "first_name":"Erased",
                        "last_name":"Caramel",
                        "password":"q1w2easd3r4!"
                        }
                        """)
                .when().log().all()
                .post("https://api-stage.wishi.me/api/slim/user/signup/email")
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().path("user_uuid");
        System.out.println("uuid is " + uuid);
        String post = "https://api-stage.wishi.me/api/slim/user/" + uuid;
        System.out.println("api getUser is  " + post);
        given()
                .when()
                .log()
                .all()
                .get(post)
                .then().log().all()
                .statusCode(200);
    }

}

