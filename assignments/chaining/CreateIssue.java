package assignments.chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIssue extends BaseClass {
	
	@Test
	public void create() {
		
		File file = new File("./data/data1.json");
		
		Response response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("issue")
		.then()
		.assertThat()
		.statusCode(201)
		.extract()
		.response();
		
	//	response.prettyPrint();
		
		JsonPath jsonResponse = response.jsonPath();
		issue_id = jsonResponse.get("id");
		
	//	System.out.println(issue_id);
	}

}
