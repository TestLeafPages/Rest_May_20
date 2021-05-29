package basic;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidentWithJsonParse {

	@Test
	public void getIncident() {
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		// step3: Reqtuest Type - get (ctrl+2 , l)
		 Response response = RestAssured.get();
		// step4: validate status code - 200
		System.out.println(response.statusCode());
		// step5: print response
//		response.prettyPrint();

		
		//need to parse json
		JsonPath jsonPath = response.jsonPath();
		//get the sys_id (path)
		List<String> listSys_ID = jsonPath.getList("result.sys_id"); 
		
		//get count
		System.out.println(listSys_ID.size());
		
		// print all sys_id
		for ( String eachSys_ID : listSys_ID) {
			System.out.println(eachSys_ID);
		}
		
		
		
		
		
		
		
		
		
	}

}
