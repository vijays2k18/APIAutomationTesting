package ApiAutomation.API_Automation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class Api_Basics1 {
	
	@Test
	public void run()
	{
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
