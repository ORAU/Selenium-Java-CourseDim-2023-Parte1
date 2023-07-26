package com.herokuapp.theinternet.loginpagetest;

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

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.TestUtilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExceptionsTests extends TestUtilities{
	


	@Test(priority = 1, enabled = true, groups = { "positiveTests", "smokeTests" })
	public void noSuchElementExceptionTest() {

		/*
		 * Steps open page, click on Add button, validate second row is displayed
		 */

		//
	
		log.info("Executing no Such Element Exceptions Test");
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
		WebElement row = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		// Verificacion of new row
		Assert.assertTrue(row.isDisplayed(), "The second row is not displayed");

	}

	@Test(priority = 2, enabled = true, groups = { "positiveTests", "smokeTests" })
	public void elementNotInteractableException() {
		//System.out.println("Running elementNotInteractableException method");
		/*
		 * Open page Click Add button Wait for the second row to load Type text into the
		 * second input field Push Save button using locator By.name(“Save”) Verify text
		 * saved
		 */
		log.info("Executing element not interacable Exceptions Test");
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		driver.manage().window().maximize();
		WebElement addBtn = driver.findElement(By.id("add_btn"));
		addBtn.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement row2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		row2.sendKeys("Typing text on second row");
		WebElement saveBtn = driver.findElement(By.xpath("//div[@id='row2']/button[@id='save_btn']"));
		saveBtn.click();
		WebElement confirmationLbl = driver.findElement(By.xpath("//div[@id='confirmation']"));
		String expectedMessage = "Row 2 was saved";
		Assert.assertTrue(confirmationLbl.getText().contains(expectedMessage),
				"Row 2 was not added. \n Expected message:" + expectedMessage + "Actual message: "
						+ confirmationLbl.getText());
	}

	@Test(priority=3,groups= {"positiveTests","smokeTests"},enabled=true)
	public void invalidElementStateExceptionTest() {

	
		log.info("Executing invalidElementStateExceptionTest");
		/*
		 * Open page 
		 * Clear input field 
		 * Type text into the input field 
		 * Verify text changed
		 */
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		driver.manage().window().maximize();
		//WebElement row1Txt = driver.findElement(By.xpath("//input[@class='input-field']"));
		
		WebElement editBtn= driver.findElement(By.id("edit_btn"));
		editBtn.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement row1Txt=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='input-field']")));
		row1Txt.clear();
		String text="Testing text field";
		row1Txt.sendKeys(text);
		String value=row1Txt.getAttribute("value");
		WebElement saveBtn =driver.findElement(By.id("save_btn"));
		saveBtn.click();
		//WebElement confirmationMsg =driver.findElement();
		WebElement confirmationMsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='confirmation']")));
		String confirmationText=confirmationMsg.getText();
		String expectedConfirmationMsg="Row 1 was saved";
		Assert.assertEquals(value, text,"Value of input field has not changed: Actual"+value+"expected: "+text);
		Assert.assertEquals(confirmationText, expectedConfirmationMsg,"Field was not modified");
		
		
	}

	@Test (enabled=true,priority=4,groups= {"positiveTests","smokeTests"})
	public void staleElementReferenceExceptionTest() {
		/*Open page
		Find the instructions text element
		Push add button
		Verify instruction text element is no longer displayed	*/
		log.info("Executing staleElementReferenceExceptionTest");
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		WebElement addBtn=driver.findElement(By.id("add_btn"));
		//addBtn.click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("instructions"))),"Element is displayed");
		
	}

}
