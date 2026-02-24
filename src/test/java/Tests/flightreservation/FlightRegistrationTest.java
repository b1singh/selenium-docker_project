package Tests.flightreservation;


import java.net.SocketException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.flightreservation.FlightConfirmationPage;
import Pages.flightreservation.FlightRegistrationConfirmationPage;
import Pages.flightreservation.FlightRegistrationPage;
import Pages.flightreservation.FlightSearchPage;
import Pages.flightreservation.FlightSelectionPage;
import util.config;
import util.constant;
import util.jsonUtils;

public class FlightRegistrationTest extends AbstractTest{
	

	FlightReservationTestData testdata;

	@BeforeTest
	@Parameters("testDataPath")
	public void setupParameters(String testDataPath) {

		driver.get(config.get(constant.FLIGHT_RESERVATION_URL));
	    testdata=jsonUtils.getTestData(testDataPath,FlightReservationTestData.class);
	}
	@Test
	public void userRegistrationTest() {
		FlightRegistrationPage registration=new FlightRegistrationPage(driver);
		Assert.assertTrue(registration.isAt());
		registration.enterUserDetails(testdata.firstname, testdata.lastname);
		registration.enterUserCredentials(testdata.email, testdata.password);
		registration.enterUserAddress(testdata.street, testdata.city, testdata.zip);
		registration.register();
	}
	
	@Test(dependsOnMethods ="userRegistrationTest" )
	public void registrationConfirmationTest() {
		FlightRegistrationConfirmationPage confirmation=new FlightRegistrationConfirmationPage(driver);
		confirmation.isAt();
		confirmation.gotoFlightSearch();
	}
	@Test(dependsOnMethods = "registrationConfirmationTest")
	public void flightSearchTest() {
		FlightSearchPage search=new FlightSearchPage(driver);
		search.isAt();
		search.selectPassengers(testdata.passengercount);
		search.serachFlight();
	}
	@Test(dependsOnMethods = "flightSearchTest")
	public void selectFlightTest() {
		FlightSelectionPage selection=new FlightSelectionPage(driver);
		selection.isAt();
		selection.selectFlight();
		selection.confirmFlight();
	}
	@Test(dependsOnMethods = "selectFlightTest")
	public void flightConfirmationTest() {
		FlightConfirmationPage confirmation=new FlightConfirmationPage(driver);
		confirmation.isAt();
		confirmation.getPrice();
	//	updatelog("Expected price "+expectedPrice+" And actual price"+confirmation.getPrice());
		Assert.assertEquals(confirmation.getPrice(), testdata.expectedprice);
	}
	

}
