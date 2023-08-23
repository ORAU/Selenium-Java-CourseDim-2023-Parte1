package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilePage extends BasePage{

	private By fileUploaderLocator =By.id("file-upload");
	private By confirmationButtonLocator =By.id("file-submit");
	private By confirmationMessageLocator =By.xpath("//h3[contains(text(),'File Uploaded!')]");
	public UploadFilePage(WebDriver driver,Logger log) {
		super(driver,log);
	}
	public void sendFileLocationText(String fileLocation) {
		log.info("Sending file location string");
		type(fileLocation,fileUploaderLocator);
	}
	public String confirmUploadingFile() {
		log.info("Clicking on Upload button (upload confirmation)");
		click(confirmationButtonLocator);
		return find(confirmationMessageLocator).getText();
	}
}
