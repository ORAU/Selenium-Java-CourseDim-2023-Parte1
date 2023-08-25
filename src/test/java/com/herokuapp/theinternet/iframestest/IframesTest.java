package com.herokuapp.theinternet.iframestest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.TinyMcePage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class IframesTest extends TestUtilities{
	private WelcomePage welcomePage;
	private TinyMcePage tinyMcePage;
	
	@Test
	public void iFrameTest() {
		String expectedMessage="Your content goes here.";
		String actualMessage;
		log.info("Executing iFrame Test");
		//Open WelcomPage
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		
		//Scroll to the bottom
		sleep(5000);
		welcomePage.scrollToBottom();
		sleep(5000);
		//Click on WYSIWYG Editor link
		tinyMcePage=welcomePage.clickOnTheIFrameEditorLink();
		//Validate that text editor contains text: Your content goes here.
		actualMessage=tinyMcePage.getIFrameEditorText();
		Assert.assertTrue(actualMessage.equals(expectedMessage), "The messages are different , actual: "+actualMessage+" expected: "+expectedMessage);
	
	}
}
