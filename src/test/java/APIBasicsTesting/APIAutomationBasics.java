package APIBasicsTesting;

import org.testng.annotations.Test;

import Payloads.deletePayload;
import Payloads.payload;
import Payloads.putPayload;
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
		
		// PUT API
		
		String putAPIResponse = given().queryParam("place_id", placeId).queryParam("key", "qaclick123")
		.headers("Content-Type","application/json").body(putPayload.putAPI(placeId, "Chennai -620302", "qaclick123"))
		.when().put("/maps/api/place/update/json")
		.then().assertThat().extract().asString();
		
		//Get API 
		
		String getAPIResponse = given().queryParam("place_id", placeId).queryParam("key", "qaclick123")
		.headers("Content-Type","application/json").when().get("/maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().asString();
		System.out.println(getAPIResponse);
		
		//Delete API
		String deleteAPIResponse = given().queryParam("place_id", placeId)
		.headers("Content-Type","application/json").body(deletePayload.deleteAPI(placeId))
		.when().delete("/maps/api/place/delete/json")
		.then().assertThat().extract().asString();
		System.out.println(deleteAPIResponse);
		
		String getAPIResponse2 = given().queryParam("place_id", placeId).queryParam("key", "qaclick123")
				.headers("Content-Type","application/json").when().get("/maps/api/place/get/json")
				.then().assertThat().statusCode(404).extract().asString();
				System.out.println(getAPIResponse2);
				
		
	}

}
