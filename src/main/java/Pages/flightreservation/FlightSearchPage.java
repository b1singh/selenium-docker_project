package Pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import Common.AbstractPage;

public class FlightSearchPage extends AbstractPage{
	
	public FlightSearchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="passengers")
	private WebElement selectPassengers;
	@FindBy(id="search-flights")
	private WebElement searchFlightBtn;

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(selectPassengers));
		return selectPassengers.isDisplayed();
	}
	public void selectPassengers(String noOfPassengers)
	{
		Select selectPassengers=new Select(this.selectPassengers);
		selectPassengers.selectByValue(noOfPassengers);
	}
	public void serachFlight() {
		clickByjavascript(this.searchFlightBtn);
	}

}
