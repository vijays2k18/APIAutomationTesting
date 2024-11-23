package Stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

import Payloads.payload;

public class Stepdefinition {
    RequestSpecification reqSpec;
    Response response;

    @Given("I send a request to the Place Order API")
    public void i_send_a_request_to_the_place_order_api() {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com") // Set the base URI
                .setContentType(ContentType.JSON)             // Set the content type to JSON
                .build();
    }

    @When("I include the request body in the API")
    public void i_include_the_request_body_in_the_api() {
        // Use the payload to send a POST request
        response = given()
                .spec(reqSpec)                               // Attach the request specification
                .body(payload.Addplace())                   // Add the request body
                .when()
                .post("/maps/api/place/add/json");          // Send a POST request
    }

    @And("I verify the response contains status {string} and scope {string}")
    public void i_verify_the_response_contains_status_and_scope(String statusCode, String scope) {
        // Parse the response as a JsonPath object
        JsonPath js1 = new JsonPath(response.asString());

        // Extract status and scope from the response
        String actualStatus = js1.getString("status");
        String actualScope = js1.getString("scope");

        // Assert status and scope
        if (!actualStatus.equals(statusCode)) {
            throw new AssertionError("Expected status: " + statusCode + ", but got: " + actualStatus);
        }
        if (!actualScope.equals(scope)) {
            throw new AssertionError("Expected scope: " + scope + ", but got: " + actualScope);
        }

        System.out.println("Response contains status: " + actualStatus + " and scope: " + actualScope);
    }

    @Then("I validate that the status code is {string}")
    public void i_validate_that_the_status_code_is(String expectedStatusCode) {
        // Validate the HTTP status code
        int actualStatusCode = response.getStatusCode();

        if (Integer.parseInt(expectedStatusCode) != actualStatusCode) {
            throw new AssertionError(
                    "Expected status code: " + expectedStatusCode + ", but got: " + actualStatusCode);
        }

        System.out.println("Validated status code: " + actualStatusCode);
    }
}
