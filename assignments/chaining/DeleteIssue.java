package assignments.chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue extends BaseClass{
	
	
	@Test /* (dependsOnMethods="assignments.chaining.CreateIssue.create") */
	public void deleteIssue() {
				
		
		Response response = RestAssured
		.given()
		.log()
		.all()
		.when()
		.delete("issue/"+issue_id);
		
		System.out.println(response.statusCode());
		
	}

}
