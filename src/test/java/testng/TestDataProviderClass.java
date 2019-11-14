package testng;

import org.testng.annotations.Test;

public class TestDataProviderClass {

	@Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
	public void testMethod(String data) {

		System.out.println("Data is " + data);
	}

}
