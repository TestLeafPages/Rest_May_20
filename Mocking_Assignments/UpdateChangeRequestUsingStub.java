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
public class UpdateChangeRequestUsingStub extends BaseClass {
	
	@BeforeMethod
	public void preCondition() {
		
		
		
		stubFor(put("/api/now/table/change_request/"+id)
				.willReturn(aResponse()
						.withStatus(202)
						.withBody("<response><result><id>100</id><type>emergency</type></result></response>")
						.withHeader("content-type", "application/xml")));
	}
	
	@Test(dependsOnMethods = "assessment.CreateChangeRequestUsingStub.createChangeRequest")
	public void updateChangeRequest() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/change_request/"+id;
	//	RestAssured.authentication = RestAssured.basic("admin", "India@123");
	
		Response response = RestAssured.given()
		.contentType(ContentType.XML)
		.body("<response><result><type>standard</type></result></response>")
		.put()
		.then()
		.assertThat()
		.statusCode(202)
		.contentType(ContentType.XML)
		.body("response.result.type", equalTo("emergency")).extract().response();
		
		response.prettyPrint();
		
		String id = response.xmlPath().get("response.result.id");
		
		System.out.println(id);
	}

}
