package br.com.api;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AlterarSimulacao {
	
	@Test
	public void AlteracaoSimulacao() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("nome", "Juliana Avila");
		json.put("cpf", "48109426000");
		json.put("email", "juliana@gmail.com");
		json.put("valor", 3000);
		json.put("parcelas", 3);
		json.put("seguro", true);

		request.body(json.toString());
		Response response = request.put("http://localhost:8080/api/v1/simulacoes/48109426000");
		assertEquals(200, response.getStatusCode());
		System.out.println("response" + response.asString());
		System.out.println("Alteração realizada com sucesso , codigo de retorno é : " + response.getStatusCode());

	}
	
	@Test
	public void AlteracaoSimulacaoFalha() {

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		json.put("nome", "Juliana Avila");
		json.put("cpf", "12990367790");
		json.put("email", "juliana@gmail.com");
		json.put("valor", 2000);
		json.put("parcelas", 3);
		json.put("seguro", true);

		request.body(json.toString());
		Response response = request.put("http://localhost:8080/api/v1/simulacoes/12990360");
		String responseBodyAsString = response.getBody().asString();
		Assert.assertTrue(responseBodyAsString.contains("não encontrado"));
		assertEquals(404, response.getStatusCode());
		System.out.println( response.asString());
		System.out.println("codigo de retorno é : " + response.getStatusCode());


	}

}
