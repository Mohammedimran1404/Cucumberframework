package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import pageObjects.CustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerByEmail;
import pageObjects.SearchCustomerByFirstandLastName;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public CustomerPage cp;
	public SearchCustomerByEmail sce;
	public SearchCustomerByFirstandLastName scbfl;
	

	
	// this method is used for generating random mail ids
	public static String randomstring() {
		String random=RandomStringUtils.randomAlphabetic(5);
		return (random);
	}
}
