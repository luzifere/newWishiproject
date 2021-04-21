package TestsObjects;

import PageObjects.SignUpPage;
import io.qameta.allure.*;
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
    @Attachment
    @Story("Do correct signup")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = {"sanity-group"})
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
        sign.FillEmail("wishitestyinon@wishitest.com" + number);
        sign.Clearpassword();
        sign.Fillpassword("123456");
        sign.ClickSignUpPUBtnButton();
        String expected = "LET'S GET STYLING";
        String actual = sign.LetsGetButtonDisplayed();
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
        Assert.assertEquals(actual,expected);
    }
    @Test(priority = 3,groups={"sanity-group"})
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

