package org.anson.RestAssuredDemo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReqDemo {

	@Test
	void TestStatusCode() {

		RequestSpecification req = RestAssured.given();
		Response res = req.get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(res.getStatusCode(), 200);

		JsonPath js = res.getBody().jsonPath();
		
		List<Object> li = js.getList("data");
		
	
		System.out.println("No of elements "+li.size());
		
		for (int i = 0; i< li.size();i++) {
			System.out.println("index "+i+" "+js.get("data["+i+"].id"));
//			System.out.println(js.get("data[0].email"));
//			System.out.println(js.get("data[0].first_name"));
//			System.out.println(js.get("data[0].last_name"));
//			System.out.println(js.get("data[0].avatar"));
		}


	}

}
