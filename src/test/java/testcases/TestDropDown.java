package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDown {

	public static WebDriver driver;

	public static void main(String args[]) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://www.wikipedia.org/");
		
		WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		Select se = new Select(dropDown);
		//se.selectByValue("nan");
		//se.selectByVisibleText("Dansk");
		//se.selectByIndex(2);
		
		

		List<WebElement> values = dropDown.findElements(By.tagName("option"));
		
		System.out.println(values.size());
			
		
		// print specific index values
		
		System.out.println(values.get(7).getText());
	
		for(int i=0;i<values.size();i++) {
			
			
			System.out.println(values.get(i).getAttribute("lang")+"----Language name is-----"+values.get(i).getText());
			
		}
		
		System.out.println("---------------------Print All Links---------------------");
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[8]/div[3]"));
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println("Total Links "+links.size());
		
		for(WebElement link : links) {
			
			
			System.out.println(link.getText()+"----URL Is---"+link.getAttribute("href"));
		}
		
		
	}
	

}
