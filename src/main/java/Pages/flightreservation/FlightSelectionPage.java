package Pages.flightreservation;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Common.AbstractPage;

public class FlightSelectionPage extends AbstractPage{

	public FlightSelectionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css = "input[name='departure-flight']")
	private List<WebElement> departhureFlights;
	@FindBy(css = "input[name='arrival-flight']")
	private List<WebElement> arriavlFlights;
	
	@FindBy(id = "confirm-flights")
	private WebElement confirmFlightBtn;

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(confirmFlightBtn));
		return confirmFlightBtn.isDisplayed();
	}
	public void selectFlight() {
		int random=ThreadLocalRandom.current().nextInt(0,departhureFlights.size());
		departhureFlights.get(random).click();
		clickByjavascript(arriavlFlights.get(random));
	}
	public void confirmFlight() {
		clickByjavascript(this.confirmFlightBtn);
	}

}
