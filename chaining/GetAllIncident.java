package chaining;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncident extends BaseRequests {

	@Test
	public void getIncident() {
		
		response = reqSpec.get();

		// Step 4: Get the sys_id
		JsonPath jsonPath = response.jsonPath();
		List<String> lstSysId = jsonPath.getList("result.sys_id"); 
		
		// Get the first one
		sys_id = lstSysId.get(0);
		System.out.println(sys_id);

	
	}

}
