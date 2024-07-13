package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.pageobject.indexPage;

import junit.framework.Assert;

public class TC_HomePageTest extends BaseClass {

	@Test
	public void VerifyHomePageTitle() {
		indexPage indexPg = new indexPage(driver);
		String title = indexPg.validateLoginPageTitle();
		Assert.assertEquals(title, "My Shop");
	}
	
	@Test
	public void VerifylogoImg() {
		indexPage indexPg = new indexPage(driver);
		boolean flag = indexPg.validatelogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void VerifycontactUs() {
		indexPage indexPg = new indexPage(driver);
		boolean flag = indexPg.validatecontactus();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void Verifysignin() {
		indexPage indexPg = new indexPage(driver);
		boolean flag = indexPg.validatesignin();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void VerifywomenDressTab() {
		indexPage indexPg = new indexPage(driver);
		boolean flag = indexPg.validatewomentab();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void VerifydressTab() {
		indexPage indexPg = new indexPage(driver);
		boolean flag = indexPg.validatedresstab();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void VerifyTShirtTab() {
		indexPage indexPg = new indexPage(driver);
		boolean flag = indexPg.validatetshirttab();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void VerifyBlogTab() {
		indexPage indexPg = new indexPage(driver);
		boolean flag = indexPg.validatetblogtab();
		Assert.assertTrue(flag);
	}
	
	
}
