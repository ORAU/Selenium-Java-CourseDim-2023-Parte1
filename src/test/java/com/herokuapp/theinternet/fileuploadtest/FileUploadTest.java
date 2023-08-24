package com.herokuapp.theinternet.fileuploadtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.UploadFilePage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class FileUploadTest extends TestUtilities {

	WelcomePage welcomePage;
	UploadFilePage uploadFilePage;
	@Test
	public void uploadFileTest() {
		String fileName="image1.png";
		String expectedMessage="File Uploaded!";
		String actualMessage;
		//Open Welcome Page
		log.info("Executing upload file test");
		welcomePage=new WelcomePage(driver,log);
		welcomePage.openPage();
		//Click on Upload File Link button
		uploadFilePage=welcomePage.clickOnTheUploadFileLink();
		//Send file location to be uploaded
		uploadFilePage.sendFileLocationText(fileName);
		//Click on Upload button
		actualMessage=uploadFilePage.confirmUploadingFile();
		//Verify confirmation message
		Assert.assertTrue(expectedMessage.equals(actualMessage), "The confirmation message is not available. An error was ocurred");
	}
}
