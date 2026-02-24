package Tests.flightreservation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CheckSeleniumgrid {
	public static void main(String[] args) throws MalformedURLException {
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setCapability("se:name", "My simple test");
		
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),chromeOptions);
        driver.get("https://www.google.com");
	}

}
