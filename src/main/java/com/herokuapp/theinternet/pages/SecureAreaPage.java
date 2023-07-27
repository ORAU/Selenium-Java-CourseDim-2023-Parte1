package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

	private By logoutButton=By.xpath("//a[@href='/logout']");
	private By confirmationMessage =By.xpath("//div[@class='flash success']");
	private String pageUrl="https://the-internet.herokuapp.com/secure";
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	/*Return true if the logout button is displayed*/
	public boolean logoutButtonIsVisible() {
		
		return find(logoutButton).isDisplayed();
	}
	
	/*Return the text in confirmation Message element*/
	public String confirmationMessageText() {
		return find(confirmationMessage).getText();
	}
	public String getPageUrl(){
		return pageUrl;
	}
}
