package com.makemytrippages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.initialization.Initialization;

public class BookingPage extends Initialization{

	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public void switchFromFlightsFilterPageToBookingPage() {
		String homepage=driver.getWindowHandle();

		for(String allhandles:driver.getWindowHandles())
		{
			if(!allhandles.equals(homepage));
			driver.switchTo().window(allhandles);
		}
	}
	
	public void verifyBookingPage() {
		String actual=driver.findElement(By.xpath("//h2[text()='Complete your booking']")).getText();
		String expected="Complete your booking";
		Assert.assertEquals(actual, expected);
	}
	
	@FindBy(xpath="(//span[@class='customRadioBtn sizeSm primaryRadiobox ']//input)[2]")
	private WebElement tripSecureRadioButton;
	
	public void clickOnTripSecureRadioButton() {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tripSecureRadioButton);
		tripSecureRadioButton.click();
	}
	
	public void addingTravellerDetails() throws InterruptedException {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tripSecureRadioButton);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@class='otherList']//button")).click();

		driver.findElement(By.xpath("//div[@class='relative']/child::input[@placeholder='First & Middle Name']")).sendKeys("first");

		driver.findElement(By.xpath("//div[@class='relative']/child::input[@placeholder='Last Name']")).sendKeys("last");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@tabindex='0']")));

		driver.findElement(By.xpath("//label[@tabindex='0']")).click();

		driver.findElement(By.xpath("//div[@class='relative']/child::input[@placeholder='Mobile No']")).sendKeys("1234567890");

		driver.findElement(By.xpath("//div[@class='relative']/child::input[@placeholder='Email']")).sendKeys("rsk@gmail.com");

		driver.findElement(By.xpath("//div[@class='emailIds-dropdown']")).click();

		driver.findElement(By.xpath("//input[@id='pincode_gst_info']")).clear();
		driver.findElement(By.xpath("//input[@id='pincode_gst_info']")).sendKeys("560000");

		String stateToSelect = "Karnataka";
		WebElement stateDropdown = driver.findElement(By.id("dt_state_gst_info"));
		stateDropdown.click();
		WebElement MaharashtraOption = driver.findElement(By.xpath("//ul[@class='dropdownListWpr']//li[text()='"+stateToSelect+"']"));
		MaharashtraOption.click();
		WebElement address = driver.findElement(By.id("address_gst_info"));
		address.sendKeys("vijaynagar 1st stage");
	}
	
	@FindBy(xpath="//span[@class='checkboxWpr']")
	private WebElement confirmAndSaveBillingDetailsToYourProfileCheckBox;
	
	public void confirmAndSaveBillingDetailsToYourProfileCheckBox() {
		confirmAndSaveBillingDetailsToYourProfileCheckBox.click();
	}
	
	@FindBy(xpath="//button[@class='lato-black button buttonPrimary extraPadBtn fontSize16 ']")
	private WebElement bookingDetailsContinueButton;
	
	public void clickOnbookingDetailsContinueButton() {
		bookingDetailsContinueButton.click();
	}
	
	@FindBy(xpath="//div[@class='detailsPopupFooter']//button")
	private WebElement confirmBookingButton;
	
	public void clickOnconfirmBookingButton() {
		confirmBookingButton.click();
	}
}
