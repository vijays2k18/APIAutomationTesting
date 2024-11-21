package Authentication_Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AuthorizationServer {
	
	@Test
	public void run()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given()
		    .formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		    .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		    .formParam("grant_type", "client_credentials")
		    .formParam("scope", "trust")
		    .when()
		    .post("/oauthapi/oauth2/resourceOwner/token")
		    .then()
		    .assertThat()
		    .statusCode(200) 
		    .extract()
		    .asString();
			System.out.println("Full Response: " + response);
			
			JsonPath js1 = new JsonPath(response);
			String accessToken = js1.getString("refresh_token");
			System.out.println(accessToken);
			
			String getCoursesList = given().param("access_token", accessToken)
			.when().get("oauthapi/getCourseDetails")
			.then().assertThat().extract().asString();
			System.out.println(getCoursesList);
		
		
		
	}

}
