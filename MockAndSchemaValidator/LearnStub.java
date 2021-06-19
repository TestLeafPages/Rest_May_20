package learn.mock;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnStub {

	@BeforeMethod
	public void mockCreateIncident() {// 8080
		stubFor(put("/api/now/table/incident")
				.willReturn(aResponse()
						.withStatus(201)
						.withHeader("content-type", "application/json")
						.withBody("{ 'Number': 'INC00124',"
								+ " 'description': '' ,"
								+ "'sys_id': 'c2d3b7022f743010a99d857cf699b679',"
								+ " 'category': 'inquiry'}")));
	}

	@Test
	public void createIncident() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.patch();
		System.out.println(response.statusCode());
		response.prettyPrint();
	}


}
