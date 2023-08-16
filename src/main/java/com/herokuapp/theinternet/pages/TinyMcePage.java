package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TinyMcePage extends BasePage {
	private By editorLocator =By.xpath("//*[@id='tinymce']/p");
	private By idFrame=By.id("mce_0_ifr");
	
	public TinyMcePage(WebDriver driver,Logger log) {
		super(driver,log);
	}
	public String getIFrameEditorText() {
		log.info("Getting text from iFrame editor");
		switchToIFrame(idFrame);
		String text=find(editorLocator).getText();
		log.info("Getting text from editor element :"+text);
		return text;
		
	}
	
}
