package testng;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.toolsqa.com/automation-practice-form/");

	}

	@Test
	public void dropDownTest() {

		/*
		 * String[] country_s = { "ABC", "Europe", "Africa", "Australia", "goa",
		 * "South America", "North America", "Antarctica", "CDE" };
		 * 
		 * // Created a expected String list List<String> expected_List = new
		 * ArrayList<String>();
		 * 
		 * // here the for loop to add the values in expected String list for (int i =
		 * 0; i < country_s.length; i++) {
		 * 
		 * expected_List.add(country_s[i]); }
		 */

		Xls_Reader reader = new Xls_Reader("./src/test/resources/testData/testData.xlsx");

		// Created a expected String list
		List<String> expected_List = new ArrayList<String>();

		int rowCount = reader.getRowCount("countryTestdata");

		// Fetch value from the excel and add data in expected_List Array
		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			// System.out.println(reader.getCellData("countryTestdata", "countryName",
			// rowNum));
			expected_List.add(reader.getCellData("countryTestdata", "countryName", rowNum));

		}

		// Print the value from the array
		for (String val : expected_List) {

			System.out.println(val);
		}

		// Now, created a actual List
		List<String> actual_list = new ArrayList<String>();

		WebElement dropDown = driver.findElement(By.id("continentsmultiple"));

		Select sl = new Select(dropDown);

		List<WebElement> dropDownValues = sl.getOptions();

		System.out.println(dropDownValues.size());

		for (WebElement ele : dropDownValues) {

			actual_list.add(ele.getText());

		}

		Assert.assertEquals(actual_list, expected_List, listCompareAndFetchData(expected_List, actual_list));

	}

	/**
	 * List compare and fetch data.
	 *
	 * @param expected the expected
	 * @param actual   the actual
	 * @return the string
	 */
	public static String listCompareAndFetchData(List<String> expected, List<String> actual) {

		return ("Expected Data missing : "
				+ expected.stream().filter(aObject -> !actual.contains(aObject)).collect(Collectors.toList()).toString()
				+ "Actual Data found :" + actual.stream().filter(aObject -> !expected.contains(aObject))
						.collect(Collectors.toList()).toString());

	}

}
