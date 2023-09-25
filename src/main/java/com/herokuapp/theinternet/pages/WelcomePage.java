package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
public class WelcomePage extends BasePage {

	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private String pageUrl = "https://the-internet.herokuapp.com/";
	private By checkboxes=By.xpath("//a[contains(text(),'Checkboxes')]");
	private By dropdown=By.linkText("Dropdown");
	private By jsAlerts =By.linkText("JavaScript Alerts");
	private By newWindows=By.linkText("Multiple Windows");
	private By iFrame=By.linkText("WYSIWYG Editor");
	private By keyPresses=By.linkText("Key Presses");
	private By UploadFile=By.linkText("File Upload");
	private By DragAndDrop=By.linkText("Drag and Drop");
	private By HoverOver=By.linkText("Hovers");
	private By horizontalSlider=By.linkText("Horizontal Slider");
	private By javascriptError=By.linkText("JavaScript onload event error");
	public WelcomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {

		log.info("Openning page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking form authentication link on Welcome Page");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver, log);
	}
	
	public CheckboxesPage clickOnCheckboxesLink() {
		log.info("Clicking Checkboxes link on Welcome Page");
		click(checkboxes);
		return new CheckboxesPage(driver,log);
	}
	
	public DropdownPage clickOnTheDropdownLink() {
		log.info("Clicking Dropdown link on Welcome Page");
		click(dropdown);
		return new DropdownPage(driver,log);
	}
	public JavascriptAlertsPage clickOnTheJavascriptAlertsLink() {
		log.info("Clicking Javascript Alerts link on Welcome Page");
		click(jsAlerts);
		return new JavascriptAlertsPage(driver,log);
	}
	public OpeningNewWindowPage clickOnTheOpeningNewWindowLink() {
		log.info("Clicking Opening New Window link on Welcome Page");
		click(newWindows);
		return new OpeningNewWindowPage(driver,log);
	}
	public TinyMcePage clickOnTheIFrameEditorLink() {
		log.info("Clicking Iframe Editor link on Welcome Page");
		click(iFrame);
		return new TinyMcePage(driver,log);
	}
	public KeyPressesPage clickOnTheKeyPressesLink() {
		log.info("Clicking Key Presses link on Welcome Page");
		click(keyPresses);
		return new KeyPressesPage(driver,log);
		
	}
	public UploadFilePage clickOnTheUploadFileLink() {
		log.info("Clicking Upload file link on Welcome Page");
		click(UploadFile);
		return new UploadFilePage(driver,log);
		
	}
	public DragAndDropPage clickOnTheDragAndDropLink() {
		log.info("Clicking Drag and drop link on Welcome Page");
		click(DragAndDrop);
		return new DragAndDropPage(driver,log);
		
	}

	public HoverOverPage  clickHoverOverLink() {
		log.info("Clicking Hover Over link on Welcome Page");
		click(HoverOver);
		return new HoverOverPage(driver,log);
	}

	public HorizontalSliderPage clickOnHorizontalSliderLink() {
		// TODO Auto-generated method stub
		log.info("Clicking on Horizontal Slider on Welcome Page");
		click(horizontalSlider);
		return new HorizontalSliderPage(driver,log);
	}
	
   public JavascriptErrorPage clickOnJavascriptOnloadEventErrorLink() {
	   
	   log.info("Clicking on Javascript Onload Event Error link");
	   click(javascriptError);
	   return new JavascriptErrorPage(driver,log);
   }
}
