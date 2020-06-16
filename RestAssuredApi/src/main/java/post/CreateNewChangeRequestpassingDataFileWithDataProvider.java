package post;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateNewChangeRequestpassingDataFileWithDataProvider {
	@DataProvider(name="files",parallel=true)
	public String[] getfiles()
	{
		String[]files=new String[2];
		files[0]="data1.json";
		files[1]="data2.json";
		return files;		
	};

	@Test(dataProvider="files")
	public void createChangeRequest(String filename)

	{
		RestAssured.baseURI="https://dev65735.service-now.com/api/now/v2/table/change_request";
		RestAssured.authentication=RestAssured.basic("admin", "Tuna@123");

		File jsonFilePath=new File(filename);
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFilePath)
				.post();

		System.out.println("status code "+response.statusCode());
		System.out.println(response.prettyPrint());



	}

}
