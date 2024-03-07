package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name="LoginDetails")
	public Object[][] login() {
		Object [][] arr =ExcelReader.getDataFromSheet("login");
		return arr;
	}
	
}
