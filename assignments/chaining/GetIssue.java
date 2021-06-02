package assignments.chaining;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIssue extends BaseClass{
	
	@Test /* (dependsOnMethods="assignments.chaining.CreateIssue.create") */
	public void getIssue() {
				
		
		Response response = RestAssured
		.given()
		.log()
		.all()
		.queryParam("jql", "project=RS")
		.when()
		.get("search");
		
		//response.prettyPrint();
		List<String> listOfIds = response.jsonPath().getList("issues.id");
		issue_id = listOfIds.get(0);
		System.out.println(issue_id);
		
	}

}
