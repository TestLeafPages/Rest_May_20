package assignments.chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateIssue extends BaseClass {

	
	@Test(dependsOnMethods="assignments.chaining.CreateIssue.create")
	public void update() {
				
		
		Response response = RestAssured
		.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.body("{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \r\n" + 
				"        \"description\": \"Updated using Rest Assured\"\r\n" + 
				"    }\r\n" + 
				"}\r\n" + 
				"")
		.when()
		.put("issue/"+issue_id);
		
		response.prettyPrint();
	
	}

}
