package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {
	
	WebDriver driver;
	public CustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// username
	By username=By.xpath("//input[@id='Email']");
	// password
	By pAssword=By.id("Password");
	// loginbtn
	By loginbtn=By.xpath("//button[contains(@class,'button-1')]");
	// customer menu to click
	By customermenu=By.xpath("//a[@href='#']//p[normalize-space(text())='Customers']");
	// customer menu item to click
	By customermenuitem=By.xpath("//div[@id='sidebar-overlay']/ancestor::div/descendant::a[26]/child::p");
	//addnew button to click
	By addnewbtn=By.xpath("//a[@class='btn btn-primary']");
	// enter email as text
	By email=By.xpath("//input[@id='Email']");
	// enter password
	By password = By.xpath("//input[@id='Password']");
	// enter firstname
	By firstname=By.xpath("//input[@id='FirstName']");
	// enter last name
	By lastname=By.xpath("//input[@id='LastName']");
	// click on radio button
	By maleradiobtn = By.xpath("//input[@id='Gender_Male']");
	// female radio button
	By femaleradiobtn=By.xpath("//input[@id='Gender_Female']");
	// date of birth
	By dateofbirtth=By.xpath("//input[@id='DateOfBirth']");
	// company name
	By compyname=By.xpath("//input[@id='Company']");
	// news letter is dropdown
	By newsletter = By.xpath("//input[@id='Company']/following::div[14]");
	// customer role
	By customerrole=By.xpath("//select[@id='SelectedCustomerRoleIds']/preceding-sibling::div/parent::div");
	// administrator
	By administrator=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[text()='Administrators']");
	// moderators
	By moderators=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[text()='Forum Moderators']");
	//guests
	By guests=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[text()='Guests']");
	//regester
	By regester=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[text()='Registered']");
	//vendors
	By vendor=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[text()='Vendors']");
	//managerofvendor
	By managerofvendor=By.xpath("//select[@id='VendorId']");
	// to save button
	By savebtn=By.xpath("//button[@name='save']");
	
	
	public String getTitle() {
	return	driver.getTitle();
	}
	public void userName(String user) {
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
	}
	public void Password(String passwo) {
		driver.findElement(pAssword).clear();
		driver.findElement(pAssword).sendKeys(passwo);
	}
	public void login() {
		driver.findElement(loginbtn).click();
	}
	public void customerMenu() {
		driver.findElement(customermenu).click();
	}
	public void customerMenuItem() {
		driver.findElement(customermenuitem).click();
	}
	public void addNewBtn() {
		driver.findElement(addnewbtn).click();
	}
	public void emailId(String emailid) {
		driver.findElement(email).sendKeys(emailid);
	}
	public void passWord(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void firstName(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}
	public void lastName(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}
	public void radioBtn(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			driver.findElement(maleradiobtn).click();
		}
		else {
			driver.findElement(femaleradiobtn).click();
		}
	}
	public void dateOfBirth(String dateofBirth) {
		driver.findElement(dateofbirtth).sendKeys(dateofBirth);
	}
	public void companyName(String compnyname) {
		driver.findElement(compyname).sendKeys(compnyname);
	}
	public void customerRoles(String role) throws InterruptedException {
		driver.findElement(customerrole).click();
		WebElement list;;
//		Thread.sleep(3000);
		if(role.equalsIgnoreCase("Administrators")) {
		list=driver.findElement(administrator);
			list.click();
		}
		else if(role.equalsIgnoreCase("Forum Moderators")) {
		list=driver.findElement(moderators);
		list.click();
		
		}
		else if(role.equalsIgnoreCase("Guests")) {
			list=driver.findElement(guests);
			list.click();
		}
		else if(role.equalsIgnoreCase("Registered")) {
			list=driver.findElement(regester);
			list.click();
		}
		else {
			list=driver.findElement(vendor);
			list.click();
		}
		
	}
	public void managerOfVendor(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement mang=driver.findElement(managerofvendor);
		Select sele=new Select(mang);
		sele.selectByValue(value);	
	}
	public void saveButton() {
		driver.findElement(savebtn).click();
	}


}
// if(!role.equalsIgnoreCase("Vendors")) {
//driver.findElement(By.xpath("//select[@id='SelectedCustomerRoleIds']"));
//}