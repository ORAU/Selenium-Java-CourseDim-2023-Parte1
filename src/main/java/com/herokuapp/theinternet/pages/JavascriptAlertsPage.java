package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavascriptAlertsPage extends BasePage {

	private By jsButtonAlertLocator = By.xpath("//button[@onclick='jsAlert()']");
	private By jsButtonConfirmLocator = By.xpath("//button[@onclick='jsConfirm()']");
	private By jsButtonPromptLocator = By.xpath("//button[@onclick='jsPrompt()']");
	private By resultTextLocator=By.id("result");
	public JavascriptAlertsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	public void clickOnJsAlertButton() {
		click(jsButtonAlertLocator);
		driver.switchTo().alert().accept();
	}
	public void clickOnJsConfirmButton() {
		click(jsButtonConfirmLocator);
		driver.switchTo().alert().accept();
		
	}
	public void clickOnJsPromptButton(String text) {
		
		click(jsButtonPromptLocator);
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}
	public String getResultText() {
		return find(resultTextLocator).getText();
	}

}
