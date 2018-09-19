package com.booking.test.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.booking.test.constants.Constants;

public class SearchResultsPage extends AbstractPage implements Constants {
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

	@FindBy(xpath = "//*[@id=\"filterbox_options\"]/div")
	private WebElement filterFild;

	@FindBy(xpath = "//a[@data-id='oos-1']")
	private WebElement selectAvailableHotels;
	
	@FindBy(className = "sr_header")
	private WebElement headerTitle;
	
	

	// return number of hotels on the page
	public int numberOfHotelsOnPage() {
		return listHotels.size();

	}

	// select filter field "available hotels"
	public void filterByAvailableHotels() {
		// filterFild.submit();
		selectAvailableHotels.click();

	}
	//get header text
	public String getHeaderText(){
		return headerTitle.getText();
	}
	
	// get number of hotels from text
	public int getNumberOfHotelsFromHead(){
		String headerText = getHeaderText();
		String[] words = headerText.split(SPACE);
		String numberHotelsFromText = null; 
		int numberHotel = 0;
		for(String word:words){
			if (StringUtils.isNumeric(word)){
				numberHotelsFromText=word;
				break;
			}
			
		}
		if(numberHotelsFromText !=null){
			numberHotel = Integer.parseInt(numberHotelsFromText);
		}
		
		return numberHotel;
	}
	

}
