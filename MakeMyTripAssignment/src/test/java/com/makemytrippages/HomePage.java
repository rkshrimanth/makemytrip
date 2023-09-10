package com.makemytrippages;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.initialization.Initialization;

public class HomePage extends Initialization{
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
	public void launch() {		
		System.setProperty("webdriver.chrome.driver", "D:\\WORKSPACE\\testing\\Library\\driver\\chromedriver.exe");
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().window().maximize();
		 driver.navigate().refresh();	
	}
	
	
	@FindBy(xpath="//span[text()='Flights']")
	private WebElement clickOnFlights;
	
	public void clickOnFlights() {
		clickOnFlights.click();
	}
	
	@FindBy(id="fromCity")
	private WebElement fromCityField;
	
	public void fromCityField() {
		fromCityField.sendKeys("bangalore");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Bengaluru, India')]")));
	}
	
	@FindBy(xpath="//p[contains(text(),'Bengaluru, India')]")
	private WebElement fromCityDropDown;
	
	public void selectItemFromFromCityDropdown() {
		fromCityDropDown.click();
	}
	
	@FindBy(id="toCity")
	private WebElement toCityField;
	
	public void toCityField() {
		toCityField.sendKeys("bangalore");
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Chennai, India')]")));
	}
	
	@FindBy(xpath="//p[contains(text(),'Chennai, India')]")
	private WebElement toCityDropDown;
	
	public void selectItemFromToCityDropdown() {
		toCityDropDown.click();
	}
	
	public void selectDepartureDate() {
		Date currentDate = new Date();

		// Create a Calendar object and set it to the current date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);

		// Add 3 months to the current date
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		calendar.add(Calendar.MONTH, 3);

		// Get the date 3 months from now
		Date threeMonthsFromNow = calendar.getTime();

		// Format the date in the desired format (e.g., "dd/MM/yyyy")
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy");
		String formattedDate = dateFormat.format(threeMonthsFromNow);

		//div[@class='DayPicker-Day' and @aria-label='Sat Dec 09 2023']
		// Locate the calendar date picker and find the element for the calculated date
		By dateLocator = By.xpath("//div[@class='DayPicker-Day' and @aria-label='" + formattedDate + "']");

		WebElement dateElement = wait.until(ExpectedConditions.presenceOfElementLocated(dateLocator));

		// Scroll to the element if needed
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);

		// Click on the selected date to choose it
		dateElement.click();
	}
	
	@FindBy(xpath="//a[text()='Search']")
	private WebElement flightSearchButton;
	
	public void clickOnFlightSearchButton() {
		flightSearchButton.click();
	}

}
