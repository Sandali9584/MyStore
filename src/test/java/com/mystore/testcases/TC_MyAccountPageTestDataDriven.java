package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadExcelFile;


public class TC_MyAccountPageTestDataDriven extends BaseClass{

	@Test(enabled = false)
	public void verifyRegistrationAndLogin() {
		
		
		indexPage indexpage = new indexPage(driver);
		
		indexpage.clickOnSignIn();
		logger.info("Clicked on sign in link");
		
		myAccount myaccpage = new myAccount(driver);
		myaccpage.enterCreateEmail("hellotest123@gmail.com");
		logger.info("Email address entered in create account section");
		
		myaccpage.clickSubmitCreate();
		logger.info("Clicked on create an account button");
		
		accountCreationDetails accCreationPg = new accountCreationDetails(driver);
		
		accCreationPg.selectTitleMrs();
		accCreationPg.enterFirstname("Hello");
		accCreationPg.enterLastname("Test");
		accCreationPg.enterpassword("Test123");
		logger.info("Enter user details on account creation page");
		
		accCreationPg.clickOnRegister();
		logger.info("Clicked on Register button");
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		
		String username = regUser.getUserName();
		Assert.assertEquals("Hello Test", username);
		logger.info("Validate that user is created");
	}
	
	
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String userEmail, String userPwd, String expectedUsername)throws IOException {
		
		logger.info("Verify Login test execution started...");
		indexPage indexpage = new indexPage(driver);
		
		indexpage.clickOnSignIn();
		logger.info("Clicked on sign in link");
		
		myAccount myaccpage = new myAccount(driver);
		
		
		myaccpage.enterEmail(userEmail);
		logger.info("Enter Email Address");
		
		myaccpage.enterPassword(userPwd);
		logger.info("Enter password");
		
		myaccpage.clickSubmit();
		logger.info("Clicked on sign in button");
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		
		String username = regUser.getUserName();
		if(username.equals(expectedUsername)) {
			logger.info("Verify Login - Passed");
			Assert.assertTrue(true);
			regUser.clickonsignout();
			logger.info("Clicked on signout in button");
		}else {
			logger.info("Verify Login - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}
}

