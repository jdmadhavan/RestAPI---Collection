package jiraAssignment1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.ValidatableResponse;


public class CreateIssueWithStringBody extends BaseRequestSetup{
	
	@Test
	public void  newIssuePassingStringVal()
	{
		
		ValidatableResponse response=RestAssured
				.given()
				.log().all()
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
						"    \"fields\": {\r\n" + 
						"       \"project\":\r\n" + 
						"       { \r\n" + 
						"           \"key\": \"MAY\"\r\n" + 
						"       },\r\n" + 
						"       \r\n" + 
						"       \"description\": \"Using String Body\",\r\n" + 
						"       \"summary\":\"ResstAssured Issue By MDN\",\r\n" + 
						"       \"issuetype\": {\r\n" + 
						"       	   \"description\": \"Passing staing value to body.\",\r\n" + 
						"           \"name\": \"Bug\"\r\n" + 
						"       }\r\n" + 
						"   }\r\n" + 
						"}")
				.post("issue")
		        .then()
		        .assertThat()
		        .statusCode(201);
				
			
		
	}


}