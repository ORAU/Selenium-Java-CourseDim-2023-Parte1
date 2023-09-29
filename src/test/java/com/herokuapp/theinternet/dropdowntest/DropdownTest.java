package com.herokuapp.theinternet.dropdowntest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DropdownTest extends TestUtilities{
	private WelcomePage welcomePage;
	private DropdownPage dropdownPage;
	

@Test
public void dropdownOptionTwoTest(){

	log.info("Executing Dropdown Option two test");
	welcomePage=new WelcomePage(driver,log);
	log.info("Opening Welcome Page");
	welcomePage.openPage();
	log.info("Clicking on Dropdown link");
	dropdownPage=welcomePage.clickOnTheDropdownLink();
	log.info("Selecting option two");
	dropdownPage.selectOptionTwo();
	String expectedVisibleValue="Option 2";
	log.info("Verifying results");
	Assert.assertEquals(expectedVisibleValue, dropdownPage.getSelectedTextValue());
	
}

}
