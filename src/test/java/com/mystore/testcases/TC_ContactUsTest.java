package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.customerService;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;

public class TC_ContactUsTest extends BaseClass{

	@Test(priority = 1)
	public void verifySendaMessagewithoutlogin() throws IOException {
		
		indexPage indexpg = new indexPage(driver);
		
		indexpg.clickOnContactUs();
		
		customerService custservicepg = new customerService(driver);
		
		custservicepg.selectheading("Customer service");
		logger.info("Select on Customer service");
		
		custservicepg.enteremail("hellotest123@gmail.com");
		logger.info("Enter Email Address");
		
		custservicepg.enterorderreference("CMIUNMWMQ");
		logger.info("Enter on Order Reference");
		
		custservicepg.entermessage("Payment by check");
		logger.info("Enter message");
		
		custservicepg.clicksendbtn();
		logger.info("Clicked on send button");
		
		String sucessMsg = custservicepg.getOrderSucessMessage();

		if(sucessMsg.equals("Your message has been successfully sent to our team."))
		{
			logger.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);

		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver,"VerifyCustomerservice");
			Assert.assertTrue(false);

		}
	}
	
	@Test(priority = 2)
	public void verifySendaMessagewithlogin() throws IOException {
		

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
		
		indexpage.clickOnContactUs();
		
		customerService custservicepg = new customerService(driver);
		
		custservicepg.selectheading("Customer service");
		logger.info("Select on Customer service");
		
		custservicepg.selectorderreference("UUTOBBSEC - 07/12/2024");
		logger.info("Select on Order Reference");
		
		custservicepg.selectProduct("Printed Dress - Size : L, Color : Beige");
		logger.info("Select on product");
		
		custservicepg.entermessage("Payment by check");
		logger.info("Enter message");
		
		custservicepg.clicksendbtn();
		logger.info("Clicked on send button");
		
		String sucessMsg = custservicepg.getOrderSucessMessage();

		if(sucessMsg.equals("Your message has been successfully sent to our team."))
		{
			logger.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);

		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver,"VerifyCustomerservice");
			Assert.assertTrue(false);

		}
	}
}
