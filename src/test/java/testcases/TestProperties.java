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

public class TestProperties {

	public static WebDriver driver;

	public static Logger log = Logger.getLogger(TestProperties.class.getSimpleName());

	public static void main(String args[]) throws IOException {
		
		PropertyConfigurator.configure("./src/test/resources/log/log4j.properites");

		// Code for OR Properties file
		Properties or = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		or.load(fis);
		log.info("OR properties file Loaded");
		System.out.println(or.getProperty("useremail_ID"));

		// Code for config Properties file
		Properties config = new Properties();
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

		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(config.getProperty("explicit.wait")));

		// Enter User email
		driver.findElement(By.id(or.getProperty("useremail_ID"))).sendKeys("qa1.orioncoders@gmail.com");
		log.info("Email entered " + "qa1.orioncoders@gmail.com");

		// Click on next button
		wait.until(ExpectedConditions.elementToBeClickable(By.id(or.getProperty("useremailNextBtn_ID")))).click();
		log.info("Next button clicked");

		// Enter password
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("userPassword_XAPTH"))))
				.sendKeys("Orion@1234");
		log.info("Password added");

		// Click on next button
		try {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("userPasswordNextBtn_XPATH"))))
				.click();
		}catch (Throwable t) {
			log.error(t.getMessage());
		}
		log.info("Next button clicked");

		// Get error message
		System.out.println(driver.findElement(By.xpath(or.getProperty("userInvalidPasswordText_XPATH"))).getText());
	

	}
}
