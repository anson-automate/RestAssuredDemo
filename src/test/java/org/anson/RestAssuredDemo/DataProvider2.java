package org.anson.RestAssuredDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataProvider2 extends DataForTest {

	// @Test(dataProvider = "postProvider")
	public void postTest(String name, int age, String job) {

		// create
		baseURI = "http://localhost:3000";
		JSONObject jo = new JSONObject();
		jo.put("name", name);
		jo.put("age", age);
		jo.put("job", job);

		/// user accept and contentType while creating given section
		given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jo.toJSONString()).when().post("/users")
				.then().log().all();

	}

	//@Test(dataProvider = "delProvider")
	public void deleteTest(int userId) {

		// create
		baseURI = "http://localhost:3000";

		/// user accept and contentType while creating given section
		given().when().delete("/users/" + userId).then().log().all().statusCode(200);

	}

	@Test(dataProvider = "excelData")
	public void postTestExcel(Object name, Object age, Object job) {

		// create
		baseURI = "http://localhost:3000";
		JSONObject jo = new JSONObject();
		jo.put("name", name.toString());
		jo.put("age", Integer.valueOf(age.toString()));
		jo.put("job", job.toString());

		/// user accept and contentType while creating given section
		given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jo.toJSONString()).when().post("/users")
				.then().log().all();

	}

}
