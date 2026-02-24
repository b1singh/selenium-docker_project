package Pages.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Common.AbstractPage;

public class FlightRegistrationPage extends AbstractPage{
	
	public FlightRegistrationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="firstName")
	private WebElement firstName;
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="email")
	private WebElement emailId;
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="street")
	private WebElement street;
	@FindBy(name="city")
	private WebElement city;
	
	@FindBy(name="inputState")
	private WebElement selectState;
	@FindBy(name="zip")
	private WebElement zip;
	
	@FindBy(id="register-btn")
	private WebElement registerButton;
	
	
	public void goTo(String url) {
		driver.get(url);
	}
	public void enterUserDetails(String firstname,String lastname) {
		this.firstName.sendKeys(firstname);
		this.lastName.sendKeys(lastname);
	}
	public void enterUserCredentials(String email,String password) {
		this.emailId.sendKeys(email);
		this.password.sendKeys(password);
	}
	public void enterUserAddress(String street,String city,String zip) {
		this.street.sendKeys(street);
		this.city.sendKeys(city);
		this.zip.sendKeys(zip);
	}
	public void register() {
		clickByjavascript(this.registerButton);
	}
	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
		return this.firstName.isDisplayed();
	}
	
	

}
