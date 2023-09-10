package com.initialization;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.makemytrippages.BookingPage;
import com.makemytrippages.FligthsFilterPage;
import com.makemytrippages.HomePage;

public class Initialization {
	
	public static WebDriver driver=new ChromeDriver();
	public static HomePage homePage;
	public static FligthsFilterPage fligthsFilterPage;
	public static BookingPage bookingPage;
	
	@BeforeClass
	public void configBeforeClass() {
		homePage=PageFactory.initElements(driver,HomePage.class);
		fligthsFilterPage=PageFactory.initElements(driver,FligthsFilterPage.class);
		bookingPage=PageFactory.initElements(driver,BookingPage.class);
	}
	
	@BeforeMethod
	
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	

}
