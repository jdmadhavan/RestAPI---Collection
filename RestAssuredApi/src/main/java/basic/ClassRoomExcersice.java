package basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ClassRoomExcersice {
  @Test
	public void getAllChangeRequest()
	{
    	RestAssured.baseURI="https://dev65735.service-now.com/api/now/v2/table/change_request";
    	RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");
    	
    	
    	Map<String,String> parameterRequest=new HashMap<String, String>();
    	parameterRequest.put("type", "Emergency");
    	parameterRequest.put("sysparm_fields","type,number,sys_id");
    	Response response = RestAssured
    			            .given()
    			            .log().all()
    			            .accept(ContentType.XML)
    			            .queryParams(parameterRequest)
    			                .get();
    	
    	System.out.println(response.prettyPrint());
    	
    	XmlPath xmlPath = response.xmlPath();
    	List<String> allCr=xmlPath.getList("response.result.number");
    	
    	int crCount=allCr.size();
    	System.out.println("Total Count Of CR"+crCount);
    	System.out.println("First CR"+allCr.get(0));
       	System.out.println("Last  CR"+allCr.get(crCount-1));
    	
    	
    	
    	
    	
    	
       
       
       
    	
    	
	}

}
