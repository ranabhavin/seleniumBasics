package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	@Test(priority =1)
	public void validateTitle() {

		String actual_title = "yahoo.com";

		String expected_title = "gamil.com";

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actual_title, expected_title);
		
		soft.assertAll();
		
		//Assert.assertEquals(actual_title, expected_title);
	}
	
	@Test(priority =2)
	public void element() {

		Assert.assertTrue(true, "Element not found");
	}
}
