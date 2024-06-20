package com.testNg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_usecase {

	public static WebDriver driver;

	@BeforeTest
	public static void setup() {
		driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@BeforeTest
	public static void userCrdentials() {
		driver.findElement(By.cssSelector(".ico-login")).click();
		driver.findElement(By.cssSelector("#Email")).sendKeys("adminuser@rediff.com");
		driver.findElement(By.cssSelector("#Password")).sendKeys("adminuser");
		driver.findElement(By.cssSelector(".button-1.login-button")).click();
	}

	@Test
	public static void checkUsername() {
		String ele = driver.findElement(By.cssSelector(".header-links-wrapper div:nth-of-type(1) ul a")).getText();
		Assert.assertEquals("adminuser@rediff.com", ele);
	}

	@Test
	public static void checkModule() {
		List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
		Assert.assertEquals(6, products.size());

	}

	@AfterTest
	public static void tearDown() {
		driver.quit();
	}
}
