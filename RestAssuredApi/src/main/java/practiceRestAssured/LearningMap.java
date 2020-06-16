package practiceRestAssured;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LearningMap {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://covid-19.dataflowkit.com/v1";
		Response response = RestAssured

				.given().contentType(ContentType.JSON).log().all().get();

		JsonPath jsonPath = response.jsonPath();
		List<Map<Object, Object>> list =jsonPath.getList("");
		Map<Object, Object> cases=new TreeMap<Object, Object>();
		
		for( Map<Object, Object> eachVal:list)
			
		{
			if(eachVal.containsKey("New Cases_text")&&eachVal.get("New Cases_text").toString().length()>1)
{
			System.out.println(eachVal.get("New Cases_text").toString().replaceAll("\\D", ""));
			cases.put(Integer.parseInt(eachVal.get("New Cases_text").toString().replaceAll("\\D", "")),eachVal.get("Country_text").toString());
		}
		
		
	}
		
		System.out.println(cases);

}}