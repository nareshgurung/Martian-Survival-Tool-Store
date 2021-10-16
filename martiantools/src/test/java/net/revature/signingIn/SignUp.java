package net.revature.signingIn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {
	
	@FindBy(id="role")
	private WebElement roleBox;
	@FindBy(id="email")
	private WebElement emailBox;
	@FindBy(id="fname")
	private WebElement fnameBox;
	@FindBy(id="Midinnitial")
	private WebElement midinnitialBox;
	@FindBy(id="lname")
	private WebElement lnameBox;
	@FindBy(id="street")
	private WebElement streetBox;
	@FindBy(id="zip")
	private WebElement zipBox;
	@FindBy(id="city")
	private WebElement cityBox;
	@FindBy(id="state")
	private WebElement stateBox;
	@FindBy(id="username")
	private WebElement usernameBox;
	@FindBy(id="password")
	private WebElement passwordBox;
	@FindBy(id="signup")
	private WebElement signupBox;
	
	
	public SignUp(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(signupBox));
	}
	
	public void signUp(int role, String email, String fname, String midname, String lname, String street,
					int zip, String city, String state, String username, String password) {

		roleBox.sendKeys(String.valueOf(role));
		emailBox.sendKeys(email);
		fnameBox.sendKeys(fname);
		midinnitialBox.sendKeys(midname);
		lnameBox.sendKeys(lname);
		streetBox.sendKeys(street);
		zipBox.sendKeys(String.valueOf(zip));
		cityBox.sendKeys(city);
		stateBox.sendKeys(state);
		usernameBox.sendKeys(username);
		passwordBox.sendKeys(password);
		signupBox.click();
	}

}
