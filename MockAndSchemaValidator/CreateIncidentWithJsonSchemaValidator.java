package basic;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateIncidentWithJsonSchemaValidator {

	@Test
	public void getIncident() {
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		// step3: Reqtuest Type - post (ctrl+2 , l)
//		File file = new File("./data/JsonScema.json");
		
		Response response = RestAssured
				 .given()
				 .contentType(ContentType.JSON)
				 .post()
				 .then()
				 .assertThat()
				 .body(JsonSchemaValidator.matchesJsonSchema(new File("./data/JsonScema.json")))
				 .extract().response();
//				 .extract().response().asString();
		// step4: validate status code - 201
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();
		

	}

}
