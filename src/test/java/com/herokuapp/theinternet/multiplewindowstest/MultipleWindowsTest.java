package com.herokuapp.theinternet.multiplewindowstest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.OpeningNewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class MultipleWindowsTest extends TestUtilities {

	WelcomePage welcomePage;
	OpeningNewWindowPage openingNewWindowPage;
	NewWindowPage newWindowPage;
	@Test
	public void openNewWindowsTest() {
		
		log.info("Executing openNewWindowsTest...");
		/*
		 * Open Welcome Page*/
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();			
		/* * Select Multiple Windows Link*/
		openingNewWindowPage=welcomePage.clickOnTheOpeningNewWindowLink();
		/* Click on Click Here Button * */
		newWindowPage=openingNewWindowPage.clickOnClickHereButton();	
		openingNewWindowPage.switchToAnotherWindow();
		//openingNewWindowPage.switchToSpecificWindow("New Window");
		//Assert.assertTrue(newWindowPage.isTitleVisible(), "No se pudo encontrar el titulo en la nueva ventana");
		Assert.assertTrue(newWindowPage.getSourceCodePage().contains("New Window"), "No se pudo encontrar el titulo en la nueva ventana");
		
	}
}
