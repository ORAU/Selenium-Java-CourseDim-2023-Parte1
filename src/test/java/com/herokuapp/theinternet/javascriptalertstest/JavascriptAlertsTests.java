package com.herokuapp.theinternet.javascriptalertstest;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavascriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class JavascriptAlertsTests extends TestUtilities{

	private WelcomePage welcomePage;
	private JavascriptAlertsPage javascriptAlertsPage;
	private String actualResult;
@Test
public void javascriptAlertTest() {
	String expectedMessage="You successfully clicked an alert";
	log.info("Executing javascriptAlertTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsAlertButton();
	Assert.assertEquals(expectedMessage,javascriptAlertsPage.getResultText(), "The results are differents");
}

@Test
public void javascriptConfirmTest() {
	String expectedMessage="You clicked: Ok";
	log.info("Executing javascriptConfirmTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsConfirmButton();
	Assert.assertEquals(expectedMessage,javascriptAlertsPage.getResultText(), "The results are differents");
}
@Test
@Parameters("message")
public void javascriptPromptTest(String message) {
	String expectedMessage="You entered: "+message;
	log.info("Executing javascriptConfirmTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsPromptButton(message);
	Assert.assertEquals(javascriptAlertsPage.getResultText(),expectedMessage, "The results are differents");
}


}
