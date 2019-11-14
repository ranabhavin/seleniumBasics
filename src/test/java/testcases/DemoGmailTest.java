package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoGmailTest {

	public static String browser = "chrome";

	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {

		// Screenshot Code

		Date d = new Date();

		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File scrshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshot, new File("./screenshot/" + fileName));

	}

	public static void main(String args[]) throws IOException {

		if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://gmail.com");

		// System.out.println(driver.getTitle());

		String title = driver.getTitle();
		System.out.println("Page Title - " + title + " Length -" + title.length());

		driver.findElement(By.id("identifierId")).sendKeys("qa1.orioncoders@gmail.com");

		driver.findElement(By.id("identifierNext")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']")))
				.sendKeys("Orion@1234");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"passwordNext\"]/span/span"))).click();

		System.out.println(driver.findElement(By.xpath(
				"//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"))
				.getText());
		captureScreenshot();

		driver.close();

	}

}
