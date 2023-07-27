package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By loginButtonLocator = By.tagName("button");
	private By failedLoginMessage =By.xpath("//div[@id='flash']");
	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);

	}

	public SecureAreaPage logIn(String username, String password) {

		log.info("Executing Login with username: {" + username + "} and password: {" + password + "}");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(loginButtonLocator);
		return new SecureAreaPage(driver, log);
	}
	public void failedLogIn(String username, String password) {
		log.info("Executing Login with username: {" + username + "} and password: {" + password + "}");
		type(username, usernameLocator);
		type(password, passwordLocator);
		click(loginButtonLocator);
		
	}
	public String getFailedLoginMessage() {
		return find(failedLoginMessage).getText();
	}

}
