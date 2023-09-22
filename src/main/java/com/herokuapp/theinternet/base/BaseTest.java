package com.herokuapp.theinternet.base;



import java.io.File;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	protected Logger log;

	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method,@Optional("chrome") String browser,ITestContext ctx) {
		String testName=ctx.getCurrentXmlTest().getName();
		log=LogManager.getLogger(testName);
		BrowserDriverFactory factory=new BrowserDriverFactory(browser,log);
		this.testName=testName;
		
		driver=factory.createDriver();
		log.info("BT-2:Creating driver: "+browser);
		driver.manage().window().maximize();
		this.testSuiteName=ctx.getSuite().getName();
		this.testMethodName=method.getName();
}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	}
