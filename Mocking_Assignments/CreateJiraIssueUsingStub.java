package assessment;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class CreateJiraIssueUsingStub {
	
	@BeforeMethod
	public void preCondition() {
		stubFor(post("/rest/api/2/issue")
				.willReturn(aResponse()
						.withStatus(201)
						.withBody("{\"description\":\"Description from stub\"}")
						.withHeader("content-type", "application/json")));
	}
	
	@Test
	public void createChangeRequest() {
		RestAssured.baseURI = "http://localhost:8080/rest/api/2/issue";
	//	RestAssured.authentication = RestAssured.basic("admin", "India@123");
		
		RestAssured.given()
		.contentType(ContentType.XML)
		.body("{\"description\":\"Description from stub\"}")
		.post()
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.body("description", equalTo("Description from stub"));
	}
}
