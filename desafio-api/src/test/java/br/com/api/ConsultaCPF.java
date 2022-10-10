package br.com.api;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsultaCPF {

	@Test
	public void consultaRestricao() {

		Response response = RestAssured.get("http://localhost:8080/api/v1/restricoes/48109426000");
		System.out.println(response.asPrettyString());
		System.out.println("codigo de retorno é : " + response.getStatusCode());
		int code = response.getStatusCode();
		String responseBodyAsString = response.getBody().asString();
		assertEquals(200, code);
		Assert.assertTrue(responseBodyAsString.contains("tem problema"));
	}
	
	//usando hamcrest.Matchers

	@Test
	public void consultaRestricao2() {
		given()
		.when()
			.get("http://localhost:8080/api/v1/restricoes/97093236014")
		.then()
			.statusCode(200)
			.body("mensagem", containsString("tem problema"))

		;			
	}
		 
	 
}
