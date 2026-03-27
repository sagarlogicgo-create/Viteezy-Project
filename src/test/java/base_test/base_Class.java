package base_test;

import java.lang.reflect.Method;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class base_Class {

	public WebDriver driver;
	String currentBrowser;

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser, Method method) throws Exception {

		currentBrowser = browser;

		System.out.println("\n====================================");
		System.out.println("🚀 START TEST: " + method.getName());
		System.out.println("🌐 Browser: " + browser);
		System.out.println("====================================");

		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.0.72:4444"), options);
		}

		else if (browser.equalsIgnoreCase("Edge")) {
			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.0.72:4444"), options);
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://192.168.0.72:4444"), options);
		}
	}

	@AfterMethod
	public void teardown(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("✅ TEST PASSED: " + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("❌ TEST FAILED: " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("⚠️ TEST SKIPPED: " + result.getName());
		}

		System.out.println("🌐 Browser used: " + currentBrowser);
		System.out.println("🛑 END TEST: " + result.getName());
		System.out.println("====================================\n");

		if (driver != null) {
			driver.quit();
		}
	}
}
