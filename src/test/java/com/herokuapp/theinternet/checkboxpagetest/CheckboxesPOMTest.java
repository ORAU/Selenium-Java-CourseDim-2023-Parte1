package com.herokuapp.theinternet.checkboxpagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class CheckboxesPOMTest extends TestUtilities {

	private WelcomePage welcomePage;
	private CheckboxesPage checkboxesPage;
	@Test
	public void checkboxTest() {
		log.info("Executing checkboxTest");
		//Open welcome page
		welcomePage= new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on checkboxes button
		checkboxesPage=welcomePage.clickOnCheckboxesLink();
		//Select all checkboxes
		checkboxesPage.selectAllCheckboxes();
		//Verify all checkboxes are checked
		Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "No estan seleccionados todos los checkboxes");
		
	}
}
