package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpeningNewWindowPage extends BasePage{
	private By clickHereLocator=By.linkText("Click Here");
	
	public OpeningNewWindowPage(WebDriver driver,Logger log) {
		super(driver,log);
	}
	
	public NewWindowPage clickOnClickHereButton() {
		log.info("Clicking on Click Here Button");
		click(clickHereLocator);
		return new NewWindowPage(driver,log);
	}
}
