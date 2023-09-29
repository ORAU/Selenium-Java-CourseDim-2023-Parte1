package com.herokuapp.theinternet.base;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDriverFactory {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}

	public WebDriver createDriver() {

		log.info("BDF-1:Creating driver: " + browser);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		case "firefox":
			System.setProperty("webdriver.firefox.marionette", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;
		case "chromeheadless":
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver(chromeOptions));
			break;
		case "firefoxheadless":
			/*
			 * FirefoxBinary firefoxBinary=new FirefoxBinary();
			 * firefoxBinary.addCommandLineOptions("--headless"); FirefoxOptions
			 * firefoxOptions=new FirefoxOptions(); firefoxOptions.setBinary(firefoxBinary);
			 */
			System.setProperty("webdriver.firefox.marionette", "src/main/resources/geckodriver.exe");
			// Create an object of Firefox Options class
			FirefoxOptions options = new FirefoxOptions();
			log.info("Creating firefox");
			// Set Firefox Headless mode as TRUE
			options.addArguments("--headless");
			//options.setHeadless(true);
			driver.set(new FirefoxDriver(options));
			break;

		case "phantomjs":
			DesiredCapabilities caps = new DesiredCapabilities();	
			caps.setCapability("phantomjs.binary.path", "src/main/resources/phantomjs.exe");  
			((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "src/main/resources/phantomjs.exe");
		    
			//System.setProperty("phantomjs.binary.path", "src/main/resources/phantomjs.exe");
			driver.set(new PhantomJSDriver(caps));
			break;
			
		case "htmlunit":
			driver.set(new HtmlUnitDriver());
			break;
		default:
			System.out.println("No se logro establecer la conexion con el navegador:" + browser
					+ " \n se ejecutara con navegador Chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		return driver.get();
	}

	public WebDriver createDriverWithProfile(String profile) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=src/main/resources/Profiles/" + profile);
		log.info("BDF-3:Creating driver: " + browser + " using profile: " + profile);
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		options.addArguments("--start-maximized");
		options.addArguments("--remote-debugging-port=9222");
		// options.addArguments("--headless=new");
		driver.set(new ChromeDriver(options));
		log.info("BDF-3:Creating driver");
		return driver.get();

	}

	public WebDriver createChromeWithMobileEmulation(String deviceName) {

		log.info("Starting browser with " + deviceName + " name emulation.");
		HashMap<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", deviceName);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		// chromeOptions.setExperimentalOption("excludeSwitches", new
		// String[]{"enable-automation"});
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver.set(new ChromeDriver(chromeOptions));
		return driver.get();
	}

}
