package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewWindowPage extends BasePage{

	private By titleLocator=By.xpath("//h3[contains(text(),'New Window')]");
	public NewWindowPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	public boolean isTitleVisible() {
		return find(titleLocator).isDisplayed();
	}
	

}
