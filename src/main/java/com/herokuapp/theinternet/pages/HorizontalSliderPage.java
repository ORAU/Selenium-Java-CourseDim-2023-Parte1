package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePage{

	private By sliderElement= By.xpath("//input[@type='range']");
	private By sliderRange =By.id("range");
	public HorizontalSliderPage(WebDriver driver, Logger log) {
		super(driver, log);
		}

	public void dragSliderElement(double value) {
		log.info("using dragSliderElement from POO");
		dragAndDropHorizontalElement(find(sliderElement),5);
	}
	public String getSliderRangeText() {
		log.info("Getting slider range text");
		return find(sliderRange).getText();
	}
}
