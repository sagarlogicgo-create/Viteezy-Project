package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkHomeelement extends login_test {
	@Test
	public void checkElement() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List quizElement = driver.findElements(By.xpath("//a[@href='/quiz']//button"));
		Assert.assertTrue(quizElement.size() > 0, "Take the Quiz button is Missing");

		/*
		 * WebElement quizElement =
		 * driver.findElement(By.xpath("//a[@href='/quiz']//button")); if
		 * (quizElement.isDisplayed()) {
		 * System.out.println("Take The Quiz Button Is Present"); } else {
		 * System.out.println("Take The Quiz Button is Not Available"); }
		 
		WebElement shopproductbutton = driver.findElement(By.xpath("//body//div//main//main//a[2]"));
		if (shopproductbutton.isDisplayed()) {
			System.out.println("Shop Product Button is available");
		} else {
			System.out.println("Shop Product Button is Not available");
		}*/
		
		List shopProductButton = driver.findElements(By.xpath("//body//div//main//main//a[2]"));
		Assert.assertTrue(shopProductButton.size()>0 , "Shop Product Button Is missing");

	}

}
