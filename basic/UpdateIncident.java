package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateIncident {

	@Test
	public void getIncident() {
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		// step3: Reqtuest Type - 
		 Response response = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
				 .body(new File("./data/CreateIncident1.json"))
				 .patch("1222cca72f503010a99d857cf699b65c");
		 //.put("1222cca72f503010a99d857cf699b65c");
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();
		

	}

}
