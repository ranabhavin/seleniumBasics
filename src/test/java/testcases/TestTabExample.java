package testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabExample {

	public static WebDriver driver;

	public static String baseUrl;

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		baseUrl = "http://www.google.co.uk/";
		driver.get(baseUrl);
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> windows = driver.getWindowHandles();

		List<String> ls = new ArrayList<String>(windows);

		String parentWindowsID = ls.get(0);

		String childWindowID = ls.get(1);

		System.out.println(parentWindowsID);

		System.out.println(childWindowID);

		System.out.println("After switching title is " + driver.getTitle());

		driver.get("http://www.facebook.com");

		System.out.println("After switching title is " + driver.getTitle());

		driver.close();

		driver.switchTo().window(parentWindowsID);
		System.out.println(driver.getTitle());

		 System.out.println("Parent Window title is "+driver.getTitle());
		    
		/*
		 * ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 * 
		 * 
		 * 
		 * 
		 * driver.switchTo().window(tabs.get(0)); // switch back to main screen
		 * driver.get("https://www.news.google.com");
		 * 
		 * driver.switchTo().window(tabs.get(1)); //switches to new tab
		 * driver.get("https://www.facebook.com");
		 */

	}

}
