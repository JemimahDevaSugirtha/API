package com.step_definition;

import com.Base.WebPageUtilities;
import com.pojo.Credentials;
import com.pom.BookingPage;
import com.pom.LoginPage;
import com.pom.NavigateToPage;
import com.pom.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Adactin_Step_Def extends WebPageUtilities{
	
	LoginPage lgn = new LoginPage(driver);
	SearchPage srch = new SearchPage(driver);
	BookingPage bkng = new BookingPage(driver);
	NavigateToPage nav = new NavigateToPage(driver);
	Credentials cred = new Credentials();
	
	//******login hotel page*****//
	
	@Given("user should be able to launch url")
	public void user_should_be_able_to_launch_url() {
		launchUrl("https://adactinhotelapp.com");
	}

	@When("user enters username in textbox")
	public void user_enters_username_in_textbox() {	
		enterText(lgn.getUserNameBox(), cred.getUsername());
	}

	@When("user enters password in textbox")
	public void user_enters_password_in_textbox() {
		enterText(lgn.getPasswordBox(), cred.getPassword());
	}

	@Then("user clicks on login button to navigate to search hotel page")
	public void user_clicks_on_login_button_to_navigate_to_search_hotel_page() {
		click(lgn.getLoginButton());
	}
	
	
	//******Search hotel page*****//
	
	@When("user able to select the location from the dropdown")
	public void user_able_to_select_the_location_from_the_dropdown() {
		selectByText(srch.getLocation(), "London");
	}

	@When("user able to select the hotel from the dropdown")
	public void user_able_to_select_the_hotel_from_the_dropdown() {
		selectByText(srch.getHotels(), "Hotel Creek");
		
	}

	@When("user able to select the roomtype from the dropdown")
	public void user_able_to_select_the_roomtype_from_the_dropdown() {
		selectByText(srch.getRoomType(), "Standard");
		
	}

	@When("user able to select the number of rooms from the dropdown")
	public void user_able_to_select_the_number_of_rooms_from_the_dropdown() {
		selectByValue(srch.getRooms(), "3");
		
	}

	@When("user able to clear the text box and enter checkin date in the textbox")
	public void user_able_to_clear_the_text_box_and_enter_checkin_date_in_the_textbox() {
		clear(srch.getPickInDate());
		enterText(srch.getPickInDate(),"20/02/2023");
		
	}

	@When("user able to clear the text box and enter checkout date in the textbox")
	public void user_able_to_clear_the_text_box_and_enter_checkout_date_in_the_textbox() {
		clear(srch.getPickOutDate());
		enterText(srch.getPickOutDate(),"25/02/2023");
		
	}

	@When("user able to select the adult per room from the dropdown")
	public void user_able_to_select_the_adult_per_room_from_the_dropdown() {
		selectByValue(srch.getAdultPerRoom(), "2");
		
	}

	@When("user able to select the children per room from the dropdown")
	public void user_able_to_select_the_children_per_room_from_the_dropdown() {
		selectByValue(srch.getChildPerRoom(), "2");
	}

	@Then("user able to click the search button and it navigates to the booking page")
	public void user_able_to_click_the_search_button_and_it_navigates_to_the_booking_page() {
		click(srch.getSubmitButton());
		click(srch.getRadioButton());
		click(srch.getContiueButton());
	}

	
	//******booking hotel page without input*****//
	
	@When("user able to enter the first name in the textbox")
	public void user_able_to_enter_the_first_name_in_the_textbox() {
		enterText(bkng.getFirstName(),cred.getFirstName());
	}

	@When("user able to enter the last name in the textbox")
	public void user_able_to_enter_the_last_name_in_the_textbox() {
		scrollTo(bkng.getFirstName());
		enterText(bkng.getLastName(),cred.getLastName());

	}

	@When("user able to enter the address in the textbox")
	public void user_able_to_enter_the_address_in_the_textbox() {
		enterText(bkng.getAddress(),cred.getAddress());
		
	}

	@When("user able to enter the credit card number in the textbox")
	public void user_able_to_enter_the_credit_card_number_in_the_textbox() {
		enterText(bkng.getCreditCardNum(),cred.getCreditCardNo());

	}

	@When("user able to select the credit card type from the dropdown")
	public void user_able_to_select_the_credit_card_type_from_the_dropdown() {
		selectByText(bkng.getCardType(), cred.getCardType());
		
	}

	@When("user able to select the expiry month from the dropdown")
	public void user_able_to_select_the_expiry_month_from_the_dropdown() {
		selectByText(bkng.getExpiryMonth(), cred.getExpiryMonth());
		
	}

	@When("user able to select the expiry year from the dropdown")
	public void user_able_to_select_the_expiry_year_from_the_dropdown() {
		selectByText(bkng.getExpiryYear(), cred.getExpiryYear());
		
	}

	@When("user able to enter the cvv in the textbox")
	public void user_able_to_enter_the_cvv_in_the_textbox() {
		enterText(bkng.getCvv(),cred.getCvv());
		
	}

	@Then("user able to click on the booknow button")
	public void user_able_to_click_on_the_booknow_button() {
		click(bkng.getBookNowButton());
	}
	
	
	
	//******search hotel page with input*****//
	
	@When("user able to select the location {string} from the dropdown")
	public void user_able_to_select_the_location_from_the_dropdown(String Location) {
		selectByText(srch.getLocation(), Location);
		
	}

	@When("user able to select the hotel {string} from the dropdown")
	public void user_able_to_select_the_hotel_from_the_dropdown(String hotelName) {
		selectByText(srch.getHotels(), hotelName);

	}

	@When("user able to select the roomtype {string} from the dropdown")
	public void user_able_to_select_the_roomtype_from_the_dropdown(String roomType) {
		selectByText(srch.getRoomType(), roomType);

	}

	@When("user able to select the no of rooms {string} from the dropdown")
	public void user_able_to_select_the_no_of_rooms_from_the_dropdown(String no_Of_Rooms) {
		selectByValue(srch.getRooms(), no_Of_Rooms);

	}

	@When("user able to clear the text box and enter checkin date {string} in the textbox")
	public void user_able_to_clear_the_text_box_and_enter_checkin_date_in_the_textbox(String checkInDate) {
		clear(srch.getPickInDate());
		enterText(srch.getPickInDate(),checkInDate);
		
	}

	@When("user able to clear the text box and enter checkout date {string} in the textbox")
	public void user_able_to_clear_the_text_box_and_enter_checkout_date_in_the_textbox(String checkOutDate) {
		clear(srch.getPickOutDate());
		enterText(srch.getPickOutDate(),checkOutDate);
		
	}

	@When("user able to select the adult per room {string} from the dropdown")
	public void user_able_to_select_the_adult_per_room_from_the_dropdown(String adultsPerRoom) {
		selectByValue(srch.getAdultPerRoom(), adultsPerRoom);
		
	}

	@When("user able to select the children per room {string} from the dropdown")
	public void user_able_to_select_the_children_per_room_from_the_dropdown(String childsPerRoom) {
		selectByValue(srch.getChildPerRoom(), childsPerRoom);
	}

	@Then("User able to click search button in the navigation to continue search another hotel")
	public void user_able_to_click_search_button_in_the_navigation_to_continue_search_another_hotel() {
		scrollTo(nav.getSearchHotelButton());
		click(nav.getSearchHotelButton());
	}
	
	//******logout hotel page******//
	@When("user wants to logout")
	public void user_wants_to_logout() {
		scrollTo(nav.getLogoutButton());
	}

	@Then("user clicks on logout button")
	public void user_clicks_on_logout_button() {
		click(nav.getLogoutButton());
		click(nav.getLoginpage());
	}
	
}
