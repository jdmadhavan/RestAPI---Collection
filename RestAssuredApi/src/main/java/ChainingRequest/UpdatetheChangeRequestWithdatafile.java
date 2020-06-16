package ChainingRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.ValidatableResponse;

public class UpdatetheChangeRequestWithdatafile extends BaseRequestCalses{


	@Test(dependsOnMethods={"ChainingRequest.CreateNewChangeRequestpassingDataFile.createChangeRequest"})
	public void updatechangeRequest()
	{

		File jsonFilePath=new File("data2.json");

		ValidatableResponse response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFilePath)
				.put(sys_id)
				.then()
				.assertThat()
				.statusCode(200);
				

		
		
	}

}
