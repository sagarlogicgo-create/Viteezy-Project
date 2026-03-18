package base_test;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class base_Class {
	
	public WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("Chrome")){
			ChromeOptions options= new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.0.72:4444"),options);
		}
		
		else if(browser.equalsIgnoreCase("Edge")){
			EdgeOptions options= new EdgeOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.0.72:4444"),options);
		}
		
		else if(browser.equalsIgnoreCase("firefox")){
			FirefoxOptions options= new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.0.72:4444"),options);
		}
	}

	@AfterMethod
	public void teardown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
}
