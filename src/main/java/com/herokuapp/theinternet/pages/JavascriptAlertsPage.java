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
		log.info("Clicking On Alert Button");
		click(jsButtonAlertLocator);
	}
	public String getTextJSAlert() {
		log.info("Getting Text from Alert window");
		return getTextAlertWindow();
	}
	public void clickOnAcceptOptionJSAlert() {
		log.info("Clicking On Accept Button of JS Alert ");
		getAlertWindow().accept();
	}

	public void clickOnJsConfirmButton() {
		log.info("Clicking On Confirmation Button");
		click(jsButtonConfirmLocator);
	}
	
	public void clickOnAcceptOptionJSConfirm() {
		log.info("Clicking On Accept Button of JS Confirm ");
		getAlertWindow().accept();
		}
	
	public void clickOnCancelOptionJSConfirm() {
		log.info("Clicking On Cancel Button of JS Confirm ");
		getAlertWindow().dismiss();
		}
	
	public void clickOnJsPromptButton() {
		log.info("Clicking On Prompt Button");
		click(jsButtonPromptLocator);
	}
	
	public void sendTextJsPrompt(String text) {
		log.info("Sending text On Prompt Alert: "+text);
		writeOnJSPromptAlert(text);
	}
	
	public void clickOnAcceptOptionJSPrompt() {
		log.info("Clicking On Accept Button of JS Prompt ");
		getAlertWindow().accept();
		}
	
	public void clickOnCancelOptionJSPrompt() {
		log.info("Clicking On Cancel Button of JS Prompt ");
		getAlertWindow().dismiss();
		}
	public String getResultText() {
		return find(resultTextLocator).getText();
	}

}
