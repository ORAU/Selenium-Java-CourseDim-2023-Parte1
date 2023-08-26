package com.herokuapp.theinternet.draganddroptest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DragAndDropTest extends TestUtilities {
	WelcomePage welcomePage;
	DragAndDropPage dragAndDropPage;

	@Test
	public void dragAndDropTest() {
		String expectedATittle="B";
		String expectedBTittle="A";
		String actualATittle="";
		String actualBTittle="";
		//Open WelcomePage
		log.info("Executing drag and drop test");
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on Drag and Drop link
		dragAndDropPage=welcomePage.clickOnTheDragAndDropLink();
		//Drag and drop the element A(from) to B(to)
		dragAndDropPage.dragAndDropElements();
		//Verify if the elements were updated.
		actualATittle=dragAndDropPage.getElementAText();
		actualBTittle=dragAndDropPage.getElementBText();
		Assert.assertTrue(expectedATittle.equals(actualATittle), "The tittles are differents. Expected: "+expectedATittle+ " Actual: "+actualATittle);
		Assert.assertTrue(expectedBTittle.equals(actualBTittle), "The tittles are differents. Expected: "+expectedBTittle+ " Actual: "+actualBTittle);
		
	}
}
