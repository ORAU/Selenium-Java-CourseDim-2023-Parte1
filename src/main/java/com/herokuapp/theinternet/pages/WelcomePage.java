package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private String pageUrl = "https://the-internet.herokuapp.com/";

	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {

		log.info("Openning page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking form authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
}
