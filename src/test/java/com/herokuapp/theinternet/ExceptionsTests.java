package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExceptionsTests {
	private WebDriver driver;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	private void setUp(@Optional("chrome") String browser) {

		// Create driver
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.marionette", "src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("No se logro establecer la conexion con el navegador:"+browser+" \n se ejecutara con navegador Chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		

	}

	@Test(priority = 1, enabled = true, groups = { "positiveTests", "smokeTests" })
	public void homeworkTest() {

		/*
		 * Steps open page, click on Add button, validate second row is displayed
		 */

	
		//
		System.out.println("Executing HomeWork Test");
        // Open Test page
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		driver.manage().window().maximize();

		// Click Add button
		WebElement addBtn = driver.findElement(By.id("add_btn"));
		addBtn.click();

		// Find second row elemnent
		WebElement row = driver.findElement(By.xpath("//div[@id='row2']/input[@type='text' and @class='input-field']"));
		//Otra forma de identificar el elemento seria xpath: (//input[@class='input-field'])[2]: pero es mas vulnerable
		
		// Verificacion of new row
		Assert.assertTrue(row.isDisplayed(), "The second row is not displayed");

		
	}

	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		driver.quit();
	}
}
