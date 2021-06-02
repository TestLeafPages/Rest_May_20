package assignments.basics;

import java.io.File;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class CreateJiraIssue {
	
	@DataProvider(name="sendPath")
	public String[] sendFilePath() {
		String[] path = new String[2];
		
		path[0] = "./data/data1.json";
		path[1] = "./data/data2.json";
		
		return path;

	}
	
	@Test(dataProvider = "sendPath")
	public void getAllIssues(String path) {
		
		//set up endpoint
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
		
		//set up authentication
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "3KyUNqfFIjA0azvaiUgn293C");
		
		File file = new File(path);
		
		//place the request
		Response response = RestAssured
		.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(3000L))
		.body("key", containsString("RS"))
		.extract()
		.response();
		
		response.prettyPrint();
	
		
	}

}
