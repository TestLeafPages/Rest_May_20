package learn.mock;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnMockRecoding {
	
	//Run wiremock server in your local machine  
	//http://localhost:port/__admin/recorder/

	@Test
	public void createIncident() {
		RestAssured.baseURI = "http://localhost:8081/api/now/table/incident";
//		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
		System.out.println(response.statusCode());
		response.prettyPrint();
	}


}
