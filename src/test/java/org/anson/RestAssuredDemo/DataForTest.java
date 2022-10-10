package org.anson.RestAssuredDemo;

import org.testng.annotations.DataProvider;

public class DataForTest {

	@DataProvider(name="postProvider")
	public Object[][] dataPro(){
		return new Object[][] {
			{"abd",9,"test"},{"ytsd",10,"load"}
		};
	}
	
	@DataProvider(name="delProvider")
	public Object[] dataProDel(){
		return new Object[]{
			4,5
		};
	}
}
