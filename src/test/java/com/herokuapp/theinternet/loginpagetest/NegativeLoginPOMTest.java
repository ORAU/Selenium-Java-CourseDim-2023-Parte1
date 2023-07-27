package com.herokuapp.theinternet.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.base.TestUtilities;

public class NegativeLoginPOMTest extends TestUtilities{

	private WelcomePage welcomePage;
	private LoginPage loginPage;
	private SecureAreaPage secureAreaPage;
	private String expectedMessage;
	private String actualMessage;
	@Test(priority = 1, enabled = true, groups = { "positiveTests", "smokeTests" })
	@Parameters({"username","password","message"})
	public void negativeLoginTest(String username,String password,String message) {
		
		log.info("Executing Login POO Test");
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		loginPage=welcomePage.clickFormAuthenticationLink();
		log.info("Entering credentials into Login Page");
		loginPage.failedLogIn(username, password);
		String actualMessage=loginPage.getFailedLoginMessage();
		String expectedMessage=message;		
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Los mensajes son diferentes. Mensaje Actual:"+actualMessage+" Mensaje Esperado:"+expectedMessage);
		
	}
}
