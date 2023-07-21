package com.herokuapp.theinternet.loginpagetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;

public class PositiveLoginTests extends BaseTest {
	@Test(priority=1, enabled=true)

	public void loginTest() {

		/*
		 * Steps      
		 * button ,logout ,sucessful login message
		 */

		//System.setProperty("user.dir", "C:\\Users\\Orlan\\eclipse-workspace\\selenium-for-beginner");
		//System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.firefox.marionette","src/main/resources/geckodriver.exe");
		System.out.println("Executing Login Test");
		//Create driver
		
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().window().maximize();
	
		//Enter username
		WebElement username= driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		//Enter password
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword!");
		//Click login
		WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
		
		/* My version
		String expectedUrl="https://the-internet.herokuapp.com/secure";
		String resultUrl=driver.getCurrentUrl();
		
		WebElement message=driver.findElement(By.xpath("//div[@class='flash success' and contains(text(),'You logged into a secure area!')]"));
		WebElement logoutBtn=driver.findElement(By.xpath("//a[@href='/logout']"));
		Assert.assertTrue(expectedUrl.equals(resultUrl)&&logoutBtn.isDisplayed()&&message.isDisplayed(), "Passed Test");
		*/
		//Verificacion new url
		String expectedUrl="https://the-internet.herokuapp.com/secure";
		String resultUrl=driver.getCurrentUrl();
		System.out.println(resultUrl);
		Assert.assertEquals(resultUrl, expectedUrl, "The current url is not as expected");
		
		//Button is visible
		WebElement logoutBtn=driver.findElement(By.xpath("//a[@href='/logout']"));
		Assert.assertTrue(logoutBtn.isDisplayed(), "The logout button is not displayed");
		
		
		//sucessful login message
		WebElement messageLabel=driver.findElement(By.xpath("//div[@class='flash success']"));
		String actualMessage=messageLabel.getText();
		String expectedMessage="You logged into a secure area!";
		System.out.println(actualMessage);
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Message is not as expected");
	
		
	}
}
