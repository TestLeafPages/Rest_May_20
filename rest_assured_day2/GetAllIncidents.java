package day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;

public class GetAllIncidents {

	@Test
	public void getIncident() {
		
		RestAssured.baseURI = "https://dev108253.service-now.com/api/now/table/incident";
		//RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Map<String, String> allParam = new HashMap<String, String>();
		allParam.put("category", "software");
		allParam.put("sysparm_fields", "number,sys_id,category");
		
		RestAssured.useRelaxedHTTPSValidation();
		
		List<Header> allHeaders = new ArrayList<Header>();
		allHeaders.add(new Header("Authorization", "Basic YWRtaW46VHVuYUAzMjE="));
		allHeaders.add(new Header("Accept", "application/json"));
		Headers headers = new Headers(allHeaders);
		
		Response response = RestAssured
				.given()
					.log().all()
					.headers(headers)
					.queryParams(allParam)
				.when()
					.get()
				.then()
					.body("result.number[0]", Matchers.containsString("INC00000061"))
					.body("result.category", Matchers.equalTo("software"))
				.extract().response();

		System.out.println(response.getStatusCode());
		response.prettyPrint();

	}

}
