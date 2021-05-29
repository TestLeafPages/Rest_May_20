package basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentWithXmlParse {

	@Test
	public void getIncident() {
		
		Map<String, String> allParam = new HashMap<String, String>();
		allParam.put("category", "software");
		allParam.put("sysparm_fields", "number,sys_id,category");
		
		// step1: Get Endpoint (F3)
		// className.methodName();
		RestAssured.baseURI = "https://dev79032.service-now.com/api/now/table/incident";
		// step2: Authentication (basic)
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		// step3: Reqtuest Type - get (ctrl+2 , l)
		 Response response = RestAssured
				 .given()
				 .queryParams(allParam)
				 .accept(ContentType.XML)
				 .get();
		// step4: validate status code - 200
		System.out.println(response.statusCode());
		// step5: print response
//		response.prettyPrint();

		
		//need to parse xml
		XmlPath xmlPath = response.xmlPath();
		//get the sys_id (path)
		List<String> listSys_ID = xmlPath.getList("response.result.sys_id"); 
		
		//get count
		System.out.println(listSys_ID.size());
		
		// print all sys_id
		for ( String eachSys_ID : listSys_ID) {
			System.out.println(eachSys_ID);
		}
		
		
		
		
		
		
		
		
		
	}

}
