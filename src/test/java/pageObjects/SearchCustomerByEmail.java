package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByEmail {
	public WebDriver driver;
	
	public SearchCustomerByEmail(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@id='SearchEmail']")WebElement searchemail;
	@FindBy(xpath="//input[@id='SearchFirstName']")WebElement searchfirstname;
	@FindBy(xpath = "//input[@id='SearchLastName']")WebElement searchlastname;
	@FindBy(xpath = "//button[@id='search-customers']")WebElement searchbutton;
	//these xpath has written to know that the email id which we enter is present in the table or not
	
      @FindBy(xpath = "//table[@id='customers-grid']")WebElement table;
      @FindBy(xpath = "//table[@id='customers-grid']//tbody//tr")WebElement tablerow;
      @FindBy(xpath = "//table[@id='customers-grid']//tbody//tr//td")WebElement tablecolumn;
	public void searchEmail(String email) {
		searchemail.sendKeys(email);
	}
	public void searchFirstName(String firstname) {
		searchfirstname.sendKeys(firstname);
	}
	public void searchLastName(String lastname) {
		searchlastname.sendKeys(lastname);
	}
	public void searchButton() {
		searchbutton.click();
	}
	
	
	
}
