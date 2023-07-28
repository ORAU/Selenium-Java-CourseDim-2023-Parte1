package com.herokuapp.theinternet.pages;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected Logger log;

	public BasePage(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;

	}
	
	/*Open page with given URL*/
	protected void openUrl(String url) {
		
		driver.get(url);
	}
	
	/*Find element using given locator*/
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}

	/*Find several elements in the page*/
	protected List<WebElement>findAll(By locator) {
	 return driver.findElements(locator);
	}
	/*Click on element with given locator when its visible*/
	protected void click(By locator) {
		waitForVisibilityOf(locator,Duration.ofSeconds(5));
		find(locator).click();
		
	}
	/*Type given text into element with given locator*/
	protected void type(String text,By locator) {
		waitForVisibilityOf(locator,Duration.ofSeconds(5));
		find(locator).sendKeys(text);
	}
	/*Wait for specific ExpectedCondition for the given amount of time in seconds*/
	
	private void waitFor(ExpectedCondition<WebElement>condition,Duration timeOut) {
		timeOut=timeOut!=null?timeOut:Duration.ofSeconds(30);
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		wait.until(condition);
	}
	
	protected void waitForVisibilityOf(By locator,Duration... timeOut) {
		int attempts=0;
		while(attempts<2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeOut.length>0?timeOut[0]:null));
				break;
				
			}
			catch(StaleElementReferenceException e) {
				
			}
			attempts++;
		}
		
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
