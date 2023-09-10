package com.makemytriptests;



import org.testng.annotations.Test;

import com.initialization.Initialization;

public class BookingFligthTests extends Initialization{
	
	@Test(priority=1)
	
	public static void bookingFlight() throws InterruptedException {
		homePage.launch();
		homePage.clickOnFlights();
		homePage.fromCityField();
		homePage.selectItemFromFromCityDropdown();
		homePage.toCityField();
		homePage.selectItemFromToCityDropdown();
		homePage.selectDepartureDate();
		homePage.clickOnFlightSearchButton();
		fligthsFilterPage.clickOnPopUpAfterSerachButton();
		fligthsFilterPage.clickOnNonStopFilter();
		fligthsFilterPage.clickOnfilter12pmTo6pmOption();
		fligthsFilterPage.clickOnAirlinesFilter();
		fligthsFilterPage.clickOnviewPricesOption();
		fligthsFilterPage.selectingMostExpensivePrice();
		bookingPage.switchFromFlightsFilterPageToBookingPage();
		bookingPage.verifyBookingPage();
		bookingPage.clickOnTripSecureRadioButton();
		bookingPage.addingTravellerDetails();
		bookingPage.confirmAndSaveBillingDetailsToYourProfileCheckBox();
		bookingPage.clickOnbookingDetailsContinueButton();
		bookingPage.clickOnconfirmBookingButton();
	}

}
