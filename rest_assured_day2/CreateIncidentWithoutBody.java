package day2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;


public class CreateIncidentWithoutBody {

	@Test
	public void getIncident() {
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		Response response = RestAssured
				.given()
					.contentType(ContentType.JSON)
				.when()
					.post()
				.then()
					.assertThat()
					.body(matchesJsonSchema(new File("./createIncident.json")))
				.extract().response();
		System.out.println(response.statusCode());
		response.prettyPrint();


	}

}
