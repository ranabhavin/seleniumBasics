package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoPackSafe {

	public static WebDriver driver;

	public static WebDriverWait wait;

	public static void main(String args[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

		driver.get("https://www.pacsafe.com/default");
		
		

		driver.findElement(By.xpath("//button[@title='Close']")).click();

		// System.out.println(driver.getTitle());

		// System.out.println(driver.getCurrentUrl());

		// WebElement second_popup =
		// driver.findElement(By.xpath("//button[@title='Close']"));

		// wait.until(ExpectedConditions.elementToBeClickable(second_popup));

		// second_popup.click();

		/*
		 * driver.get("https://www.pacsafe.com/default	");
		 * 
		 * 
		 * 
		 */
		

		WebElement second_popup = driver.findElement(By.cssSelector(".ui-button-text"));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", second_popup);
		
		//second_popup.click();
		
		/*
		 * Actions ac = new Actions(driver);
		 * 
		 * ac.sendKeys(Keys.PAGE_UP).build().perform();;
		 * 
		 * ac.moveToElement(second_popup).click().build().perform();
		 */

		/*
		 * System.out.println(driver.getCurrentUrl());
		 * 
		 * Actions ac = new Actions(driver); ac.sendKeys(Keys.ESCAPE);
		 * 
		 * 
		 * Thread.sleep(5000);
		 * 
		 * Actions ac1 = new Actions(driver); ac1.sendKeys(Keys.ESCAPE);
		 */

	}
}
