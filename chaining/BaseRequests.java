package chaining;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequests {

	public static String sys_id = "";
	public static RequestSpecification reqSpec;
	public static Response response;

	@BeforeSuite
	public void init() {

		RestAssured.baseURI = "https://dev108253.service-now.com/api/now/table/incident";
		//RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		RestAssured.authentication = RestAssured.oauth2("uKZFUo_LBYZ0XXAXVQrFtN75ABGmplosUWrZHuV1ul4REEeunXTzpdry845zH9qxk481f6buYPuO5TbDHJR7BQ");
		
		reqSpec = RestAssured.given().log().all();
	}
	
	@AfterMethod
	public void afterEachTests() {
		response.then().log().all();
	}

}
