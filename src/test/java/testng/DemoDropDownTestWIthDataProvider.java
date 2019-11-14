package testng;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoDropDownTestWIthDataProvider {

	public static WebDriver driver;

	@BeforeMethod()
	public void setup() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.toolsqa.com/automation-practice-form/");

	}

	// Data fetch from excel
	@DataProvider(name = "testData")
	public void getTestData() {
		
		

	}

	@Test(dataProvider = "testData")
	public void dropDownTest(String countryName) {

		// Fetch Data from the dropdown
		WebElement dropDown = driver.findElement(By.id("continentsmultiple"));

		Select sl = new Select(dropDown);

		List<WebElement> dropDownValues = sl.getOptions();

		System.out.println(dropDownValues.size());

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
