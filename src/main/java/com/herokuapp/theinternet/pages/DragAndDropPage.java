package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePage{
	private By elementA=By.id("column-a");
	private By elementB=By.id("column-b");
	public DragAndDropPage(WebDriver driver,Logger log) {
		
		super(driver,log);
	}
	
	public void dragAndDropElements() {
		
		dragAndDropElements(elementA,elementB);
	}
	public String getElementAText() {
		log.info("Getting element A text:");
		return find(elementA).getText();
	}
	public String getElementBText() {
		log.info("Getting element B text:");
		return find(elementB).getText();
		
	}
}

