package com.booking.test.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {
	private WebDriverWait wait;

	public SearchResultsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}

	@Override
	public void openPage() {
	}

	@FindBy(className = "sr-hotel__name")
	private List<WebElement> listHotels;

	public int numberOfHotels() {
		return listHotels.size();

	}

}
