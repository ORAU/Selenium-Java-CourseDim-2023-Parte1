package com.herokuapp.theinternet.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class NegativeLoginTests extends TestUtilities{
	@Test(priority=1, enabled=true,groups = { "negativeTests", "smokeTests" })
public void negativeUsernameTest() {

		
	//Create driver
	String url="https://the-internet.herokuapp.com/login";

	log.info("Executing Negative Username Test");
	//Open page
	//System.out.println("Openning browser x");
	log.info("Openning browser");
	driver.manage().window().maximize();
	driver.navigate().to(url);
	//Enter incorrect username
	WebElement username=driver.findElement(By.id("username"));
	//System.out.println("Writting username");
	username.sendKeys("tommy");
	//Enter correct password
	WebElement password=driver.findElement(By.id("password"));
	log.info("Writting password");
	password.sendKeys("SuperSecretPassword!");
	//Click on login button
	WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
	log.info("Clicking login button");
	loginBtn.click();
	//Verify validation message
	WebElement alert=driver.findElement(By.xpath("//div[@id='flash']"));
	String resultMessage=alert.getText();
	String expectedMessage="Your username is invalid!";
	log.info("Validating results");
    Assert.assertTrue(resultMessage.contains(expectedMessage),"The result message after failed login is differente from expected. /n Actual Message: "+resultMessage+"/n Expected Message:"+expectedMessage);
    //Close the browser
    driver.quit();
	}
	@Test(priority=2, enabled=true, groups = { "negativeTests"})
	public void negativePasswordTest() {
		//Creating driver

		log.info("Executing Negative Password Test");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		
		String url="https://the-internet.herokuapp.com/login";
		//Openning page
		
		log.info("Openning page");
		driver.manage().window().maximize();
		driver.get(url);
		//Writting correct username
		
		log.info("Writting correct username");
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		//Writting incorrect password
		
		log.info("Writting incorrect password");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("otherPassword");
		//Clicking login button
	
		log.info("Clicking login button");
		WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		loginBtn.click();
		String expectedMessage="Your password is invalid!";
				
		//Verifying results

		log.info("Verifying results");
		String actualMessage=driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualMessage.contains(expectedMessage), "The actual message does not contain expected: \n Actual: "+actualMessage+" \n Expected:"+expectedMessage);
		driver.quit();
	}
}
