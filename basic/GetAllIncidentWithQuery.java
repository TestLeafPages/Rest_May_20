package basic;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidentWithQuery {

	@Test
	public void getIncident() {
		
		//map object
		Map<String, String> allParam = new HashMap<String, String>();
		allParam.put("category", "software");
		allParam.put("sysparm_fields", "number,sys_id,category");
		
		
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		// step3: Reqtuest Type - get + Query Param
		 Response response = RestAssured
				 .given()
//				 .queryParam("category", "software")
				 .queryParams(allParam)
				 .get();
		// step4: validate status code - 200
		System.out.println(response.statusCode());
		// step5: print response
		response.prettyPrint();
		

	}

}
