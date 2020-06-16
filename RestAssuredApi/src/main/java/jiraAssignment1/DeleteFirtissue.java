package jiraAssignment1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteFirtissue extends BaseRequestSetup {
	@Test
	public void getAllJiraIssues()
	{
		Map<String,String> parameterRequest=new HashMap<String, String>();
    	parameterRequest.put("jql", "project=MAY And created >= startOfDay(-24h)");	
  		Response response = RestAssured
  				
  				.given()
	            .queryParams(parameterRequest)
	            .log().all()  
	            .get("search/");
  		
  		JsonPath responsedata= response.jsonPath();
    	Object object = responsedata.get("total");
    	List<String> allIssueId = responsedata.getList("issues.id");
    	System.out.println("Total Project Issues----> "+object); 
    	String firstIssueID=allIssueId.get(0);
    	System.out.println("Fisrt Issue ID "+firstIssueID);
    	
    	ValidatableResponse response2=RestAssured
    			.given()
    			.log().all()
    			.when()
    			.delete("issue/"+firstIssueID+"")
    			.then()
    			.statusCode(204);
    	        
    	
    	
    	
    	
	}
	

}
