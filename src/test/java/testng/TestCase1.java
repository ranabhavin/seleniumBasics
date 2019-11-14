package testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {

	@BeforeMethod
	public void beforeTest() {

		System.out.println("Open Browser");
	}

	@AfterMethod
	public void close() {

		System.out.println("Close browser");
	}

	@BeforeTest
	public void createConnect() {

		System.out.println("Create connection");
	}

	@AfterTest
	public void closeConnect() {

		System.out.println("Close connect");
	}

	@Test(priority = 1)
	public void login() {

		System.out.println("Executing login test");

	}

	@Test(priority = 3)
	public void register() {

		System.out.println("Executing registration");
	}

	@Test(priority = 4)
	public void jtest() {

		System.out.println("System");
	}

	@Test(priority = 2)
	public void mTest() {

		System.out.println("Mtest");
	}

}
