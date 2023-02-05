Feature: Adactin hotel web app automation

@test1 @test2 @test3
Scenario: Login page

Given user should be able to launch url
When user enters username in textbox
And user enters password in textbox
Then user clicks on login button to navigate to search hotel page


@test1
Scenario: Search hotel page

When user able to select the location from the dropdown
And user able to select the hotel from the dropdown
And user able to select the roomtype from the dropdown
And user able to select the number of rooms from the dropdown
And user able to clear the text box and enter checkin date in the textbox
And user able to clear the text box and enter checkout date in the textbox
And user able to select the adult per room from the dropdown
And user able to select the children per room from the dropdown
Then user able to click the search button and it navigates to the booking page




@test2
Scenario: Search hotel page

When user able to select the location "London" from the dropdown
And user able to select the hotel "Hotel Creek" from the dropdown
And user able to select the roomtype "Standard" from the dropdown
And user able to select the no of rooms "3" from the dropdown
And user able to clear the text box and enter checkin date "20/02/2023" in the textbox
And user able to clear the text box and enter checkout date "25/02/2023" in the textbox
And user able to select the adult per room "2" from the dropdown
And user able to select the children per room "2" from the dropdown
Then user able to click the search button and it navigates to the booking page



@test3
Scenario: Search hotel page

When user able to select the location "<location>" from the dropdown
And user able to select the hotel "<hotel>" from the dropdown
And user able to select the roomtype "<roomtype>" from the dropdown
And user able to select the no of rooms "<no_of_room>" from the dropdown
And user able to clear the text box and enter checkin date "<checkin_date>" in the textbox
And user able to clear the text box and enter checkout date "<checkout_date>" in the textbox
And user able to select the adult per room "<adult_per_room>" from the dropdown
And user able to select the children per room "<children_per_room>" from the dropdown
Then user able to click the search button and it navigates to the booking page
Then User able to click search button in the navigation to continue search another hotel

Examples:
|location|hotel|roomtype|no_of_room|checkin_date|checkout_date|adult_per_room|children_per_room|
|London|Hotel Creek|Standard|3|20/02/2023|20/02/2023|2|2|
|Sydney|Hotel Creek|Standard|3|20/02/2023|20/02/2023|2|2|
|Paris|Hotel Creek|Standard|3|20/02/2023|20/02/2023|2|2|



@test1 @test2 
Scenario: Booking hotel page

When user able to enter the first name in the textbox
And user able to enter the last name in the textbox
And user able to enter the address in the textbox
And user able to enter the credit card number in the textbox
And user able to select the credit card type from the dropdown
And user able to select the expiry month from the dropdown
And user able to select the expiry year from the dropdown
And user able to enter the cvv in the textbox
Then user able to click on the booknow button



@test1 @test2 @test3
Scenario: logout adactin

When user wants to logout
Then user clicks on logout button
