package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoTabExample {

	public static WebDriver driver;
	private static String parentWindowID;
	private static String childWindowID;

	@BeforeTest
	public static void setup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://only-testing-blog.blogspot.com/2014/04/calc.html");

		//Get window id of 1st tab
		parentWindowID = driver.getWindowHandle();

		System.out.println("parent window ID " + parentWindowID);

	}

	@Test
	public static void openTab() {

		// Open tab 2
		driver.switchTo().newWindow(WindowType.TAB);

		// Open URL In 2nd tab.
		driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");

		// Get a window ID of 2nd tab
		childWindowID = driver.getWindowHandle();

		System.out.println("child window ID " + childWindowID);

		// switch to 1st tab
		driver.switchTo().window(parentWindowID);

		// perform required actions on tab 1.
		driver.findElement(By.xpath("//input[@id='6']")).click();
		driver.findElement(By.xpath("//input[@id='plus']")).click();
		driver.findElement(By.xpath("//input[@id='3']")).click();
		driver.findElement(By.xpath("//input[@id='equals']")).click();

		// switch to 2nd tab
		driver.switchTo().window(childWindowID);

		// perform required actions on tab 2.
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("hi");
		driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("test");

		// Call switchToTab() function to switch to 1st tab
		driver.switchTo().window(parentWindowID);

		// perform required actions on tab 1.
		String str = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		System.out.println("Sum result Is -> " + str);

	}

}
