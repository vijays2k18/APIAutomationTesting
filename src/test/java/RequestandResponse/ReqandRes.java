package RequestandResponse;

import org.testng.annotations.Test;
import Payloads.payload; // Ensure this package exists and is correctly imported
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

public class ReqandRes {

    @Test
    public void run() {

   
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType("application/json") // Ensure content type is set if needed
                .build();

      
        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200) 
                .build();

        String actualResponse = given()
                .spec(reqSpec)
                .body(payload.Addplace())
                .when()
                .post("/maps/api/place/add/json")
                .then()
                .spec(responseSpec) 
                .extract()
                .asString();

        // Print the actual response
        System.out.println("Response: " + actualResponse);
    }
}

