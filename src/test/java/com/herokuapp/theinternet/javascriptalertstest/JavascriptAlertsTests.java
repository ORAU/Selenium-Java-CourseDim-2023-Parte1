package com.herokuapp.theinternet.javascriptalertstest;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavascriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class JavascriptAlertsTests extends TestUtilities{

	private WelcomePage welcomePage;
	private JavascriptAlertsPage javascriptAlertsPage;
	private String actualResult;
@Test(priority=1, groups= {"regression"})
public void javascriptAlertTest() {
	SoftAssert softAssert =new SoftAssert();
	String expectedMessage="You successfully clicked an alert!";
	log.info("Executing javascriptAlertTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsAlertButton();
	sleep(3000);
	String actualMessage=javascriptAlertsPage.getTextJSAlert();
	javascriptAlertsPage.clickOnAcceptOptionJSAlert();
	softAssert.assertEquals(actualMessage,"I am a JS Alert!");
	softAssert.assertEquals(javascriptAlertsPage.getResultText(),expectedMessage, "The results are differents");
	//Assert.assertEquals(actualMessage,"I am a JS Alert!");
	//Assert.assertEquals(javascriptAlertsPage.getResultText(),expectedMessage, "The results are differents");
	 
	log.info("Finishing execution of javascriptAlertTest");
	softAssert.assertAll();

}

@Test(priority=2, groups= {"smoke"})
public void javascriptConfirmJSConfirmTest() {
	String expectedMessage="You clicked: Ok";
	log.info("Executing javascriptConfirmJSConfirmTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsConfirmButton();
	sleep(3000);
	String actualMessage=javascriptAlertsPage.getTextJSAlert();
	javascriptAlertsPage.clickOnAcceptOptionJSConfirm();
	Assert.assertEquals(actualMessage,"I am a JS Confirm");
	Assert.assertEquals(expectedMessage,javascriptAlertsPage.getResultText(), "The results are differents");
}

@Test(priority=3,groups= {"negative"})
public void javascriptCancelJSConfirmTest() {
	String expectedMessage="You clicked: Cancel";
	log.info("Executing javascriptCancelJSConfirmTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsConfirmButton();
	sleep(3000);
	String actualMessage=javascriptAlertsPage.getTextJSAlert();
	javascriptAlertsPage.clickOnCancelOptionJSConfirm();
	Assert.assertEquals(actualMessage,"I am a JS Confirm");
	Assert.assertEquals(expectedMessage,javascriptAlertsPage.getResultText(), "The results are differents");
}
@Test(priority=4,groups= {"positive"})
@Parameters("message")
public void javascriptConfirmJSPromptTest(String message) {
	String expectedMessage="You entered: "+message;
	log.info("Executing javascriptConfirmPromptTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsPromptButton();
	javascriptAlertsPage.sendTextJsPrompt(message);
	sleep(3000);
	String actualMessage=javascriptAlertsPage.getTextJSAlert();
	javascriptAlertsPage.clickOnAcceptOptionJSPrompt();
	Assert.assertEquals(actualMessage,"I am a JS prompt");
	Assert.assertEquals(javascriptAlertsPage.getResultText(),expectedMessage, "The results are differents");
}

@Test(priority=5,groups= {"negative"})
@Parameters("message")
public void javascriptCancelJSPromptTest(String message) {
	String expectedMessage="You entered: null";
	log.info("Executing javascriptCancelPromptTest");
	welcomePage=new WelcomePage(driver,log);
	welcomePage.openPage();
	javascriptAlertsPage=welcomePage.clickOnTheJavascriptAlertsLink();
	javascriptAlertsPage.clickOnJsPromptButton();
	javascriptAlertsPage.sendTextJsPrompt(message);
	sleep(3000);
	String actualMessage=javascriptAlertsPage.getTextJSAlert();
	javascriptAlertsPage.clickOnCancelOptionJSPrompt();
	
	Assert.assertEquals(actualMessage,"I am a JS prompt");
	Assert.assertEquals(javascriptAlertsPage.getResultText(),expectedMessage, "The results are differents");
}


}
