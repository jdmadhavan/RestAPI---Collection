package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class BaseSetup {

	@Before
	public void init()
	{
		RestAssured.baseURI="https://dev69479.service-now.com/api/now/v2/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "Abcdefmj1@");
	}
}
