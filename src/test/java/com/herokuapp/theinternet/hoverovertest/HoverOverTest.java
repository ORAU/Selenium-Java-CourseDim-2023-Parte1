package com.herokuapp.theinternet.hoverovertest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoverOverPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class HoverOverTest extends TestUtilities{

	public WelcomePage welcomePage; 
	public HoverOverPage hoverOverPage;
	@Test
	public void hoverOverTest() {
		int avatarUser=1;
		//Open WelcomePage
		log.info("Executing Hover Over test");
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on Hover page link
		hoverOverPage=welcomePage.clickHoverOverLink();
		//Hover over on i avatar (i=1,2 or 3)
		hoverOverPage.selectAvatar(avatarUser);
		//Verify page url contains: users/i 
		Assert.assertTrue(hoverOverPage.getCurrentUrl().contains("users/"+avatarUser), "The url does not contain the expected string. Actual Url: "+hoverOverPage.getCurrentUrl());
		
	}
	
}
