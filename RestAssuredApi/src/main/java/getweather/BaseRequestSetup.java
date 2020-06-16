package getweather;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseRequestSetup {

	@BeforeSuite
	public void requestSetup()
	{
		RestAssured.baseURI="https://api.openweathermap.org/data/2.5/";
		


	}}
