Feature: Customers
 Background: common steps are put in background to reduce the code
Given User launch browser
When User opens url "https://admin-demo.nopcommerce.com/login"
And User enter email as "admin@yourstore.com" and password as "admin"
And User click on login
Then User can view dashboard
@Sanity
Scenario: Add a new customer

When User click on customer menu
And Click on customer menu item
And Click on add new button
Then User can view add new customer page
When User enter customer info
And Click on save button
Then User can view confirmation message "The new customer has been added successfully."
And close browser
@Regression
Scenario: search customer by email id

When User click on customer menu
And Click on customer menu item
And Enter customer email
When Click on search button
Then User should found email in the search table
And Close browser
@Regression
Scenario: Search customer by first name and last name

When User click on customer menu
And Click on customer menu item
Then User enter first name and last name
And User click on search button
And Close browser