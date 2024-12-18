package RestAssuredTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestfulBookerTest1 {
    @Test(description = "Delete User")
    public void Testcase1(){
        String body = """
                {
                "username" : "admin",
                 "password" : "password123"
                }
                """;
        String bodyCreate = """
                {
                 "firstname" : "Raanaa",
                 "lastname" : "rr",
                 "totalprice" : 111,
                 "depositpaid" : true,
                 "bookingdates" : {
                  "checkin" : "2024-01-02",
                   "checkout" : "2025-01-01"
                    },
                    "additionalneeds" : "Breakfast"
                
                }
                """;
        String token =

        RestAssured.
        given()
                .header("Content-Type","application/json")
                .body(body)
                .log().all().
        when()
                .post("https://restful-booker.herokuapp.com/auth").
        then()
                .statusCode(200).and().log().body().extract().jsonPath().get("token").toString();



        String bookingid =

        RestAssured.
        given()
                .header("Content-Type","application/json")
                .body(bodyCreate)
                .log().all().
        when()
                .post("https://restful-booker.herokuapp.com/booking").
        then()
                .statusCode(200).body("booking.firstname",CoreMatchers.equalTo("Raanaa")).
        and()
                .log().body().extract().jsonPath().get("bookingid").toString();



        String responseBody =
        RestAssured.
        given()
                .header("Content-Type","application/json")
                .cookie("token=<"+token+">")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=").
        when()
                .delete("https://restful-booker.herokuapp.com/booking/"+ bookingid).
        then()
                .statusCode(201).
          and()
                .log().body().extract().asString();

        Assert.assertTrue(responseBody.contains("Created"));

    }








}
