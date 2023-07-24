package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) {
		BrowserDriverFactory factory=new BrowserDriverFactory(browser);
		factory.createDriver();
		driver.manage().window().maximize();
}
	
	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		driver.quit();
	}
	}
