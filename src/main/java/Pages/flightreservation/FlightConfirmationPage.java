package Pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Common.AbstractPage;

public class FlightConfirmationPage extends AbstractPage{

	private static final Logger log=LoggerFactory.getLogger(FlightConfirmationPage.class);
	public FlightConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "(//div[@class='card'])[3]//following::div[3][contains(.,'Flight Confirmation')]//following::div[1]")
	private WebElement flightConfirmation;
	@FindBy(xpath = "(//div[@class='card'])[3]//following::div[contains(.,'Total Price')][3]//following::div[1]")
	private WebElement totalPrice;

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(flightConfirmation));
		return flightConfirmation.isDisplayed();
	}
	public String getPrice() {
		String confirmation=flightConfirmation.getText();
		String price=totalPrice.getText();
		log.info("flight confirmation {}",confirmation);
		log.info("Flight total price {}",price);
		return price;
		
	}

}
