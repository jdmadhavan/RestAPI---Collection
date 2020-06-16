package get;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetALLChangeRequest {
  @Test
	public void getAllChangeRequest()
	{
    	RestAssured.baseURI="https://dev65735.service-now.com/api/now/v2/table/change_request";
    	RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
    	
    	Response response = RestAssured.get();
    	
    	
       System.out.println("status code "+response.statusCode());
       System.out.println("response Time"+response.getTime());
    	
    	
	}

}
