package assignments.basics;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class GetAllJiraIssues {
	
	@Test
	public void getAllIssues() {
		
		//set up endpoint
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search";
		
		//set up authentication
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "3KyUNqfFIjA0azvaiUgn293C");
		
		//place the request
		RestAssured
		.given()
		.queryParam("jql", "project=RA")
		.queryParam("maxResults", "40")
		.when()
		.get()
		.then()
		.assertThat()
		.body("maxResults", equalTo(40));
		
		/*
		 * JsonPath jsonResp = response.jsonPath(); List<String> listOfIds =
		 * jsonResp.getList("issues.id");
		 * 
		 * System.out.println("Number of records: "+listOfIds.size());
		 * 
		 * for (String eachId : listOfIds) { System.out.println(eachId); }
		 */
	}

}
