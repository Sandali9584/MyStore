package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.OrderAddressPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

public class TC_ProductPageTest extends BaseClass {
	
	@Test(priority = 1)
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "Dress";
		logger.info("\n***************TestCase Search Product started*****************"); 

		//Sign in 
		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnSignIn();


		//Enter account details- email and password
myAccount myaccpage = new myAccount(driver);
		
		
		myaccpage.enterEmail("hellotest123@gmail.com");
		logger.info("Enter Email Address");
		
		myaccpage.enterPassword("Test123");
		logger.info("Enter password");
		
		myaccpage.clickSubmit();
		logger.info("Clicked on sign in button");

		//Enter searchkey in search box
		registeredUserAccount productPg = new registeredUserAccount(driver);
		productPg.EnterDataInSearchBox(searchKey);
		productPg.ClickOnSearchButton();

		// Get Name of Searched Product
		SearchResultPage resultPg = new SearchResultPage(driver);

		String SearchResultProductname=resultPg.getSearchResultProductName();


		//Verify that correct Product is displaying after search

		if(SearchResultProductname.contains(searchKey))
		{
			logger.info("Search Product testcase - Passed"); 
			Assert.assertTrue(true);

			productPg.clickonsignout();

		}
		else
		{
			logger.info("Search Product testcase - Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase Search Product ends*****************"); 

	}


	@Test(priority = 2)
	public void VerifyBuyProduct() throws IOException
	{

		logger.info("\n***************TestCase Buy Product started*****************"); 

		/*	driver.get(url);
		logger.info("Url opened");*/

		//Sign in 
		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnSignIn();


		//Enter account details- email and password
myAccount myaccpage = new myAccount(driver);
		
		
		myaccpage.enterEmail("hellotest123@gmail.com");
		logger.info("Enter Email Address");
		
		myaccpage.enterPassword("Test123");
		logger.info("Enter password");
		
		myaccpage.clickSubmit();
		logger.info("Clicked on sign in button");

		registeredUserAccount prodCatPg = new registeredUserAccount(driver);
		prodCatPg.EnterDataInSearchBox("Dress");
		logger.info("Dress entered in search box");

		prodCatPg.ClickOnSearchButton();
		logger.info("clicked on search button");

		SearchResultPage searchResultPg = new SearchResultPage(driver);
		searchResultPg.ClickOnMoreLink();
		logger.info("Clicked on more button");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		ProductPage prodPg = new ProductPage(driver);
		//prodPg.setQuantity("1");
		//logger.info("quantity 2 entereed");

		prodPg.setSize("L");
		logger.info("size L entered");

		prodPg.clickOnAddToCart();
		logger.info("Clicked on add to cart");

		prodPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on product page");


		OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
		orderSumPg.cickOnProceedToCheckout(); 
		logger.info("Clicked on proceed to checkout on order summary page");

		OrderAddressPage orderAddPg = new OrderAddressPage(driver);
		orderAddPg.cickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order address page");

		OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
		orderShippingPg.selectTermsOfServices();
		logger.info("selecged term of service check box");

		orderShippingPg.cickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order shipping page");

		OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
		logger.info(orderPaymentPg.getPageTitle());

		orderPaymentPg.clickOnPayByCheque();
		logger.info("Clicked on pay by cheque");

		OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
		orderConfirmPg.cickOnConfirmOrder();

		logger.info("Clicked on confirmed order");

		String sucessMsg = orderConfirmPg.getOrderSucessMessage();

		//	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

		if(sucessMsg.equals("Your order on My Shop is complete."))
		{
			logger.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);

			orderConfirmPg.clickOnSignOut();

		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver,"VerifyBuyProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase BuyProduct ends*****************"); 

	}


	@Test(priority = 3)
	public void verifyAddToWishlistWithoutLogin() throws IOException
	{
		logger.info("\n***************TestCase verifyAddToWishlistWithoutLogin started*****************"); 

		indexPage indexPage = new indexPage(driver);
		indexPage.clickOnTShirtMenu();

		ProductPage prodPage = new ProductPage(driver);
		prodPage.mouseOverOnTshirtProduct();

		prodPage.clickOnAddToWishList();

		String actualAlertMsg = prodPage.getTextOfAlertForWishList();
		String expectedAlertMsg = "You must be logged in to manage your wishlist.";

		if(actualAlertMsg.equals(expectedAlertMsg))
		{
			logger.info("verifyAddToWishlistWithoutLogin - passed"); 
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verifyAddToWishlistWithoutLogin - failed"); 
			captureScreenShot(driver,"verifyAddToWishlistWithoutLogin");
			Assert.assertTrue(false);
		}

	}
}
