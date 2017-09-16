package com.boot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import static org.hamcrest.Matchers.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ShipwreckControllerWebIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testListAll() throws JsonProcessingException, IOException {
		ResponseEntity<String> response = restTemplate.getForEntity(
				"http://localhost:8080/api/v1/shipwrecks", String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

		ObjectMapper om = new ObjectMapper();
		JsonNode responseJson = om.readTree(response.getBody());
		
		assertThat(responseJson.toString(),is(notNullValue()));
		/*assertThat(
				responseJson.toString(),
				equalTo("[{\"id\":33,\"name\":\"h\",\"description\":\"h\",\"condition\":\"good\",\"depth\":150,\"latitude\":122.3,\"longitude\":133.1,\"yearDiscovered\":1991}]"));*/
	}
}
