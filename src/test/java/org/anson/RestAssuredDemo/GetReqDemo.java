package org.anson.RestAssuredDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReqDemo {
	
	
	@Test
	void TestStatusCode() {

		RequestSpecification req = given().when();
		Response res = req.get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(res.getStatusCode(), 200);
		
		//res.then().body("data[0].id",equalTo(6));
		
		res.then().body("data.id", hasItems(7,8));

		JsonPath js = res.getBody().jsonPath();
		
		List<Object> li = js.getList("data");
		
	
		System.out.println("No of elements "+li.size());
		
		for (int i = 0; i< li.size();i++) {
			System.out.println("index "+i+" "+js.get("data["+i+"].id"));
		}


	}
	
	@Test
	void test2 () {
		// base uri , param , log all
		baseURI = "https://reqres.in/api";
		given().header("content-type","application/json").param("page", 2).when().get("/users").then().log().all();
	}

}
