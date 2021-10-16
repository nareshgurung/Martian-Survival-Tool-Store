package net.revature.signingIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarLogin {


	@FindBy(id="username")
	private WebElement usernameBox;
	@FindBy(id="password")
	private WebElement passwordBox;
	@FindBy(id="login_button")
	private WebElement loginButton;
	
	
	public MarLogin(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(usernameBox));
	}
	
	public void login(String username, String password) {
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		loginButton.click();
	}
}
