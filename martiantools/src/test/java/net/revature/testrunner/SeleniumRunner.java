package net.revature.testrunner;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import net.revature.signingIn.MarLogin;

public class SeleniumRunner {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
	
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://localhost:4200");
		
	}
	
	@Test
	public void login() {
		MarLogin loginpage = new MarLogin(driver);
		
		loginpage.login("paktt", "Powerful");
		
		Assert.assertEquals("http://localhost:4200/login", driver.getCurrentUrl(), "error message");
		System.out.println(driver.getCurrentUrl());
	}
}
