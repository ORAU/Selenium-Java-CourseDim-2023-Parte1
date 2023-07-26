package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage {
private WebDriver driver;
private Logger log;
private By formAuthenticationLinkLocator=By.linkText("Form Authentication");
private String pageUrl="https://the-internet.herokuapp.com/";
	public WelcomePage(WebDriver driver,Logger log) {
		
		this.driver=driver;
		this.log=log;
	}
	
public void openPage() {
	
	log.info("Openning page: "+pageUrl);
	driver.get(pageUrl);
	log.info("Page opened!");
}

public LoginPage clickFormAuthenticationLink() {
	log.info("Clicking form authentication link on Welcome Page");
	driver.findElement(formAuthenticationLinkLocator).click();
	return new LoginPage(driver,log);
}
}


