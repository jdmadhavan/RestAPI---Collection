package jiraAssignment0;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseRequestSetup {

	@BeforeSuite
	public void requestSetup()
	{
		RestAssured.baseURI="https://api-mar2020.atlassian.net/rest/api/2/";
		RestAssured.authentication=RestAssured.preemptive().basic("rajalakshmi.govindarajan@testleaf.com", "kEJxzmhkQzvdeP8iysWN2D1B");


	}}
