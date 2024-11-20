package APIBasicsTesting;

import org.testng.annotations.Test;

import Payloads.payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class APIAutomationBasics {
	
	@Test
	public void run()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Add Place API
		given().queryParam("key", "qaclick123").header("Content-Type","application/json").body(payload.Addplace())
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
