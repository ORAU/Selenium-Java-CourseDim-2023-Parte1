package com.herokuapp.theinternet.horizontalslidertest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HorizontalSliderTest extends TestUtilities{

	public WelcomePage welcomePage;
	public HorizontalSliderPage horizontalSliderPage;
	
	@Test
	public void horizontalSliderTest() {
		double value=10;
		String expectedText="60";
		String actualText;
		//OPen WelcomePage
		
		log.info("Executing Horizontal Slider Test");
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on Horizontal Slider Link
		horizontalSliderPage=welcomePage.clickOnHorizontalSliderLink();
		//Drag and drop the element Horizontal Slider
		horizontalSliderPage.dragSliderElement(value);
		//Verify the value of range element
		actualText=horizontalSliderPage.getSliderRangeText();
		Assert.assertTrue(expectedText.equals(actualText),"Actual text is different from expected. Actual value: "+actualText+ " expected text: "+expectedText);
	}
}
