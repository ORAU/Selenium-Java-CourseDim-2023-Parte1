package com.herokuapp.theinternet.loginpagetest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.base.TestUtilities;

public class LoginPOMTest extends TestUtilities{

	private WelcomePage welcomePage;
	private LoginPage loginPage;
	private SecureAreaPage secureAreaPage;
	private String expectedMessage;
	private String actualMessage;
	@Test(priority = 1, enabled = true, groups = { "positiveTests", "smokeTests" })
	@Parameters({"username","password"})
	public void loginTest(String username,String password) {
		
		log.info("Executing Login POO Test");
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		loginPage=welcomePage.clickFormAuthenticationLink();
		log.info("Entering credentials into Login Page");
		secureAreaPage=loginPage.logIn(username, password);
		String actualUrl = secureAreaPage.getPageUrl();
		String expectedUrl=secureAreaPage.getCurrentUrl();
		Assert.assertTrue(expectedUrl.equals(actualUrl),"La URL es diferente a la esperada: Actual:"+actualUrl+" Expected: "+expectedUrl);
		Assert.assertTrue(secureAreaPage.logoutButtonIsVisible(), "El elemento no se encuentra visible");
		expectedMessage="You logged into a secure area!";
		actualMessage=secureAreaPage.confirmationMessageText();
		Assert.assertTrue(actualMessage.contains(expectedMessage), "Los mensajes son diferentes. Mensaje Actual:"+actualMessage+" Mensaje Esperado:"+expectedMessage);
		
	}
}
