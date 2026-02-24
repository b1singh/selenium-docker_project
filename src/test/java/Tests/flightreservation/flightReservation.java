package Tests.flightreservation;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.flightreservation.FlightConfirmationPage;
import Pages.flightreservation.FlightRegistrationConfirmationPage;
import Pages.flightreservation.FlightRegistrationPage;
import Pages.flightreservation.FlightSearchPage;
import Pages.flightreservation.FlightSelectionPage;



public class flightReservation extends AbstractTest{

	private String noOfPassengers;
	private String expectedPrice;
	@BeforeTest
	@Parameters({"noOfPassengers","expectedPrice"})
	public void setupParameters(String noOfPassengers,String expectedPrice) {
		this.noOfPassengers=noOfPassengers;
		this.expectedPrice=expectedPrice;
		driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
	}
	@Test
	public void userRegistrationTest() {
		FlightRegistrationPage registration=new FlightRegistrationPage(driver);
		Assert.assertTrue(registration.isAt());
		registration.enterUserDetails("bhupender", "singh");
		registration.enterUserCredentials("singhb132@gmail.com", "password");
		registration.enterUserAddress("03", "palwal", "121102");
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
		search.selectPassengers(noOfPassengers);
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
		Assert.assertEquals(confirmation.getPrice(), expectedPrice);
	}
}
