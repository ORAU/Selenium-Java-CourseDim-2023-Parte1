package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverOverPage extends BasePage {
	private By avatarUsers = By.xpath("//div[@class='figure']");
	private By avatarViewProfile=By.xpath(".//a[contains(text(),'View profile')]");

	public HoverOverPage(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}

	public void selectAvatar(int avatar) {
		log.info("Selecting Avatar");
		 List<WebElement> avatars=findAll(avatarUsers);
		 WebElement selectedAvatar=avatars.get(avatar-1);
		hoverOverElement(selectedAvatar);
		selectedAvatar.findElement(avatarViewProfile).click();
	}

}
