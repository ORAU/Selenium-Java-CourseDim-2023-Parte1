package com.herokuapp.theinternet.javascripterrortest;

import java.util.List;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.BaseTest;
import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;

public class JavascriptErrorTests extends TestUtilities {
	WelcomePage welcomePage;

@Test
	public void javascriptLoadingPageTest() {
	SoftAssert softAssert=new SoftAssert();
		log.info("Executing javascript Loading Page Test");
		// Opening home page
		welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();
		// Clicking on Javascript error page
		welcomePage.clickOnJavascriptOnloadEventErrorLink();
		// Validating javascript error messages (using softAsserts SEVERE errors)
		List<LogEntry>logList=verifyJavascriptErrorMessages();
		for(LogEntry log:logList) {
			if(log.getLevel().toString().equals("SEVERE"))
				softAssert.fail("Severe error: "+log.getMessage());
			
		}
		softAssert.assertAll();
	}

}
