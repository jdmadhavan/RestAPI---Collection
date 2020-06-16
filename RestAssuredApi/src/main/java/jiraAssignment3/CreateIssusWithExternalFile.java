package jiraAssignment3;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


public class CreateIssusWithExternalFile extends BaseRequestSetup{

	@DataProvider(name="fetching")
	public String[] fetchDate()
	{
		String files[]= new String[1];
		files[0]="issue1.json";
		return files;
	}

	@Test(dataProvider="fetching")
	public void  createIssue(String files)
	{	File jsonFilePath=new File(files);

	Response response=RestAssured
			.given()
			.log().all()
			.contentType(ContentType.JSON)
			.body(jsonFilePath)
			.post("issue");

	JsonPath jsonPath = response.jsonPath();

	issueId=jsonPath.get("id");
	System.out.println("issueId --->"+issueId);




	}


}