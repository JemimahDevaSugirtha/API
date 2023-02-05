package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigateToPage {
	
	public WebDriver confirmDriver;
	
	public NavigateToPage(WebDriver driver) {
		this.confirmDriver = driver;
		PageFactory.initElements(confirmDriver, this);
	}
	
	@FindBy(xpath = "//input[@id='username_show']//following-sibling::a[text()='Search Hotel']")
	private WebElement searchHotelButton;
	
	@FindBy(xpath = "//input[@id='username_show']//following-sibling::a[text()='Booked Itinerary']")
	private WebElement bookedItineraryButton;
	
	@FindBy(xpath = "//input[@id='username_show']//following-sibling::a[text()='Logout']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//a[text() = 'Click here to login again']")
	private WebElement loginpage;
	
	
	public WebElement getLoginpage() {
		return loginpage;
	}

	public WebElement getSearchHotelButton() {
		return searchHotelButton;
	}
	
	public WebElement getBookedItineraryButton() {
		return bookedItineraryButton;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
	
}
