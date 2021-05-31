package chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident extends BaseRequests {

	@Test(dependsOnMethods = "chaining.GetAllIncident.getIncident")
	public void deleteIncident() {

		response = reqSpec
				.delete(sys_id);
		System.out.println(response.statusCode());
		response.prettyPrint();


	}

}
