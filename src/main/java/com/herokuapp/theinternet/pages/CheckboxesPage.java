package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePage {

	private By checkboxesLocator = By.xpath("//input[@type='checkbox']");

	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);

	}
/*Check list of checkboxes and verify if unchecked*/
	public void selectAllCheckboxes() {

		log.info("Checking all unchecked checkboxes");
		List<WebElement> checkboxes = findAll(checkboxesLocator);
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
	}
	public boolean areAllCheckboxesChecked() {
		
		log.info("Verifying that all checkboxes are checked");
		boolean flag=false;
		int counter=0;
		List<WebElement> checkboxes = findAll(checkboxesLocator);
		for(WebElement checkbox:checkboxes) {
			if(checkbox.isSelected()) {
				counter++;
			}			
		}
		if(counter>0) {
			flag=true;
		}
		return flag;
	}

}
