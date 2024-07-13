package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {
	WebDriver driver;

	//2. Create constructor
	public OrderPaymentPage(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(rdriver, this);//driver that will be used to lookup the web element

	}


	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")
	WebElement payByCheque;
	
	
	@FindBy(className ="bankwire")
	WebElement payByBankWire;
	
	public String getPageTitle()
	{
		return (driver.getCurrentUrl());
	}
	
	public void clickOnPayByCheque()
	{
		payByCheque.click();
	}

	public void clickOnPayByBankwire()
	{
		payByBankWire.click();
	}

}
