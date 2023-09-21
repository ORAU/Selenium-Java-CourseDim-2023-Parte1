package com.herokuapp.theinternet.loginpagetest;


import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.herokuapp.theinternet.base.CsvDataProvider;
import com.herokuapp.theinternet.base.TestUtilities;

public class NegativeLoggInTests extends TestUtilities {

	@DataProvider(name="csvDataProvider")
	@Test(priority = 1 ,dataProvider="csvDataProvider" ,dataProviderClass=CsvDataProvider.class)
	public void negativeTest(Map<String,String> testData) {
		log.info("Starting negativeTest");
		//data
		String number =testData.get("number");
		String username=testData.get("username");
		String password=testData.get("password");
		String expectedErrorMessage=testData.get("expectedMessage");
		String description=testData.get("description");
		log.info("Starting new test number: "+number + " Test: "+description);
		
		
		// open main page
		String url = "http://the-internet.herokuapp.com/";
		driver.get(url);
		log.info("Main page is opened.");

		// Click on Form Authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// enter username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		// push log in button
		driver.findElement(By.className("radius")).click();

		// Verification
		String actualErrorMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
	}
}
