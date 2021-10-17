package net.revature.testrunner;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import net.revature.purchaseItems.BuyItem;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunfromHome {

	private static WebDriver driver;

	By chec = By.xpath("/a[@href='aaaaa']");
//	By cls = By.ByClassName("col-xs-12 col-sm-6 col-md-3")

	
	@BeforeClass
	public static void setUp() {
	
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		driver = new ChromeDriver();
    
		driver.get("http://localhost:4200/categories");
//		driver.get("http://localhost:4200/products/id/1");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		System.out.println(driver.getCurrentUrl());
//		driver.findElement(chec).click();
//		Assert.assertEquals("http://localhost:4200/products/id/127", driver.getCurrentUrl(), "error message");
		
		@Test
		public void categories() {
//			driver.get("http://localhost:4200/categories");
			BuyItem clck= new BuyItem(driver);
			clck.catagories();
			 
			System.out.println(driver.getCurrentUrl() +"catagories");
			Assert.assertEquals("http://localhost:4200/products/all/1", driver.getCurrentUrl(), "error message");
		}
		
		@Test
		public void product() {
//			driver.get("http://localhost:4200/products/all/1");
			System.out.println(driver.getCurrentUrl()+"product");
			BuyItem clck= new BuyItem(driver);
			clck.product();
			
			Assert.assertEquals("http://localhost:4200/products/id/127", driver.getCurrentUrl(), "error message");
			
		}

		
//		@Test
//		public void addToCart() {
//			driver.get("http://localhost:4200/products/id/127");
//			BuyItem clck= new BuyItem(driver);
//			clck.addToCart();
//			driver.switchTo().alert().dismiss();
//
//		}
		
			
//			System.out.println(driver.getCurrentUrl()+ "from product");
//			WebElement usernameBox = driver.findElement(By.id("prdt"));
//			usernameBox.click();		
//		@Test
//		public void checkout() {
//			BuyItem clck= new BuyItem(driver);
//			System.out.println(driver.getCurrentUrl() + "from checkout");
////			clck.addToCart();
//		}
}
