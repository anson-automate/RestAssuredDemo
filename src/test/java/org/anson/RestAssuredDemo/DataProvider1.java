package org.anson.RestAssuredDemo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataProvider1 {
	
	@DataProvider(name="provi")
	public Object[][] dataPro(){
		Object[][] pstObj = new Object[2][3];
		
		pstObj[0][0]="test11";
		pstObj[0][1]=60;
		pstObj[0][2]="finisher";
		
		pstObj[1][0]="test112";
		pstObj[1][1]=68;
		pstObj[1][2]="beginner";
		
		
		return pstObj;
	}
	
	@Test(dataProvider = "provi")
		public void postTest(String name,int age,String job) {
			
			// create 
			baseURI ="http://localhost:3000";
			JSONObject jo = new JSONObject();
			jo.put("name", name);
			jo.put("age", age);
			jo.put("job", job);
			
			/// user accept and contentType while creating given section
		given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jo.toJSONString()).when().post("/users").then().log().all();

			
		}

}
