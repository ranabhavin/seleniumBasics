package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoJavaScript {
	
public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		jse.executeScript("document.getElementById('input-email').setAttribute('value','ravi.kiran1@gmail.com')");
		jse.executeScript("document.getElementById('input-password').setAttribute('value','rkiran')");
		jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@value='Login']")));
		
		
	}

}
