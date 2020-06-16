package delete;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeletetheChangeRequest {
  @Test
	public void getAllChangeRequest()
	{
    	RestAssured.baseURI="https://dev65735.service-now.com/api/now/v2/table/change_request";
    	RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
    	
    	
    	ValidatableResponse response = RestAssured
    			.given()
    			.delete("803942c2db3c1010424817803996194f")
    			.then()
    			.assertThat()
    			.statusCode(204);
    			
    			
    	
    	        
    	  			
    		
    	
    	
      
      
    	
    	
	}

}
