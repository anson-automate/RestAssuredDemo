package org.anson.RestAssuredDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class RestWithMock {
	
	//@Test
	public void testGet() {
		baseURI ="http://localhost:3000";
		JsonPath se = given().param("name", "anson").when().get("/users").jsonPath();
		
		String name = String.valueOf(se.get("job"));
		System.out.println(" age "+name.replace("[", "").replace("]", ""));
		
		
	}
	
	//@Test
	public void postTest() {
		
		// create 
		baseURI ="http://localhost:3000";
		JSONObject jo = new JSONObject();
		jo.put("name", "test");
		jo.put("age", 7);
		jo.put("job", "NA");
		//jo.put("id", 51);
		
		/// user accept and contentType while creating given section
	given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jo.toJSONString()).when().post("/users").then().log().all();

		
	}
	
	//@Test
	public void putTest() {
		
		// create 
		baseURI ="http://localhost:3000";
		JSONObject jo = new JSONObject();
		jo.put("name", "test");
		jo.put("age", 7);
		jo.put("job", "NA");
		//jo.put("id", 51);
		
		/// user accept and contentType while creating given section
	given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jo.toJSONString()).when().put("/users/5").then().log().all();

		
	}
	
	@Test
	public void deleteTest() {
		
		// create 
		baseURI ="http://localhost:3000";

		
		/// user accept and contentType while creating given section
	given().when().delete("/users/6").then().log().all().statusCode(200);

		
	}
	

}
