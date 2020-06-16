package ChainingRequest;

import java.io.File;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.assertion.BodyMatcher;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;

public class CreateNewChangeRequestwithValidation extends BaseRequestCalses {
  @Test
	public void createChangeRequest()
	{
    	
    	File jsonFilePath=new File("data1.json");
    	
    	ValidatableResponse response = RestAssured
    			.given()
    			.log().all()
    			.contentType(ContentType.JSON)
    			//.accept(ContentType.XML)
    			
       			.when()
    			.body(jsonFilePath)
    			
    			.post()
       	        .then()
       	        .assertThat()
    	        //.body(contains("result.sys_id"))
    	        .body("result.short_description",equalTo("Ragu"));
    	
    	
    	
	}
      
    	
    	



}
