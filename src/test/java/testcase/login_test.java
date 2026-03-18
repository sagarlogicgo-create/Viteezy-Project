package testcase;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base_test.base_Class;

public class login_test extends base_Class {
		
	
	
@Test

public void Logintest() {
		
	driver.get("https://staging-v2.viteezy.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//Thread.sleep(3000);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
	
	WebElement popup =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hidden lg:block font-semibold text-gray-700 whitespace-nowrap pe-1.5']")));
	popup.click();
	
	
	WebElement email=wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email'][type='email']")));
	email.sendKeys("chithhi@yopmail.com\r\n"
			+ "");
	
	WebElement Pass=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
	Pass.sendKeys("11111111");
	driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();

	
	
}
}
