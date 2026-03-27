package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base_test.base_Class;

public class login_test extends base_Class {
	
	
	@Parameters("browser")
	@BeforeMethod

	public void Logintest() {

		driver.get("http://167.71.225.133:8080");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();

		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='hidden lg:block font-semibold text-gray-700 whitespace-nowrap pe-1.5']")));
		popup.click();

		WebElement email = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email'][type='email']")));
		email.sendKeys("chithhi@yopmail.com\r\n" + "");

		WebElement Pass = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
		Pass.sendKeys("Test@1234");
		driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();

		WebElement profileisdisplayed = driver.findElement(By.xpath(
				"//button[contains(@aria-label,'User menu')]//img[contains(@class,'w-full h-full object-cover')]"));
		System.out.println(profileisdisplayed.isDisplayed());
		Assert.assertTrue(profileisdisplayed.isDisplayed(), "❌ Login button is NOT displayed");
	}
}
