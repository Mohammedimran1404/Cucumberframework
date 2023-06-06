package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerByEmail;
import pageObjects.SearchCustomerByFirstandLastName;
import utilities.LogUtility;

public class Steps extends BaseClass{
	public LogUtility logutility=new LogUtility(); // created object for logutility which is present in utilities package
	
	String browser="chrome"; // this work only in steps class only 
	@Before
	public void setUp() {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			 logutility.Info("Chrome browser is launched");
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			 logutility.Info("Edge browser is launched");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			 logutility.Info("Firefox browser is launched");
		}
		else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver=new SafariDriver();
			 logutility.Info("Safari browser is launched");
		}
		else {
			System.out.println("Invalid browser please enter this browser only chrome,edge,firefox,safri");
			 logutility.Info("Invalid browser");
		}
	}
	
	
	@Given(": Launch chrome browser")
	public void launch_chrome_browser() {  
	    lp=new LoginPage(driver);
	}

	@When(": opens url {string}")
	public void opens_url(String Url) {
		driver.get(Url);
		logutility.Info("URL is opened");
		driver.manage().window().maximize();
	    
	}

	@When(": User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String Pass) {
	    lp.userName(email);
	    lp.passWord(Pass);
	    logutility.Info("username and password is entered");

	}

	@When(": Click on login")
	public void click_on_login() {
		lp.loginBtn();
		logutility.Info("Login button is clicked");
	    
	}

	@Then(": Page title should be {string}") // this one method is validating two times one afer login and after logout because of cucumber if common  method in feature file 
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			logutility.Info("Invalid username or password");
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(title,driver.getTitle());
			logutility.Info("Page title matched successfully "+title);
		}
	}

	@When(": User click on logout")
	public void user_click_on_logout() throws InterruptedException {
		lp.logoutBtn();
		logutility.Info("Logout is clicked");
	    
	}
	
	

	@And(": Close browser")
	public void close_browser() {
		driver.close();
		logutility.Info("Browser is closed");
		logutility.Info("----------------------------------------------------------------------------------------------");
	    
	}
	// adding the customer page methods to continue no need of login already there in login class so
	// customer page is using same methods remaning methods has to add
	
	@Given("User launch browser")
	public void user_launch_browser() {
		cp=new CustomerPage(driver);
		
	   
	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		logutility.Info("Url is opened");
	   
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as1(String us, String pa) {
	    cp.userName(us);
	    cp.Password(pa);
	    logutility.Info("username and password is entered");
	}

	@When("User click on login")
	public void user_click_on_login() {
	   cp.login();
	   logutility.Info("login button is clicked");
	}
	
	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
		cp=new CustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", cp.getTitle());
		logutility.Info("Doing assertion for dashboard");
	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() {
		cp.customerMenu();
		logutility.Info("Clicked on customer menu");
	}

	@When("Click on customer menu item")
	public void click_on_customer_menu_item() {
	    cp.customerMenuItem();
	    logutility.Info("Clicked on customer menu item");
	}

	@When("Click on add new button")
	public void click_on_add_new_button() {
		cp.addNewBtn();
		logutility.Info("Clicked on add new button");
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", cp.getTitle());
		logutility.Info("Assertion for add new customer page");
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	   String email=randomstring()+"@gmail.com";
	   cp.emailId(email);
	   cp.passWord("kairos123");
	   cp.firstName("mohammed");
	   cp.lastName("imran");
	   cp.radioBtn("Male");
	   cp.dateOfBirth("12/02/2000");
	   cp.companyName("Kairos");
	 //  cp.customerRoles("Forum Moderators");
	   cp.managerOfVendor("1");
	   logutility.Info("Entering all customer info");
	   
	}

	@When("Click on save button")
	public void click_on_save_button() {
		cp.saveButton();
		logutility.Info("Clicked on saved button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
	   Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	   logutility.Info("Doing assertion for confirmation message");
	}
	@Then("close browser")
	public void close_browser1() {
	   driver.close();
	   logutility.Info("Browser is closed");
	   logutility.Info(" adding customer is closed -------------------------------");
	}
      // this is for search customer 

	@When("Enter customer email")
	public void enter_customer_email() {
		sce=new SearchCustomerByEmail(driver);
		sce.searchEmail("victoria_victoria@nopCommerce.com");
		sce.searchFirstName("Victoria");
		sce.searchLastName("Terces");
		logutility.Info("entering customer email in field");
	}
	@When("Click on search button")
	public void click_on_search_button() {
		sce.searchButton();
		logutility.Info("Click on search button");
	   
	}
	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
	   System.out.println("Email id is present in table");
	   logutility.Info("Email id is present in table");
	}
	@Then("Close browser")
	public void close_browser2() {
	   driver.close();
	   logutility.Info("browser is closed");
	   logutility.Info("Enter customer by email and first name and last named -------------------------------------");
	}
  // user serach email id using first name and last name
	
	

	@Then("User enter first name and last name")
	public void user_enter_first_name_and_last_name() {
		scbfl= new SearchCustomerByFirstandLastName(driver);
		scbfl.searchFirstName("Victoria");
		scbfl.searchLastName("Terces");
		logutility.Info("Searching customer by first name and lastname");
	   	}
	@Then("User click on search button")
	public void user_click_on_search_button() {
		scbfl.clickOnSearchButton();
		logutility.Info("search button is clicked");
	   
	}
}
