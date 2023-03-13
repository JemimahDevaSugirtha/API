package com.step_definition;

import org.testng.Assert;


import com.pojo.Urls;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Reqres_Step_Def{
	
	Urls uri = new Urls();
	
	/************* GET METHOD **********************/
	
	@Given("user should be able to launch URI")
	public void user_should_be_able_to_launch_uri() {
		
		RestAssured.baseURI = uri.getReqresBaseURI();
	}
	
	@When("user hits the url {string} results with a response")
	public void user_hits_the_url_results_with_a_response(String url) {

		RequestSpecification given = RestAssured.given();
		Response response = given.get(url); //url hitting
		
		System.out.println("URL: "+uri.getReqresBaseURI()+url);
		System.out.println("Response: "+response.asString());
		
	}

	@Then("user gets the status code \"\"{int}\"\" for the url {string}")
	public void user_gets_the_status_code_for_the_url(Integer statcode, String url){

		RequestSpecification given = RestAssured.given();
		
		Response response = given.get(url); //url hitting
		
		int statusCode = response.statusCode();
		
		int expSC = statcode;
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, expSC); //Actual vs expected
		
	}
	
	
	/************* POST METHOD **********************/
	
	@When("user hits the url {string} and {string} results with a response")
	public void user_hits_the_url_and_results_with_a_response(String url, String json) {
		
		RequestSpecification given = RestAssured.given();
		Response response = given.body(json).when().post(url).then().extract().response();
		
		System.out.println("URL: "+uri.getReqresBaseURI()+url);
		System.out.println("Response: "+response.asString());
	}

	@Then("user gets the status code \"\"{int}\"\" for the url {string} and {string}")
	public void user_gets_the_status_code_for_the_url_and(Integer expstatuscode, String url, String json) {
		
		RequestSpecification given = RestAssured.given();
		Response response = given.body(json).when().post(url).then().extract().response();
		
		int statusCode = response.statusCode();
		
		int expectedStatusCode = expstatuscode;
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, expectedStatusCode); 
	}
	
	
	
	/************* PUT METHOD **********************/
	
	@When("user hits the url {string} and {string} results with a put response")
	public void user_hits_the_url_and_results_with_a_put_response(String url, String json) {
		
		RequestSpecification given = RestAssured.given();
		Response response = given.body(json).when().put(url).then().extract().response();
		
		System.out.println("URL: "+uri.getReqresBaseURI()+url);
		System.out.println("Response: "+response.asString());
	}

	@Then("user gets the put status code \"\"{int}\"\" for the url {string} and {string}")
	public void user_gets_the_put_status_code_for_the_url_and(Integer expstatuscode, String url, String json) {
		
		RequestSpecification given = RestAssured.given();
		Response response = given.body(json).when().put(url).then().extract().response();
		
		int statusCode = response.statusCode();
		
		int expectedStatusCode = expstatuscode;
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, expectedStatusCode);
	}
	
	
	
	
	
	/************* PATCH METHOD **********************/
	
	@When("user hits the url {string} and {string} results with a patch response")
	public void user_hits_the_url_and_results_with_a_patch_response(String url, String json) {
		RequestSpecification given = RestAssured.given();
		Response response = given.body(json).when().patch(url).then().extract().response();
		
		System.out.println("URL: "+uri.getReqresBaseURI()+url);
		System.out.println("Response: "+response.asString());
	}

	@Then("user gets the patch status code \"\"{int}\"\" for the url {string} and {string}")
	public void user_gets_the_patch_status_code_for_the_url_and(Integer expstatuscode, String url, String json) {
		RequestSpecification given = RestAssured.given();
		Response response = given.body(json).when().patch(url).then().extract().response();
		
		int statusCode = response.statusCode();
		
		int expectedStatusCode = expstatuscode;
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, expectedStatusCode);
	}
	
	
	
	
	
	/************* DELETE METHOD **********************/
	
	@When("user delete the url {string} results with a response")
	public void user_delete_the_url_results_with_a_response(String url) {
		
		RequestSpecification given = RestAssured.given();
		Response response = given.delete(url); //url hitting
		
		System.out.println("URL: "+uri.getReqresBaseURI()+url);
		System.out.println("Response: "+response.asString());
	}

	@Then("user gets the status code \"\"{int}\"\" for the url {string} deleted")
	public void user_gets_the_status_code_for_the_url_deleted(Integer statcode, String url) {
		
		RequestSpecification given = RestAssured.given();
		
		Response response = given.delete(url); //url hitting
		
		int statusCode = response.statusCode();
		
		int expSC = statcode;
		
		System.out.println("Status code: "+statusCode);
		
		Assert.assertEquals(statusCode, expSC); //Actual vs expected
	}
	
	
	
}	