package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePage {

	private By textLocator =By.xpath("//body");
	private By resultLocator=By.id("result");
	public KeyPressesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	public String pressAKey() {
		//log.info("Entering the selected key: "+key);
		String result="";
		log.info("Entering the selected key ");
		typeKey(textLocator);
		result=find(resultLocator).getText();
		log.info("Getting result text: "+result);
		return result;
	}
	public String pressAKeyWithAction() {
		String result="";
		log.info("Entering the selected key (static ENTER)");
		typeKeyWithAction();
		result=find(resultLocator).getText();
		log.info("Getting result text: "+result);
		return result;
		
	}
	public String pressAKeyWithActionSpecificKey(String text) {
		String result="";
		log.info("Entering the selected text (Dynamic text)");
		typeKeyWithActionKey(text);
		result=find(resultLocator).getText();
		log.info("Getting result text: "+result);
		return result;
		
	}

}
