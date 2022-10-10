package br.com.api;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConsultaSimulacao {
	
	@Test
	public void consultaSimulacoes() {

		Response response = RestAssured.get("http://localhost:8080/api/v1/simulacoes");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		assertEquals(200, code);
	}
	@Test
	public void consultaSimulacoesCPFValido() {

		Response response = RestAssured.get("http://localhost:8080/api/v1/simulacoes/66414919004");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		int code = response.getStatusCode();
		assertEquals(200, code);
	}
	
	@Test
	public void consultaSimulacoesCPFInvalido() {

		Response response = RestAssured.get("http://localhost:8080/api/v1/simulacoes/9999999");
		System.out.println(response.asPrettyString());
		System.out.println("Status code " + response.getStatusCode());
		int code = response.getStatusCode();
		String responseBodyAsString = response.getBody().asString();
		assertEquals(404, code);
		Assert.assertTrue(responseBodyAsString.contains("n�o encontrado"));

	}
 
	



}
