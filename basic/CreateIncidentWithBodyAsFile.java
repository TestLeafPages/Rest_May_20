package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyAsFile {

	@Test
	public void getIncident() {
		
//		File file = new File("./data/CreateIncident.json");
		
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		// step3: Reqtuest Type - post (ctrl+2 , l)
		 Response response = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
//				 .body(file)
				 .body(new File("./data/CreateIncident.json"))
				 .post();
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();
		

	}

}
