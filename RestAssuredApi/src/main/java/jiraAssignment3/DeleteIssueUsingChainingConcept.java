package jiraAssignment3;



import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.ValidatableResponse;

public class DeleteIssueUsingChainingConcept extends BaseRequestSetup {
	@Test(dependsOnMethods= {"jiraAssignment3.CreateIssusWithExternalFile.createIssue"})
	public void deleteIssue()
	{
		 System.out.println("From Delete Method --->"+issueId);
    	ValidatableResponse res=RestAssured
    			.given()
       			.log().all()
    			.when()
    			.delete("issue/"+issueId+"")
    			.then()
    			.statusCode(204);
    	        
    	
    	
    	
    	
	}
	

}
