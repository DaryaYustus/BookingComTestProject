package com.booking.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.booking.test.constants.Constants;

public class MainPage extends AbstractPage implements Constants {

	@FindBy(id = "ss")
	private WebElement destinationFild;

	@FindBy(xpath = "//div[@data-mode='checkin']//button")
	private WebElement checkInButton;

	@FindBy(xpath = "//div[@data-mode='checkout']//button")
	private WebElement checkOutButton;

	@FindBy(id = "xp__guests__toggle")
	private WebElement guestsToggle;

	@FindBy(id = "no_rooms")
	private WebElement noRoomsField;

	@FindBy(id = "group_adults")
	private WebElement groupAdultsField;

	@FindBy(id = "group_children")
	private WebElement groupChildrenField;

	@FindBy(className = "sb-searchbox__button  ")
	private WebElement buttonCheckPrice;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);

	}

	// Set check in date
	public void setCheckInDate(String date) {
		checkInButton.click();
		checkInButton.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(date.replaceAll("\\D", ""));
	}

	// Set check out date
	public void setCheckOutDate(String date) {
		checkOutButton.click();
		checkOutButton.sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(date.replaceAll("\\D", ""));
	}

	// Set destination
	public void setDestination(String destination) {
		destinationFild.sendKeys(destination);
		destinationFild.click();

	}

	// set data to the guest dropdown
	public void setGuests(int numberOfRooms, int adultGuests, int childrenGuests) {
		selectNumberOfRooms(numberOfRooms);
		selectNumberOfAdultGuests(adultGuests);
		selectNumberOfChildrenGuests(childrenGuests);
	}

	// Select number of rooms
	public void selectNumberOfRooms(int numberOfRooms) {
		guestsToggle.click();
		Select dropdownRooms = new Select(noRoomsField);
		dropdownRooms.selectByVisibleText(String.valueOf(numberOfRooms));
	}

	// Select adult guests field
	public void selectNumberOfAdultGuests(int adultGuests) {
		guestsToggle.click();
		Select dropdownAdults = new Select(groupAdultsField);
		dropdownAdults.selectByVisibleText(String.valueOf(adultGuests));
	}

	// Select children guests field
	public void selectNumberOfChildrenGuests(int childrenGuests) {
		guestsToggle.click();
		Select dropdownChildren = new Select(groupChildrenField);
		dropdownChildren.selectByVisibleText(String.valueOf(childrenGuests));
	}

	// Click search button
	public void clickCheckPriceButton() {
		buttonCheckPrice.click();

	}

}
