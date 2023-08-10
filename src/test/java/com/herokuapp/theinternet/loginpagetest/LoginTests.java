package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class LoginTests extends TestUtilities {

	

	@Test(priority = 1, enabled = true, groups = { "positiveTests", "smokeTests" })
	public void loginTest() {

		/*
		 * Steps button ,logout ,sucessful login message
		 */

		// System.setProperty("user.dir",
		// "C:\\Users\\Orlan\\eclipse-workspace\\selenium-for-beginner");

		// System.setProperty("webdriver.firefox.marionette","src/main/resources/geckodriver.exe");
		// --para firefoxdriver

		log.info("Executing Login Test");
		// WebDriver driver = new FirefoxDriver();--para firefox browser
		// Open Test page
		driver.get("https://the-internet.herokuapp.com/login");
		
		// Enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		// Enter password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		// Click login
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();

		/*
		 * My version String expectedUrl="https://the-internet.herokuapp.com/secure";
		 * String resultUrl=driver.getCurrentUrl();
		 * 
		 * WebElement message=driver.findElement(By.
		 * xpath("//div[@class='flash success' and contains(text(),'You logged into a secure area!')]"
		 * )); WebElement
		 * logoutBtn=driver.findElement(By.xpath("//a[@href='/logout']"));
		 * Assert.assertTrue(expectedUrl.equals(resultUrl)&&logoutBtn.isDisplayed()&&
		 * message.isDisplayed(), "Passed Test");
		 */
		// Verificacion new url
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String resultUrl = driver.getCurrentUrl();
		Assert.assertEquals(resultUrl, expectedUrl, "The current url is not as expected");

		// Button is visible
		WebElement logoutBtn = driver.findElement(By.xpath("//a[@href='/logout']"));
		Assert.assertTrue(logoutBtn.isDisplayed(), "The logout button is not displayed");

		// sucessful login message
		WebElement messageLabel = driver.findElement(By.xpath("//div[@class='flash success']"));
		String actualMessage = messageLabel.getText();
		String expectedMessage = "You logged into a secure area!";
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Message is not as expected");

	}

	@Test(priority = 2, enabled = true, groups = { "negativeTests", "smokeTests" })
	@Parameters({ "username", "password", "expectedMessage" })
	public void negativeLoginTest(String username, String password, String expectedMessage) {

		// Create driver

		String url = "https://the-internet.herokuapp.com/login";
	
		log.info("Executing negative  Login Test");
		// Open page
		
		log.info("Openning browser");
		driver.manage().window().maximize();
		driver.navigate().to(url);
		// Enter incorrect username
		WebElement usernameElement = driver.findElement(By.id("username"));
		
		log.info("Writting username");
		usernameElement.sendKeys(username);
		// Enter correct password
		WebElement passwordElement = driver.findElement(By.id("password"));
		log.info("Writting password");
		
		passwordElement.sendKeys(password);
		// Click on login button
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		log.info("Clicking login button");
		loginBtn.click();
		// Verify validation message
		WebElement alert = driver.findElement(By.xpath("//div[@id='flash']"));
		String resultMessage = alert.getText();
		log.info("Validating results");
		
		Assert.assertTrue(resultMessage.contains(expectedMessage),
				"The result message after failed login is differente from expected. /n Actual Message: " + resultMessage
						+ "/n Expected Message:" + expectedMessage);
		// Close the browser-se ejecutara el tearDown con la anotacion de AfterMethod

	}

}
