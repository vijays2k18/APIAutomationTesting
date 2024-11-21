package DynamicJson;

import org.testng.annotations.Test;

import dynacipayload.addbookapi;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynaciJson {
	
	@Test 
	public void run()
	{
		RestAssured.baseURI = "http://216.10.245.166";

		String addbookapi1 = given()
		    .header("Content-Type", "application/json")
		    .body(addbookapi.addbookapipayload("aiso", "1001"))
		    .when()
		    .post("/Library/Addbook.php")
		    .then()
		    .assertThat()
		    .statusCode(200) // Assert the response code is as expected
		    .extract()
		    .asString(); // Extract the response as a String
		System.out.println(addbookapi1);

		JsonPath js1 = new JsonPath(addbookapi1); // Pass the response to JsonPath
		String id = js1.getString("ID"); // Extract the ID field
		System.out.println("Book ID: " + id);
		
	}

}
