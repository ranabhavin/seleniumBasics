package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeywordApproach {

	public static WebDriver driver;

	public static Logger log = Logger.getLogger(TestProperties.class.getSimpleName());

	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static WebDriverWait wait;

	public static void click(String locator) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(locator))).click();

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(or.getProperty(locator))).click();

		} else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(or.getProperty(locator))).click();

		} else if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(or.getProperty(locator))).click();
		}

		log.info("Clicking on Element : " + locator);
	}

	public static void type(String locator, String value) {

		if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_NAME")) {
			driver.findElement(By.name(or.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);

		}

		log.info("Typing in an Element :" + locator + "Added value is :" + value);
	}

	public static void waitElement(String locator) {

		if (locator.endsWith("_XPATH")) {

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty(locator)))).click();
		} else if (locator.endsWith("_ID")) {

			wait.until(ExpectedConditions.elementToBeClickable(By.id(or.getProperty(locator)))).click();
		} else if (locator.endsWith("_NAME")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(or.getProperty(locator)))).click();
			
		} else if (locator.endsWith("_CSS")) {

			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(or.getProperty(locator)))).click();
		}
		
		log.info("Waiting on Element to action: " + locator);
		
	}

	public static void main(String args[]) throws IOException {

		PropertyConfigurator.configure("./src/test/resources/log/log4j.properites");

		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		or.load(fis);
		log.info("OR properties file Loaded");
		System.out.println(or.getProperty("useremail_ID"));

		// Code for config Properties file

		fis = new FileInputStream("./src/test/resources/properties/config.properties");
		config.load(fis);
		log.info("config file loaded");
		System.out.println(config.getProperty("testSiteURL"));

		if (config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Driver called");

		} else if (config.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox Driver called");

		} else {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Driver called");
		}

		driver.get(config.getProperty("testSiteURL"));
		log.info("URl Called :" + config.getProperty("testSiteURL"));

		driver.manage().window().maximize();
		log.info("Window maximized");

		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicit.wait")));

		type("useremail_ID", "qa1.orioncoders@gmail.com");
		waitElement("useremailNextBtn_ID");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("userPassword_XAPTH"))))
				.sendKeys("Orion@1234");

		try {

			waitElement("userPasswordNextBtn_XPATH");
		} catch (Throwable t) {
			log.error(t.getMessage());
		}

		System.out.println(driver.findElement(By.xpath(or.getProperty("userInvalidPasswordText_XPATH"))).getText());
		
	}

}
