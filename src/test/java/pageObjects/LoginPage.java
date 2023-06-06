package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='Email']")WebElement userNameTextbox;
	@FindBy(id="Password")WebElement passwordTextbox;
	@FindBy(xpath="//button[contains(@class,'button-1')]")WebElement loginButton;
	@FindBy(xpath="//a[text()='Logout']")WebElement logoutButton;
	
	public void userName(String username) {
		userNameTextbox.clear();
		userNameTextbox.sendKeys(username);
	}
	public void passWord(String password) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
	}
	public void loginBtn()  {
		loginButton.click();
	}
	public void logoutBtn()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		logoutButton.click();
	}

}
