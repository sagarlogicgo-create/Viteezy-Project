package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



import base_test.base_Class;
import utilities.testdataGenerator;

public class test_Signup extends base_Class {

	@Test
	public void signupTest() {
		driver.get("http://167.71.225.133:8080");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		WebElement Dialouge=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Close dialog']")));
		Dialouge.click();
		}
		
		catch(Exception e){
			System.out.println("Pop-up not displayed");
		}
		WebElement popup =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hidden lg:block font-semibold text-gray-700 whitespace-nowrap pe-1.5']")));
		popup.click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Create an account.']")).click();
		String firstName = testdataGenerator.generateFirstName();
		String lastName = testdataGenerator.generateLastName();
		String email = testdataGenerator.GeneraterandomEmail();
		String password = testdataGenerator.Generaterandompass();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//form[@class='w-full flex flex-col gap-4 mt-2']//input[@name='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
		
		// WebElement profileisdisplayed=driver.findElement(By.xpath("//button[contains(@aria-label,'User
		// menu')]//img[contains(@class,'w-full h-full object-cover')]"));
		// System.out.print(profileisdisplayed);
		// Assert.assertTrue(profileisdisplayed.isDisplayed(), "❌ Login button is NOT
		// displayed");

	}
	
}
