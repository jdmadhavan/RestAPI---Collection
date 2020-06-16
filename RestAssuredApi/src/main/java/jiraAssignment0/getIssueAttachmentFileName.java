package jiraAssignment0;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class getIssueAttachmentFileName extends BaseRequestSetup {
	@Test
	public void getAllJiraIssues()
	{
		Map<String,String> parameterRequest=new HashMap<String, String>();
		parameterRequest.put("jql", "project=MAY AND priority = Medium AND attachments IS NOT EMPTY");	
		Response response = RestAssured

				.given()
				.queryParams(parameterRequest)
				.log().all()  
				.get("search/");

		JsonPath responsedata= response.jsonPath();
		Object object = responsedata.get("total");
		List<String> allIssueId = responsedata.getList("issues.id");
		System.out.println("Total Project Issues----> "+object); 

		for (String id : allIssueId) {  

			System.out.println("Issue Id is--->"+id);
			Response responseNew=RestAssured
					.given()

					.get("issue/"+id+"");
			JsonPath responseDataNew = responseNew.jsonPath();
			List<Object> attachmentSize = responseDataNew.getList("fields.attachment");
			int attachmentCount =attachmentSize.size();
			System.out.println("Total Attachment of the Issue--->"+attachmentCount);
			for(int i=0;i<attachmentCount;i++)
			{
				Object fileName = responseDataNew.get("fields.attachment["+i+"].filename");
				System.out.println("Attachment FileName is----->>"+fileName);

			}

		}


	}


}
