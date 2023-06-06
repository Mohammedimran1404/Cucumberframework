package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByFirstandLastName {
	
	public WebDriver driver;
	
	public SearchCustomerByFirstandLastName(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@id='SearchFirstName']")WebElement searchfirstname;
	@FindBy(xpath ="//input[@id='SearchLastName']")WebElement searchlastname;
	@FindBy(xpath ="//button[@id='search-customers']")WebElement clicksearchbutton;
	
	public void searchFirstName(String fname) {
		searchfirstname.sendKeys(fname);
	}
	public void searchLastName(String lname) {
		searchlastname.sendKeys(lname);
	}
	public void clickOnSearchButton() {
		clicksearchbutton.click();
	}

}
