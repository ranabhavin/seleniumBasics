package com.datadriven.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Utility.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demoExcelClass {

	public static WebDriver driver;

	public static void main(String args[]) {

		Xls_Reader reader = new Xls_Reader("./src/test/resources/testData/testData.xlsx");

		String countryData = reader.getCellData("countryTestdata", "countryName", 4);

		System.out.println(countryData);
		
		

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		

		WebElement dropDown = driver.findElement(By.id("continentsmultiple"));

		Select sl = new Select(dropDown);
		
		

		List<WebElement> dropDownValues = sl.getOptions();

	}

}
