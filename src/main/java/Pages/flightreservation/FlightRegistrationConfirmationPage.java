package Pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Common.AbstractPage;

public class FlightRegistrationConfirmationPage extends AbstractPage{
	WebDriver driver;

	public FlightRegistrationConfirmationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	    
	}
	@FindBy(id="go-to-flights-search")
	private WebElement gotoFlightSearch;

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(this.gotoFlightSearch));
		return false;
	}
	public void gotoFlightSearch() {
		this.gotoFlightSearch.click();
	}
	
	
}
