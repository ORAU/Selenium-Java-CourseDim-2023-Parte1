package com.herokuapp.theinternet.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

	protected WebDriver driver;
	protected Logger log;

	public BasePage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;

	}

	/* Open page with given URL */
	protected void openUrl(String url) {

		driver.get(url);
	}

	/* Find element using given locator */
	protected WebElement find(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		//return driver.findElement(locator);
	}

	/* Find several elements in the page */
	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}

	/* Click on element with given locator when its visible */
	protected void click(By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		find(locator).click();

	}

	/* Type given text into element with given locator */
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		find(locator).sendKeys(text);
	}
	/*
	 * Wait for specific ExpectedCondition for the given amount of time in seconds
	 */

	private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut) {
		timeOut = timeOut != null ? timeOut : Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(condition);
	}

	protected void waitForVisibilityOf(By locator, Duration... timeOut) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOut.length > 0 ? timeOut[0] : null));
				break;

			} catch (StaleElementReferenceException e) {

			}
			attempts++;
		}

	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public Alert getAlertWindow() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}

	public String getTextAlertWindow() {
		return driver.switchTo().alert().getText();
	}

	public void writeOnJSPromptAlert(String text) {
		driver.switchTo().alert().sendKeys(text);
	}

//My own version
	public void switchToAnotherWindow() {

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> windowsIterator = windows.iterator();
		while (windowsIterator.hasNext()) {
			driver.switchTo().window(windowsIterator.next());
			log.info("Switching to other page: " + getCurrentTitle());
		}
	}

	public void switchToSpecificWindow(String expectedWindow) {
		String firstWindowHandle = driver.getWindowHandle().toString();
		Set<String> windowsHandle = driver.getWindowHandles();
		Iterator<String> windows = windowsHandle.iterator();
		while (windows.hasNext()) {
			String currentWindow = windows.next().toString();
			if (!firstWindowHandle.equals(currentWindow)) {
				driver.switchTo().window(currentWindow);
				if (getCurrentTitle().equals(expectedWindow)) {
					break;
				}
			}

		}
	}

	public String getCurrentTitle() {
		return driver.getTitle();
	}

	public String getSourceCodePage() {
		return driver.getPageSource();
	}
	public void switchToIFrame(By iFrame) {
		driver.switchTo().frame(find(iFrame));
	}
	
	protected void typeKey(By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		find(locator).sendKeys(Keys.ENTER);
	}
	protected void typeKeyWithAction() {
		Actions action= new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}
	protected void typeKeyWithActionKey(String text) {
		Actions action= new Actions(driver);
		action.sendKeys(text).build().perform();
	}
	
	public void scrollToBottom() {
		log.info("Scrolling down to the wysswyg editor");
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	protected void dragAndDropElements(By elementA,By elementB) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(
				"function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
						+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
						+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
						+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n"
						+ "return event;\n" + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
						+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
						+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
						+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n"
						+ "}\n" + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
						+ "var dragStartEvent =createEvent('dragstart');\n"
						+ "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
						+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
						+ "var dragEndEvent = createEvent('dragend');\n"
						+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
						+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
						+ "simulateHTML5DragAndDrop(source,destination);",
				find(elementA), find(elementB));
	}
}
