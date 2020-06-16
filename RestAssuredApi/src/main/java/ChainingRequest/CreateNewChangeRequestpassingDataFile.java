package ChainingRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateNewChangeRequestpassingDataFile extends BaseRequestCalses {
  @Test
	public void createChangeRequest()
	{
    	
    	File jsonFilePath=new File("data1.json");
    	
    	Response response = RestAssured
    			.given()
    			.contentType(ContentType.JSON)
    			.body(jsonFilePath)
    			.post();
     
    	JsonPath jsonResponse = response.jsonPath();
    	
    	sys_id= jsonResponse.get("result.sys_id");
    	System.out.println("sys id is --->"+sys_id);
    	
    	
      
      
    	
    	
	}

}
