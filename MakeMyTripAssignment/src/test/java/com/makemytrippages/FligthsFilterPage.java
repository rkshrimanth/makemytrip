package com.makemytrippages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.initialization.Initialization;

public class FligthsFilterPage extends Initialization{
	
	@FindBy(xpath="//button[text()='OKAY, GOT IT!']")
	private WebElement popUpAfterSerachButton;
	
	public void clickOnPopUpAfterSerachButton() {
		popUpAfterSerachButton.click();
	}
	
	@FindBy(xpath="//p[starts-with(text(),'Non Stop')][1]")
	private WebElement nonStopFilter;
	
	public void clickOnNonStopFilter() {
		nonStopFilter.click();
	}
	
	@FindBy(xpath="(//div[@class='boldFont'])[3]")
	private WebElement filter12pmTo6pmOption;
	
	public void clickOnfilter12pmTo6pmOption() {
		filter12pmTo6pmOption.click();
	}
	
	@FindBy(xpath="//label[@class='checkboxContainer ']//child::p[text()='AirAsia (2)  ']")
	private WebElement airlinesFilter;
	
	public void clickOnAirlinesFilter() {
		airlinesFilter.click();
	}
	
	@FindBy(xpath="//span[text()='View Prices']")
	private WebElement viewPricesOption;
	
	public void clickOnviewPricesOption() {
		viewPricesOption.click();
	}
	
	public void selectingMostExpensivePrice() {
		List<WebElement> flightOptions = driver.findElements(By.xpath("//p[@class='blackText fontSize16 blackFont appendBottom5  ']"));

		WebElement mostExpensiveFlight = null;
		double highestPrice = 0.0;

		// Collect flight prices
		for (WebElement option : flightOptions) {
			String priceText = option.getText();
			double price = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));
			if(price>highestPrice)
			{
				highestPrice=price;
				mostExpensiveFlight=option;
			}

		}
		System.out.println(mostExpensiveFlight);

		mostExpensiveFlight.findElement(By.xpath(".//following::button[text()='Book Now']")).click();
	}
	
}
