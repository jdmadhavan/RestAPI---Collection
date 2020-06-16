package getweather;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetCityWeather extends BaseRequestSetup {
	@Test
	public void getCityWeather()
	{
		Map<String,String> parameterRequest=new HashMap<String, String>();
		parameterRequest.put("q", "chennai");
		parameterRequest.put("appid", "01bca4841fa478520c64a12db004f782");
		Response response = RestAssured

				.given()
				.queryParams(parameterRequest)
				.log().all()  
				.get("weather");
		
		
		JsonPath jsonPath = response.jsonPath();
		float MaximumTemp = jsonPath.get("main.temp_max");
		float WindSpead=jsonPath.get("wind.speed");
		int sunSet= jsonPath.get("sys.sunset");
		String cityName= jsonPath.get("name");
		
		System.out.println("Maximum Temprature---------> "+cityName);
		System.out.println("Maximum Temprature---------> "+MaximumTemp);
		System.out.println("Wind Speed ----------------> "+WindSpead);
		System.out.println("SunSet--------------------> "+sunSet);
	}


}
