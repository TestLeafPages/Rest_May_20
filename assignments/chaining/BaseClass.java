package assignments.chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {
	
	public static String issue_id;
	
	@BeforeMethod
	public void preCondition() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "3KyUNqfFIjA0azvaiUgn293C");

	}

}
