package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;

import java.io.IOException;
public class GetGroupID {
	RequestSpecification request;
	Response res;
	
	@Given("I send retrive A group request")
	public void i_send_retrive_a_group_request() throws IOException {
		Utils util = new Utils();
		request = given().log().all().spec(util.requestSpecification());
	}

	@Given("I send createBitlink Payload")
	public void i_send_create_bitlink_payload() throws IOException {
		Utils util = new Utils();
		TestDataBuild testData = new TestDataBuild();
		request = given().log().all().spec(util.requestSpecification()).body(testData.createBitLinkPayLoad("https://autoTest123.com", "Bl9s7SOtulG"));
	}
	
	@Given ("I send Retrieve Sorted Bitlinks for Group request with unit as {string}")
	public void i_send_Retrieve_Sorted_Bitlinks_Request(String unit) throws IOException {
		Utils util = new Utils();
		request = given().log().all().spec(util.requestSpecification().queryParam("unit", unit));
	}
	
	@When ("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		APIResources resourceAPI=APIResources.valueOf(resource);
		String fetchedResource = resourceAPI.getResource();
		if(httpMethod.contentEquals("POST")) {
			res = request.when().post(fetchedResource);
		}else if(httpMethod.contentEquals("GET")) {
			res = request.when().get(fetchedResource);
		}
	}
	
	@And ("the API call got success with status code {int}")
	public void verifyStatusCode(Integer statusCode) {
		ResponseSpecification resp = new ResponseSpecBuilder().expectStatusCode(statusCode).build();
		res.then().log().all().spec(resp).statusCode(statusCode);
	}
	

}
