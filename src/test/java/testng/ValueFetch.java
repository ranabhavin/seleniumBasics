package testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValueFetch {

	public static WebDriver driver;

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

		List<WebElement> liElements = driver.findElements(By.xpath("//li[@class='tree-branch']"));

		System.out.println(liElements.size());

		for (int i = 1; i < liElements.size(); i++) {

			System.out.println(i);
			
			WebElement ele = driver.findElement(By.cssSelector("li.tree-branch > ul > li.tree-branch:nth-child("+i+") > a"));
			System.out.println(ele.getText());

		}
	}

}
