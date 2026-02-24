package Tests.flightreservation;

import java.io.ObjectInputFilter.Config;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import util.config;
import util.constant;
import util.listeners;

@Listeners({listeners.class})
public class AbstractTest {

	protected WebDriver driver;
	
	@BeforeSuite
	public void setupConfiguration() {
		config.initialize();
	}
	
	@BeforeTest
	public void setDriver(ITestContext context) throws MalformedURLException {
		
		this.driver= Boolean.parseBoolean(config.get(constant.GRID_ENABLED)) ? getRemoteWebDriver() : getLocalDriver();
		context.setAttribute(constant.DRIVER, this.driver);
//		if(Boolean.getBoolean("selenium.grid.enabled")) {
//			System.out.println(Boolean.parseBoolean(config.get(constant.GRID_ENABLED)));
//			this.driver=getRemoteWebDriver();
//		}else {
//			this.driver=new ChromeDriver();
//		}
	}
	public WebDriver getRemoteWebDriver() throws MalformedURLException {
		Capabilities cap;
		System.out.println("browser name is"+config.get(constant.BROWSER));
		if(constant.FIREFOX.equalsIgnoreCase(config.get(constant.BROWSER))) {
			cap=new FirefoxOptions();
		}else {
			cap=new ChromeOptions();
		}
		String urlformat=config.get(constant.GRID_URL_FORMAT);
		String hubhost=config.get(constant.GRID_HUB_PORT);
		String url=String.format(urlformat, hubhost);
		return new RemoteWebDriver(new URL(url),cap);
	}
	public WebDriver getLocalDriver() {
		return new ChromeDriver();
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}
}
