package jiraAssignment2;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.ValidatableResponse;


public class CreateIssueWithMultipleDataFile extends BaseRequestSetup{

	@DataProvider(name="fetching",parallel=true)
	public String[] fetchDate()
	{
		String files[]= new String[3];
		files[0]="issue1.json";
		files[1]="issue2.json";
		files[2]="issue3.json";
		return files;


	}

	@Test(dataProvider="fetching")
	public void  newIssuePassingStringVal(String files)
	{	File jsonFilePath=new File(files);

	ValidatableResponse response=RestAssured
			.given()
			.log().all()
			.contentType(ContentType.JSON)
			.body(jsonFilePath)
			.post("issue")
			.then()
			.assertThat()
			.statusCode(201);



	}


}