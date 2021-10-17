package net.revature.testrunner;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PurchaseProduct {
	
	private static WebDriver driver;

	
	
	@BeforeClass
	public static void setUp() {
	
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		driver = new ChromeDriver();
    
		driver.get("http://localhost:4200/products/id/127");
//		driver.get("http://localhost:4200/products/id/1");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void addToCart() {
//		driver.get("http://localhost:4200/products/id/127");
		WebElement clck = driver.findElement(By.className("addcart"));
		clck.click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.getCurrentUrl() + "from cart");
		Assert.assertEquals("http://localhost:4200/products/id/127", driver.getCurrentUrl(), "error message");
	}
	
	@Test
	public void clickCart() {
		WebElement clck = driver.findElement(By.className("button"));
		clck.click();
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertEquals("http://localhost:4200/cart", driver.getCurrentUrl(), "error message" ) ;
		
	}
	@Test
	public void checkout() {
		driver.get("http://localhost:4200/cart");
		System.out.println(driver.getCurrentUrl()+" from checkfout");
		WebElement fname = driver.findElement(By.id("fname"));
		WebElement mid = driver.findElement(By.id("Midinnitial"));
		WebElement lname = driver.findElement(By.id("lname"));
		WebElement str = driver.findElement(By.id("street"));
		WebElement zp = driver.findElement(By.id("zip"));
		WebElement ct = driver.findElement(By.id("city"));
		WebElement st = driver.findElement(By.id("state"));
		WebElement clck= driver.findElement(By.className("button"));
		
		fname.sendKeys("Danial");
		mid.sendKeys("k");
		lname.sendKeys("white");
		str.sendKeys("pretty line");
		zp.sendKeys(String.valueOf(12458));
		ct.sendKeys("newyork");
		st.sendKeys("va");
		clck.click();
		
		System.out.println(driver.getCurrentUrl()+"from last checkout");
		
		//assert queals will be written after the purchase button worked. 
		
		
	}
}
