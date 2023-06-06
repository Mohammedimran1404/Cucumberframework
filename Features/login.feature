Feature: Login
  @Sanity
  Scenario: Successful login with valid credentials
    Given : Launch chrome browser
    When : opens url "https://admin-demo.nopcommerce.com/login"
    And : User enter email as "admin@yourstore.com" and password as "admin"
    And : Click on login
    Then : Page title should be "Dashboard / nopCommerce administration"
    When : User click on logout
    Then : Page title should be "Your store. Login"
    And : Close browser
@Regression
Scenario Outline: Login data driven
Given : Launch chrome browser
    When : opens url "https://admin-demo.nopcommerce.com/login"
    And : User enter email as "<email>" and password as "<password>"
    And : Click on login
    Then : Page title should be "Dashboard / nopCommerce administration"
    When : User click on logout
    Then : Page title should be "Your store. Login"
    And : Close browser
    
    Examples:
    | email | password |
    |admin@yourstore.com  | admin |
    |admin@yourstore.com  | admin123 |