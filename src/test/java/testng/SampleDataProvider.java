package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider {

	@Test(dataProvider = "dataProvider")
	public void testMethod(String data) {

		System.out.println("Data is " + data);

	}

	@DataProvider(name = "dataProvider")
	public Object[][] dataProviderMethod() {

		return new Object[][] {

				{ "data one" }, { "data two" }

		};
	}

}
