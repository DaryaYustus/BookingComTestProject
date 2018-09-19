package com.booking.test;

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

public class MailAutomationTest {

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
		mainPage.setDestination(Constants.MINSK);
		mainPage.setCheckInDate(DateUtil.getNextSaturday());
		mainPage.setCheckOutDate(DateUtil.getNextSunday());
		mainPage.selectNumberOfAdultGuests(1);
		mainPage.clickCheckPriceButton();

		int numberOfHotels = searchResultsPage.numberOfHotelsOnPage();
		Assert.assertTrue(numberOfHotels >= Constants.MIN_HOTELS);

	}

	@Test(testName = "Проверить работу фильтра Показать только доступные варианты", enabled = true)
	public void testAvailableHotelsFilter() {
		mainPage.openPage();
		mainPage.setDestination(Constants.MINSK);
		mainPage.setCheckInDate(DateUtil.getNextSaturday());
		mainPage.setCheckOutDate(DateUtil.getNextSunday());
		mainPage.clickCheckPriceButton();
		int numberOfHotels = searchResultsPage.getNumberOfHotelsFromHead();
		System.out.println("numberOfHotels = " + numberOfHotels);
		searchResultsPage.filterByAvailableHotels();
		int numberOfHotelsAfterFilter = searchResultsPage
				.getNumberOfHotelsFromHead();
		System.out.println("numberOfHotelsAfterFilter = "
				+ numberOfHotelsAfterFilter);
		Assert.assertTrue(numberOfHotelsAfterFilter <= numberOfHotels);
	}

	@Test(testName = "Проверить количество отелей в фильтре с реальным", enabled = true)
	public void testNumberOfAvailableHotelsWithBreakfast() {
		mainPage.openPage();
		mainPage.setDestination(Constants.MINSK);
		mainPage.setCheckInDate(DateUtil.getNextSaturday());
		mainPage.setCheckOutDate(DateUtil.getNextSunday());
		mainPage.clickCheckPriceButton();
		int numberHotelsWithBreakfast = searchResultsPage
				.getNumberBreakfastIncluded();
		searchResultsPage.selectBreakfastIncluded();
		int numberOfHotelsAfterFilter = searchResultsPage
				.getNumberOfHotelsFromHead();
		Assert.assertEquals(numberOfHotelsAfterFilter,
				numberHotelsWithBreakfast);
	}

	@AfterMethod
	public void stopBrowser() {
		Driver.stopWebDriver();
	}

}
