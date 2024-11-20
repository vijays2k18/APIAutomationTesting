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
		// Extracting Place Id from Response
		JsonPath js = new JsonPath(addAPIResponse);
		String placeId = js.getString("place_id");
			
		//Get API 
		
		String getAPIResponse = given().queryParam("place_id", placeId).queryParam("key", "qaclick123")
		.headers("Content-Type","application/json").when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().asString();
		System.out.println(getAPIResponse);
		
		JsonPath js1 = new JsonPath(getAPIResponse);
		String expectedName = js1.getString("name");
		System.out.println(expectedName);
		
	}

}
