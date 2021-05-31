package day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class GetCookies {

	@Test
	public void getIncident() {
		
		RestAssured.baseURI = "https://dev108253.service-now.com/api/now/table/incident";
		//RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		Map<String, String> allParam = new HashMap<String, String>();
		allParam.put("category", "software");
		allParam.put("sysparm_fields", "number,sys_id,category");
		
		List<Header> allHeaders = new ArrayList<Header>();
		allHeaders.add(new Header("Authorization", "Basic YWRtaW46VHVuYUAzMjE="));
		allHeaders.add(new Header("Accept", "application/xml"));
		Headers headers = new Headers(allHeaders);
		
		Response response = RestAssured
				.given()
				.log()
				.all()
				.headers(headers)
				.queryParams(allParam)
				.get();

		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		Map<String, String> cookies = response.getCookies();
		for (Entry<String, String> cookie : cookies.entrySet()) {
			System.out.println(cookie.getKey());
			System.out.println(cookie.getValue());
			System.out.println("***************");

		}

	}

}















