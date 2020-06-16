package stepDefinations;

import java.io.File;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ChangeRequestSteps {
	
	private RequestSpecification requestspec;
	private Response response;
	@Given("load the end point")
	public void initEndPoint()
	{
		RestAssured.baseURI="https://dev69479.service-now.com/api/now/v2/table/change_request";
	}
	
	@And("Basic authendication")
	public void authentication()
	{
		RestAssured.authentication=RestAssured.basic("admin", "Abcdefmj1@");
	}
	
	@Given("Set the coontent type json")
	public void setContentType()
	{
		requestspec= RestAssured
			.given().contentType(ContentType.JSON);
	}
	
	
	@And("set body as a file (.*)$")
	public void setFile(String filename)
	{
		requestspec.body(new File(filename));
	}
	
	@When("Send the post request")
	public void sendPostRequest()
	{
		response  = requestspec.post();
	}
	
	
	@Then("Verify the response status code is 201")
	public void verifyResponseStatusCode()
	{  int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
		System.out.println(response.prettyPrint());
	}
	
}
