package com.herokuapp.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class NegativeTests {
	@Test
public void negativeUsernameTest() {

	//Create driver
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	String url="https://the-internet.herokuapp.com/login";
	//Open page
	System.out.println("Openning browser");
	driver.manage().window().maximize();
	driver.navigate().to(url);
	//Enter incorrect username
	WebElement username=driver.findElement(By.id("username"));
	System.out.println("Writting username");
	username.sendKeys("tommy");
	//Enter correct password
	WebElement password=driver.findElement(By.id("password"));
	System.out.println("Writting password");
	password.sendKeys("SuperSecretPassword!");
	//Click on login button
	WebElement loginBtn=driver.findElement(By.xpath("//button[@type='submit']"));
	System.out.println("Clicking login button");
	loginBtn.click();
	//Verify validation message
	WebElement alert=driver.findElement(By.xpath("//div[@id='flash']"));
	String resultMessage=alert.getText();
	String expectedMessage="Your username is invalid!";
	System.out.println("Validating results");
    Assert.assertTrue(resultMessage.contains(expectedMessage),"The result message after failed login is differente from expected. /n Actual Message: "+resultMessage+"/n Expected Message:"+expectedMessage);
    //Close the browser
    driver.quit();
	}
}
