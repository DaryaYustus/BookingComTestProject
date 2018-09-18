package com.booking.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.booking.test.constants.Constants;
import com.booking.test.driver.Driver;
import com.booking.test.pages.MainPage;
import com.booking.test.pages.SearchResultsPage;
import com.booking.test.util.DateUtil;

public class MailAutomationTest implements Constants {

	private static WebDriver driver;

	private MainPage mainPage;
	private SearchResultsPage searchResultsPage;

	@BeforeMethod()
	public void init() {
		driver = Driver.startWebDriver();
		mainPage = new MainPage(driver);
		searchResultsPage = new SearchResultsPage(driver);

	}

	@Test(testName = "Hайти как минимум 3 доступных номера в гостинице в минске на двоих на ближайший уикэнд", enabled = true)
	public void testAvailableHotels() {
		mainPage.openPage();
		mainPage.setDestination(MINSK);
		mainPage.setCheckInDate(DateUtil.getNextSaturday());
		mainPage.setCheckOutDate(DateUtil.getNextSunday());
		mainPage.selectNumberOfAdultGuests(1);
		mainPage.clickCheckPriceButton();
		int numberOfHotels = searchResultsPage.numberOfHotels();
		Assert.assertTrue(numberOfHotels >= MIN_HOTELS);

	}

	@AfterMethod
	public void stopBrowser() {
		Driver.stopWebDriver();
	}

}
