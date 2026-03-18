package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base_test.base_Class;

public class test_Signup extends base_Class {

	@Test
	public void signupTest() {
		driver.get("https://staging-v2.viteezy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
		
		WebElement popup =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hidden lg:block font-semibold text-gray-700 whitespace-nowrap pe-1.5']")));
		popup.click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Create an account.']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Bobby");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Deol");
		driver.findElement(By.xpath("//form[@class='w-full flex flex-col gap-4 mt-2']//input[@name='email']")).sendKeys("bobby@yopmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
		
	}
	
}
