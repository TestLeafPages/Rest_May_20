package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagement {

	public static RequestSpecification request;
	public static Response response;

	@Given("Set the contentType as json")
	public void setContentType() {
		request = RestAssured
				.given()
				.contentType(ContentType.JSON);
	}

	@When("you send the request as post")
	public void sendPostRequest() {
		response = request
				.post();
	}

	@When("you send the request as post with short_description as (.*)$")
	public void sendPostRequest(String description) {
		response = request
				.body("{ \"short_description\": \""+description+"\" }")
				.post();
	}
	
	@When("you send the request as get")
	public void getIncident() {
		response = request
				.get();
	}
	
	@Then("verify the status code is (.*)$")
	public void printStatusCode(String expectedStatusCode) {
		response
		.then()
		.assertThat()
		.statusCode(Integer.parseInt(expectedStatusCode))
		.extract()
		.response();
	}

	@And("Print the response")
	public void printResponseBody() {
		response.prettyPrint();
	}

}
