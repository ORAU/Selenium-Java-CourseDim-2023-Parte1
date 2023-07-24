package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest{
	
	protected void sleep (long milis) {
		
		try {
			Thread.sleep(milis);
		}
		catch(InterruptedException e ) {
			e.printStackTrace();
			
			
		}
	}
	

}
