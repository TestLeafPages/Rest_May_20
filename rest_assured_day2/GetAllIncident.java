package day2;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class GetAllIncident {

	@Test
	public void getIncident() {
		
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Map<String, String> allParam = new HashMap<String, String>();
		allParam.put("category", "software");
		allParam.put("sysparm_fields", "number,sys_id,category");
		
		ValidatableResponse all = RestAssured
				.given()
				.log()
				.all()
				.queryParams(allParam)
				.get()
				.then()
				.log()
				.all();

	
		
		//response.prettyPrint();

	}

}
