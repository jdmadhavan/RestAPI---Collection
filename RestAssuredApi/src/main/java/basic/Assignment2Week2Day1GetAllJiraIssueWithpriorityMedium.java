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

public class Assignment2Week2Day1GetAllJiraIssueWithpriorityMedium {
  @Test
	public void jiraIssues()
	{
    	RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/search/";
    	RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");
    	
    	
    	Map<String,String> parameterRequest=new HashMap<String, String>();
    	parameterRequest.put("jql", "project=MAY And priority=Medium");
    	
    	parameterRequest.put("maxResults","500");
    	Response response = RestAssured
    			            .given()
    			            .queryParams(parameterRequest)
    			            .log().all()  
    			            .get();
    	
    	//System.out.println(response.prettyPrint());
    	JsonPath responsedata= response.jsonPath();
    	Object object = responsedata.get("total");
    	System.out.println("Total Project Issues----> "+object);
    	List<String> allIssueId = responsedata.getList("issues.feilds.attachment.filename");
    	System.out.println(allIssueId.size());
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
       
       
       
    	
    	
	}

}
