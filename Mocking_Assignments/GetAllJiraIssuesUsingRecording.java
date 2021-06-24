package assessment;

import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class GetAllJiraIssuesUsingRecording {
	
	
	@Test
	public void createChangeRequest() {
		RestAssured.baseURI = "http://localhost:8080/rest/api/2/search";
		//RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "3KyUNqfFIjA0azvaiUgn293C");
		
		Response response = RestAssured
		.get();
		
		JsonPath jsonPath = response.jsonPath();
		List<String> list = jsonPath.getList("issues.id");
		System.out.println(list.size());
		
		/*
		 * int count = 0; for (String eachIssue : list) { System.out.println(eachIssue);
		 * count++; }
		 * 
		 * System.out.println(count);
		 */
	}

}
