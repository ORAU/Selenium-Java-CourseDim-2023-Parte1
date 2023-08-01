package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private String pageUrl = "https://the-internet.herokuapp.com/";
	private By checkboxes=By.xpath("//a[contains(text(),'Checkboxes')]");
	private By dropdown=By.linkText("Dropdown");
	
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
	
	public CheckboxesPage clickOnCheckboxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkboxes);
		return new CheckboxesPage(driver,log);
	}
	
	public DropdownPage clickOnTheDropdownLink() {
		log.info("Clicking Dropdown link on Welcome Page");
		click(dropdown);
		return new DropdownPage(driver,log);
	}
}
