package org.anson.RestAssuredDemo;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {

	private XSSFSheet sheetObj;
	private XSSFWorkbook workBookObj;
	private int columnNumber;
	private int rowNumber;

	public Util(String fileName, String sheetName, int columnNumber) {
		try {
			this.workBookObj = new XSSFWorkbook(fileName);
			this.sheetObj = workBookObj.getSheet(sheetName);
			this.columnNumber = columnNumber;
			this.rowNumber = sheetObj.getPhysicalNumberOfRows()-1;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public int getRowCount() throws IOException {
//
//		int numberRows = 0;
//		numberRows = sheetObj.getPhysicalNumberOfRows();
//
//		return numberRows;
//
//	}

	public Object getCellValue(int row, int column) throws IOException {

		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheetObj.getRow(row).getCell(column));

		return value;

	}
	
	public Object[][] getTableData() throws IOException{
		
		Object [][] excelDataTable = new Object[rowNumber][columnNumber];
		System.out.println("RowNumber "+rowNumber+" ColumnNumber "+columnNumber);
		for (int rowItr = 0; rowItr<rowNumber ; rowItr++) {
			for (int colItr = 0; colItr < columnNumber; colItr++) {
				excelDataTable[rowItr][colItr]= getCellValue(rowItr+1,colItr);
			}
		}
	
		return excelDataTable;
		
	}

}
