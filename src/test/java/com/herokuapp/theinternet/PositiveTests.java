package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
	@Test

	public void loginTest() {

		/*
		 * Steps Create driver Open Test page Enter username Enter password Click login
		 * button Verificacion new url,logout button is visible,sucessful login message
		 */

		System.setProperty("user.dir", "C:\\Users\\Orlan\\eclipse-workspace\\selenium-for-beginner");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Orlan\\eclipse-workspace\\selenium-for-beginner\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
		
		WebElement username= driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
		String expectedUrl="https://the-internet.herokuapp.com/secure";
		String resultUrl=driver.getCurrentUrl();
		WebElement message=driver.findElement(By.xpath("//div[@class='flash success' and contains(text(),'You logged into a secure area!')]"));
		WebElement logoutBtn=driver.findElement(By.xpath("//a[@href='/logout']"));
		Assert.assertTrue(expectedUrl.equals(resultUrl)&&logoutBtn.isDisplayed()&&message.isDisplayed(), "Passed Test");
		driver.quit();
		
	}
}
