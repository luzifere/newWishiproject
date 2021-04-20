package TestsObjects;

import java.util.Random;
import PageObjects.SignUpPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilitis.Listener;

import java.util.Random;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.given;

public class RestAssured {
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
