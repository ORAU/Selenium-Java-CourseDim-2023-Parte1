package com.herokuapp.theinternet.base;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BrowserDriverFactory {
private ThreadLocal <WebDriver>driver=new ThreadLocal<WebDriver>();
private String browser;
private Logger log;

public BrowserDriverFactory(String browser,Logger log) {
	this.browser=browser.toLowerCase();
	this.log=log;
}

public WebDriver createDriver() {
	
	log.info("BDF-1:Creating driver: "+browser);
	switch (browser) {
	case "chrome":
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set( new ChromeDriver());
		break;
	case "firefox":
		System.setProperty("webdriver.firefox.marionette", "src/main/resources/geckodriver.exe");
		driver.set( new FirefoxDriver());
		break;
	default:
		System.out.println("No se logro establecer la conexion con el navegador:" + browser
				+ " \n se ejecutara con navegador Chrome.");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set( new ChromeDriver());
		break;
	}
	return driver.get();
}



}
