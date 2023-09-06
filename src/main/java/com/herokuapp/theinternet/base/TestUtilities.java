package com.herokuapp.theinternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest{
	
	protected void sleep (long milis) {
		
		try {
			Thread.sleep(milis);
		}
		catch(InterruptedException e ) {
			e.printStackTrace();
			
			
		}
	}
	@DataProvider(name="imageFiles")
	protected static Object[][] files() {
		return new Object[][] {
			{1,"image1.png"},
			{2,"image2.png"},
			{3,"image3.jpg"},
			{4,"image4.jpg"}
		};
		
		
	}

}
