package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;


public class TC_MyAccountPageTest extends BaseClass{

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
	@Test
	public void verifyLogin()throws IOException {
		
		logger.info("Verify Login test execution started...");
		indexPage indexpage = new indexPage(driver);
		
		indexpage.clickOnSignIn();
		logger.info("Clicked on sign in link");
		
		myAccount myaccpage = new myAccount(driver);
		
		
		myaccpage.enterEmail("hellotest123@gmail.com");
		logger.info("Enter Email Address");
		
		myaccpage.enterPassword("Test123");
		logger.info("Enter password");
		
		myaccpage.clickSubmit();
		logger.info("Clicked on sign in button");
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		
		String username = regUser.getUserName();
		if(username.equals("Hello Test")) {
			logger.info("Verify Login - Passed");
			Assert.assertTrue(true);
		}else {
			logger.info("Verify Login - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	@Test
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccount myaccpage = new myAccount(driver);

		myaccpage.enterEmail("hellotest123@gmail.com");
		logger.info("Enter Email Address");
		
		myaccpage.enterPassword("Test123");
		logger.info("Enter password");

		myaccpage.clickSubmit();
		logger.info("Clicked on sign in link..");


		registeredUserAccount regUser = new registeredUserAccount(driver);
		regUser.clickonsignout();

		if(pg.getPageTitle().equals("Login - My Shop"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}
}

