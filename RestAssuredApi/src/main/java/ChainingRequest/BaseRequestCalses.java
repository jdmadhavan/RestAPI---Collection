package ChainingRequest;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseRequestCalses {
	public static String sys_id;

	@BeforeSuite
	public void baseSetup()	
	{
		

		RestAssured.baseURI="https://dev69479.service-now.com/api/now/v2/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "Abcdefmj1@");
	//	RestAssured.authentication=RestAssured.oauth2("p23_qoDY58Uv1LeQ7h_xXyg8Xle8k5abcm0wqUx1YwN6MVUH5lR8Zq5Y26SE9G1V-Z-gZ3T2yc7OWe1UR2fqYg");

	}

}
