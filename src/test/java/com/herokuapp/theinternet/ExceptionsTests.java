package com.herokuapp.theinternet;

import java.time.Duration;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("No se logro establecer la conexion con el navegador:" + browser
					+ " \n se ejecutara con navegador Chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

	}

	@Test(priority = 1, enabled = true, groups = { "positiveTests", "smokeTests" })
	public void noSuchElementExceptionTest() {

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
		// WebElement row =
		// driver.findElement(By.xpath("//div[@id='row2']/input[@type='text' and
		// @class='input-field']"));
		// Otra forma de identificar el elemento seria xpath:
		// (//input[@class='input-field'])[2]: pero es mas vulnerable
		// Agregando el explicitly wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='row2']/input")));
		// Verificacion of new row
		Assert.assertTrue(row.isDisplayed(), "The second row is not displayed");

	}
	@Test(priority = 2, enabled = true, groups = { "positiveTests", "smokeTests" })
	public void elementNotInteractableException() {
		System.out.println("Running elementNotInteractableException method");
		/*
		 * Open page 
		 * Click Add button 
		 * Wait for the second row to load 
		 * Type text into the second input field 
		 * Push Save button using locator By.name(“Save”)
		 * Verify text saved
		 */
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		driver.manage().window().maximize();
		WebElement addBtn=driver.findElement(By.id("add_btn"));
		addBtn.click();

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement row2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		row2.sendKeys("Typing text on second row");
		WebElement saveBtn=driver.findElement(By.xpath("//div[@id='row2']/button[@id='save_btn']"));
		saveBtn.click();
		WebElement confirmationLbl=driver.findElement(By.xpath("//div[@id='confirmation']"));
		String expectedMessage="Row 2 was saved";
		Assert.assertTrue(confirmationLbl.getText().contains(expectedMessage),"Row 2 was not added. \n Expected message:"+expectedMessage+"Actual message: "+confirmationLbl.getText());
	}

	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		driver.quit();
	}
}
