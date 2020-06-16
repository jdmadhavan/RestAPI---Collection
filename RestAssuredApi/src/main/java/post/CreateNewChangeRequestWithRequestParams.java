package post;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNewChangeRequestWithRequestParams {
  @Test
	public void getAllChangeRequest()
	{
    	RestAssured.baseURI="https://dev69479.service-now.com/api/now/v2/table/change_request";
    	RestAssured.authentication=RestAssured.basic("admin", "Abcdefmj1@");
    	
    	Map<String, String> params= new HashMap<String, String>();
    	params.put("short_description", "madhavan");
    	
    	Response response = RestAssured
    			.given()
    	
    	
    			
    	.contentType(ContentType.JSON)
    		.body(params)
    	    .post();
    	
    	
       System.out.println("status code "+response.statusCode());
       System.out.println(response.prettyPrint());
      
    	
    	
	}

}
