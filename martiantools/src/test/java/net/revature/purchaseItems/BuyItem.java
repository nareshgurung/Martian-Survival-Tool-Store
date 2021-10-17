package net.revature.purchaseItems;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyItem {
		
	@FindBy(className="cat")
	private List<WebElement> catBox;
	@FindBy(id="prdt")
	private WebElement checkBox;
	
	@FindBy(className="addcart")
	private WebElement cartBox;
//	@FindBy(xpath=["routerLink=/products/id/{{prod.product_id}}"])
//	private List<WebElement> aabox;
	

	
	public BuyItem(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void catagories() {
		catBox.get(0).click();
	}
//	
	public  void product() {
//		WebElement usernameBox = driver.findElement(By.id("prdt"));
		checkBox.click();
	}
	public void addToCart() {
		cartBox.click();
		
	}
}
