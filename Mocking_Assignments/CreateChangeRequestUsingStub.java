package assessment;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
public class CreateChangeRequestUsingStub extends BaseClass{
	
	@BeforeMethod
	public void preCondition() {
		
		
		
		stubFor(post("/api/now/table/change_request")
				.willReturn(aResponse()
						.withStatus(201)
						.withBody("<response><result><id>100</id><type>emergency</type></result></response>")
						.withHeader("content-type", "application/xml")));
	}
	
	@Test
	public void createChangeRequest() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/change_request";
	//	RestAssured.authentication = RestAssured.basic("admin", "India@123");
	
		Response response = RestAssured.given()
		.contentType(ContentType.XML)
		.body("<response><result><type>standard</type></result></response>")
		.post()
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.XML)
		.body("response.result.type", equalTo("emergency")).extract().response();
		
		response.prettyPrint();
		
		id = response.xmlPath().get("response.result.id");
		
		System.out.println(id);
	}

}
