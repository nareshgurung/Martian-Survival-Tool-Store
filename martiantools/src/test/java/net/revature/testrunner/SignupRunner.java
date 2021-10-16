package net.revature.testrunner;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import net.revature.signingIn.SignUp;

public class SignupRunner {

private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() {
	
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/signup");
		
	}
	
	@Test
	public void signup() {
		SignUp signupPage = new SignUp(driver);
		
		signupPage.signUp(1, "Wil@gmail.com", "William", "k", "Smith", "walker", 1289, "Atlanta", "GA", "wilsm", "password");
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals("http://localhost:4200/signup", driver.getCurrentUrl(), "error message");
	}
}
