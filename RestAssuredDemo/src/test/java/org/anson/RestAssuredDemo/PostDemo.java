package org.anson.RestAssuredDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



public class PostDemo {
	
	@Test
	void testPost_1() {
		baseURI="https://reqres.in/api";
		
		// creating body
		JSONObject bdyJsn = new JSONObject();
		bdyJsn.put("name", "Anson");
		bdyJsn.put("job", "Qa");
		given().body(bdyJsn.toJSONString()).when().post("/users").then().log().all();
		
		
	}

}
