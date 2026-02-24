package Pages.VendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Common.AbstractPage;

public class DashboardPage extends AbstractPage
{
	private static final Logger log=LoggerFactory.getLogger(DashboardPage.class);

	@FindBy(id="monthly-earning")
	private WebElement monthlyEarningElement;
	
	@FindBy(id="annual-earning")
	private WebElement annualEarningElement;
	
	@FindBy(id="profit-margin")
	private WebElement profitMarginElement;
	
	@FindBy(id="available-inventory")
	private WebElement availableInventoryElement;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchInput;
	
	@FindBy(id="dataTable_info")
	private WebElement searchResultCountElement;
	
	@FindBy(xpath="//img[@class='img-profile rounded-circle']")
	private WebElement userProfilePictureElement;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	@FindBy(css="#logoutModal a")
	private WebElement modalLogoutButton;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(annualEarningElement));
		return this.annualEarningElement.isDisplayed();
	}
	public String getMonthlyEarningText() {
		return this.monthlyEarningElement.getText();
	}
	public String getAnnuallyEarningText() {
		return this.annualEarningElement.getText();
	}
	public String getProfitMarginText() {
		return this.profitMarginElement.getText();
	}
	public String getAvailableInventoryText() {
		return this.availableInventoryElement.getText();
	}
	public void enterSearchresult(String keyword) {
		this.searchInput.sendKeys(keyword);
	}
	public Integer getCountInfo() {
		String text=this.searchResultCountElement.getText();
		String arr[]=text.split(" ");
		int count=Integer.parseInt(arr[5]);
		log.info("Result is {}",count);
		return count;
	}
	public void logOut() {
		this.userProfilePictureElement.click();
		this.wait.until(ExpectedConditions.visibilityOf(logoutLink));
		this.logoutLink.click();
		this.wait.until(ExpectedConditions.visibilityOf(modalLogoutButton));
		clickByjavascript(this.modalLogoutButton);
	}

}
