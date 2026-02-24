package Pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Common.AbstractPage;

public class VendorLoginPage extends AbstractPage{
	 
	@FindBy(id="username")
	private WebElement username;
	@FindBy(id="password")
	private WebElement password;
	@FindBy(id="login")
	private WebElement login;

	public VendorLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(login));
		return login.isDisplayed();
	}
	public void vendorPortalLogin(String username,String password)
	{
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.login.click();
	}
	

}
