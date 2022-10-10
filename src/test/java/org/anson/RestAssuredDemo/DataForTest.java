package org.anson.RestAssuredDemo;

import java.io.IOException;

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
			4,5,6,7,8,9,10,11,12
		};
	}
	
	@DataProvider(name="excelData")
	public Object[][] excelDataPro() throws IOException {
		Util exObj = new Util("./Resource/TestData.xlsx","Sheet1",3);
		Object[][] dataObject = exObj.getTableData();
		
		return dataObject;
	}
}
