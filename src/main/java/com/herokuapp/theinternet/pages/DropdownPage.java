package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{
	private By dropdown=By.id("dropdown");
	private Select select;
	
	public DropdownPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void selectOptionTwo() {
		select = new  Select(driver.findElement(dropdown));
		select.selectByVisibleText("Option 2");
	}

	public String getSelectedTextValue() {
		return select.getFirstSelectedOption().getText();
	}
}
