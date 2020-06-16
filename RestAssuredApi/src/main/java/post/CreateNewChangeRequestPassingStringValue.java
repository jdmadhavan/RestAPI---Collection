package post;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewChangeRequestPassingStringValue {
  @Test
	public void getAllChangeRequest()
	{
    	RestAssured.baseURI="https://dev65735.service-now.com/api/now/v2/table/change_request";
    	RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
    	
    	
    	
    	Response response = RestAssured
    			.given()
    	
    			
    			
    	.contentType(ContentType.JSON)
    			.body("{\r\n" + 
    					"\"short_description\":\"madhavan\"\r\n" + 
    					"}")
    			.post();
    	
    	
       System.out.println("status code "+response.statusCode());
       System.out.println(response.prettyPrint());
      
    	
    	
	}

}
