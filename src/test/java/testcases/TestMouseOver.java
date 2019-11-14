package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {
	
	public static WebDriver driver;
	
	public static WebDriverWait wait;
	
	
	
	public static void main(String args[]) {
		
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://flipkart.com");
		
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
		System.out.println(driver.getTitle());
		
		WebElement menu = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(menu).perform();
		
	
		driver.findElement(By.linkText("Shirts")).click();
		
	//	wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Jeans"))).click();
		
		
		
	}

}
