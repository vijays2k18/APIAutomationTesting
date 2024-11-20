package APIBasicsTesting;

import org.testng.annotations.Test;

import Payloads.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class APIAutomationBasics {
	
	@Test
	public void run()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Add Place API
		String addAPIResponse = given().queryParam("key", "qaclick123").header("Content-Type","application/json").body(payload.Addplace())
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().asString();
		System.out.println(addAPIResponse);
		// Extracting Place Id from Response
		JsonPath js = new JsonPath(addAPIResponse);
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
	}

}
