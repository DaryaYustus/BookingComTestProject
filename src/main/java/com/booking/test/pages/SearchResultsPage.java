package com.booking.test.pages;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.booking.test.constants.Constants;

public class SearchResultsPage extends AbstractPage implements Constants {
	private WebDriverWait wait;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}

	@Override
	public void openPage() {
	}

	@FindBy(className = "sr-hotel__name")
	private List<WebElement> listHotels;

	@FindBy(xpath = "//*[@id=\"filterbox_options\"]/div")
	private WebElement filterFild;

	@FindBy(xpath = "//a[@data-id='oos-1']")
	private WebElement selectAvailableHotels;
	
	@FindBy(xpath = "//a[@data-id='oos-1' and @aria-checked='true']")
	private WebElement selectAvailableHotelsChecked;

	@FindBy(className = "sr_header")
	private WebElement headerTitle;

	@FindBy(xpath = "//a[@data-id='mealplan-1']")
	private WebElement breakfastIncluded;

	@FindBy(xpath = "//a[@data-id='mealplan-1' and @aria-checked='true']")
	private WebElement breakfastIncludedChecked;

	@FindBy(xpath = "//a[@data-id='mealplan-1']/div/span/span")
	private WebElement breakfastIncludedNumber;

	// return number of hotels on the page
	public int numberOfHotelsOnPage() {
		return listHotels.size();

	}

	// select filter field "Available hotels"
	public void filterByAvailableHotels() {
		selectAvailableHotels.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(selectAvailableHotelsChecked));
	}

	// select filter field "Breakfast included"
	public void selectBreakfastIncluded() {
		breakfastIncluded.click();
		wait.until(ExpectedConditions
				.elementToBeClickable(breakfastIncludedChecked));
	}

	// get header text
	public String getHeaderText() {
		return headerTitle.getText();
	}

	// get number of hotels from text
	public int getNumberOfHotelsFromHead() {
		String headerText = getHeaderText();
		String[] words = headerText.split(SPACE);
		String numberHotelsFromText = null;
		int numberHotel = 0;
		for (String word : words) {
			if (StringUtils.isNumeric(word)) {
				numberHotelsFromText = word;
				break;
			}
		}
		if (numberHotelsFromText != null) {
			numberHotel = Integer.parseInt(numberHotelsFromText);
		}
		return numberHotel;
	}

	// Return number of hotels within "breakfast included"
	public int getNumberBreakfastIncluded() {

		String textNumber = breakfastIncludedNumber.getText();

		if (textNumber != null) {
			return Integer.parseInt(textNumber);
		}
		return 0;
	}

}
