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

public class GetAllNormalChangeRequest {
	
	
	@Test
	public void createChangeRequest() {
		RestAssured.baseURI = "http://localhost:8080/api/now/table/change_request";
		//RestAssured.authentication = RestAssured.basic("admin", "India@123");
		
		Response response = RestAssured.given()
		.queryParam("type", "normal")
		.get();
		
		JsonPath jsonPath = response.jsonPath();
		List<String> list = jsonPath.getList("result.number");
		int count = 0;
		for (String eachReq : list) {
			System.out.println(eachReq);
			count++;
		}

		System.out.println(count);
	}

}
