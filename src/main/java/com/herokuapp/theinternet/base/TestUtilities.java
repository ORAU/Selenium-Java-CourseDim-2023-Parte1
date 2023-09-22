package com.herokuapp.theinternet.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.TakesScreenshot;
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
	protected void takeScreenshot(String filename) {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+
				File.separator+"test-output"
				+File.separator+"screenshots"
				+File.separator+getTodaysDate() 
				+File.separator+ testSuiteName
				+File.separator+ testName
				+File.separator+ testMethodName
				+File.separator+ getSystemTime() 
				+" "+filename+".png";
	log.info("Tomando captura en ruta de archivo: "+path);
	
	try {
		FileUtils.copyFile(srcFile,new File(path));
	}
	catch(IOException e) {
		e.printStackTrace();
	}

	}
	
	private static String getTodaysDate()
	{
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}
	
	private static String getSystemTime()	{
		return (new SimpleDateFormat("hhmm").format(new Date()));
	}
	
}
