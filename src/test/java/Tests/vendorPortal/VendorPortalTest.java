package Tests.vendorPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.VendorPortal.VendorLoginPage;
import Tests.flightreservation.AbstractTest;
import util.config;
import util.constant;
import util.jsonUtils;


public class VendorPortalTest extends AbstractTest{
	
	VendorLoginPage login;
	Pages.VendorPortal.DashboardPage dashboardPage;
	VendorPortalTestData testData;
	@BeforeTest
	@Parameters("testDataPath")
	public void setPageObjects(String path) {
		driver.get(config.get(constant.VENDOR_PORTAL_URL));
	    driver.manage().window().maximize();
	    login=new VendorLoginPage(driver);
	    dashboardPage=new Pages.VendorPortal.DashboardPage(driver);
	    testData=jsonUtils.getTestData(path,VendorPortalTestData.class);
	}
	@Test
	public void loginPortal() {
		Assert.assertTrue(login.isAt());
		login.vendorPortalLogin(testData.username, testData.password);
	}
	
	@Test(dependsOnMethods = "loginPortal")
	public void DashboardPage() {
	    dashboardPage.isAt();
		System.out.println("annual text"+dashboardPage.getAnnuallyEarningText());
		Assert.assertEquals(dashboardPage.getAnnuallyEarningText(), testData.annualEarning);
	    Assert.assertEquals(dashboardPage.getMonthlyEarningText(), testData.monthlyEarning);
	    Assert.assertEquals(dashboardPage.getAvailableInventoryText(), testData.availableInventory);
	    Assert.assertEquals(dashboardPage.getProfitMarginText(), testData.profitMargin);
	    dashboardPage.enterSearchresult(testData.searchKeywords);
	    Assert.assertEquals(dashboardPage.getCountInfo(),testData.searchResultCount);
	    ;
	}
	@Test(dependsOnMethods = "DashboardPage")
	public void logout() {
		dashboardPage.logOut();
		login.isAt();
	}
	
	
	

}
