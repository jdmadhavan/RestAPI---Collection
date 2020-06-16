package put;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class UpdatetheChangeRequestWithdatafile {
  @Test
	public void getAllChangeRequest()
	{
    	RestAssured.baseURI="https://dev65735.service-now.com/api/now/v2/table/change_request";
    	RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
    	
    	File jsonFilePath=new File("data1.json");
    	
    	ValidatableResponse response = RestAssured
    			.given()
    			.contentType(ContentType.JSON)
    			.body(jsonFilePath)
    			.put("00635e8adb3c10104248178039961908")
    			.then()
    			.assertThat()
    			.statusCode(200);
    	        
    			
    	 
    	
    	
    	
     
      
    	
    	
	}

}
