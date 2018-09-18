package selenium;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AppSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.booking.com");
/////////main page///////////////////////////////////////////////////////////////////
		WebElement locationFild = driver.findElement(By.xpath("//*[@id=\"ss\"]"));
		locationFild.click();
		locationFild.sendKeys("Минск");

		 WebElement arrivalData =driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/button"));
		 arrivalData.click();

		 WebElement departureData =driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/div/div[1]/table/tbody/tr[4]/td[6]"));
		departureData.click();
		WebElement guestsField = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]"));
		 guestsField.click();
		 
		 WebElement selectPerson = driver.findElement(By.xpath("//*[@id=\"group_adults\"]"));
		 selectPerson.click();
		 
		 Select selDr = new Select(driver.findElements(By.id("group_adults")).get(0));
		 selDr.selectByValue("1");
		 
		 WebElement checkPrice = driver.findElement(By.className("sb-searchbox__button  "));
		 checkPrice.click();
		 
	///////////////////////////////////////////////////////////////////
		 
		 
		 ///////////Second page////////////////
		 Thread.sleep(10000);	
		 
		 WebElement filterFild = driver.findElement(By.xpath("//*[@id=\"filterbox_options\"]/div"));
		 WebElement selectAvailableHotels = driver.findElement(By.linkText("Показать только доступные варианты"));
		 selectAvailableHotels.click();

		 
		 

	}

}

// Date current = new Date();

// Calendar cal = Calendar.getInstance();

// cal.setTime(current);

// System.out.println(cal.getTime());
// System.out.println(cal.get(Calendar.DAY_OF_WEEK));
// while (cal.get(Calendar.DAY_OF_WEEK) != 7) {
// cal.add(Calendar.DAY_OF_MONTH, 1);
// }

// System.out.println(cal.get(Calendar.DAY_OF_WEEK));
// System.out.println(cal.get(Calendar.DAY_OF_MONTH));

