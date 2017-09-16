package com.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.boot.App;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class ShipWreckStepDefinition {

	@Autowired
	private TestRestTemplate restTemplate;

	private ResponseEntity<String> response;

	@Given("^the client has logged in$")
	public void the_client_has_logged_in() {

	}

	@When("^the client calls /shipwrecks$")
	public void the_client_issues_GET_shipwreck() throws Throwable {
		response = restTemplate.getForEntity(
				"http://localhost:8080/api/v1/shipwrecks", String.class);

		ObjectMapper om = new ObjectMapper();
		JsonNode responseJson = om.readTree(response.getBody());

		System.out.println("response json: " + responseJson);

		assertThat(responseJson.toString(), is(notNullValue()));
	}
	
	@When("^the client calls /shipwrecks/(\\d+)$")
	public void the_client_issues_GET_shipwreck_Id(String id) throws Throwable {
		response = restTemplate.getForEntity(
				"http://localhost:8080/api/v1/shipwrecks/"+id, String.class);

		ObjectMapper om = new ObjectMapper();
		JsonNode responseJson = om.readTree(response.getBody());

		System.out.println("response json with id "+id+" : " + responseJson);

		assertThat(responseJson.toString(), is(notNullValue()));
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode)
			throws Throwable {
		assertThat(response.getStatusCode(), equalTo(HttpStatus.valueOf(statusCode)));
	}

	@And("response contains single message (.*)")
	public void theResponseShouldContainSingleMessage(String message) {
		System.out.println("****Feature file message: "+message);
		System.out.println("========= response body contain status: "+response.getBody().contains(message));
		assertThat(response.getBody().contains(message),is(true));
				
	}
	
	@And("^response contains message \"([^\"]*)\":\"([^\"]*)\" and (.*)$")
	public void theResponseShouldContainTheMessage(String type,String message,boolean result) {
		System.out.println("****Feature file message: "+message);
		System.out.println("****Feature file type: "+type);
		System.out.println("****Feature file result: "+result);
		System.out.println("========= response body contain status: "+response.getBody().contains(message));
		assertThat(response.getBody().contains(message),is(result));
				
	}
}
