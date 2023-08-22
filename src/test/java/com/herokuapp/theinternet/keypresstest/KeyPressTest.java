package com.herokuapp.theinternet.keypresstest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class KeyPressTest extends TestUtilities{

	private WelcomePage welcomePage;
	private KeyPressesPage keyPressesPage;
	
	@Test
	public void keyPressedTest() {
		String result;
		String expected="You entered: ENTER";
		log.info("Executing Key Pressed Test");
		//Open Welcome Page
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on Key Presses Link
		keyPressesPage=welcomePage.clickOnTheKeyPressesLink();
		//Press ENTER Button
		result=keyPressesPage.pressAKey();
		//Verify confirmation message is displayed
		Assert.assertTrue(expected.equals(result),"The strings are different. Actual: "+result+" Expected: "+expected);
	}
	@Test
	public void keyPressedWithActionTest() {
		String result;
		String expected="You entered: ENTER";
		log.info("Executing Key Pressed Test");
		//Open Welcome Page
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on Key Presses Link
		keyPressesPage=welcomePage.clickOnTheKeyPressesLink();
		//Press ENTER Button
		result=keyPressesPage.pressAKeyWithAction();
		//Verify confirmation message is displayed
		Assert.assertTrue(expected.equals(result),"The strings are different. Actual: "+result+" Expected: "+expected);
	}
	@Test
	@Parameters("text")
	public void keyPressedWithActionSpecificKeyTest(String text) {
		String result;
		String expected="You entered: "+text;
		log.info("Executing Key Pressed Test with Actions Class and specific Key");
		//Open Welcome Page
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on Key Presses Link
		keyPressesPage=welcomePage.clickOnTheKeyPressesLink();
		//Press ENTER Button
		result=keyPressesPage.pressAKeyWithActionSpecificKey(text);
		//Verify confirmation message is displayed
		Assert.assertTrue(expected.equals(result),"The strings are different. Actual: "+result+" Expected: "+expected);
	}
}
