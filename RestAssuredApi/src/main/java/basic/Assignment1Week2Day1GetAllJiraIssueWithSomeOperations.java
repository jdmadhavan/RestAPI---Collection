package basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Assignment1Week2Day1GetAllJiraIssueWithSomeOperations {
  @Test
	public void jiraIssues()
	{
    	RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/search/";
    	RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");
    	
    	
    	
    	Map<String,String> parameterRequest=new HashMap<String, String>();
    	parameterRequest.put("jql", "project=MAY");
    	parameterRequest.put("maxResults","500");
    	Response response = RestAssured
    			            .given()
    			            .queryParams(parameterRequest)
    			            .log().all()  
    			            .get();
    	
    	JsonPath responsedata= response.jsonPath();
    	Object object = responsedata.get("total");
    	List<String> allIssueId = responsedata.getList("issues.id");	
    	System.out.println("Total Project Issues----> "+object);   	
      	System.out.println("Last issue ID       ----> "+allIssueId.get(allIssueId.size()-1));
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
       
       
       
    	
    	
	}

}
