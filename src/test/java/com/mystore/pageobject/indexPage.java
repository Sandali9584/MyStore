package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	//create object of webdriver
	WebDriver driver;
	
	public indexPage(WebDriver rdriver) {
		driver= rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelements
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(linkText = "Sign in")
	WebElement signin;
	
	@FindBy(linkText = "Contact us")
	WebElement contactus;
	
	@FindBy(linkText = "Cart")
	WebElement cart;
	
	@FindBy(linkText="Women")
	WebElement womenMenu;
	
	@FindBy(linkText ="Dresses")
	WebElement dressesMenu;
	
	@FindBy(linkText ="T-shirts")
	WebElement shirtMenu;
	
	@FindBy(linkText ="Blog")
	WebElement blogMenu;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	WebElement tshirtMenu;
	
	//identify action on webelement
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatelogo() {
		return logo.isDisplayed();
	}
	
	public boolean validatecontactus() {
		return contactus.isDisplayed();
	}
	
	public boolean validatesignin() {
		return signin.isDisplayed();
	}
	
	public boolean validatewomentab() {
		return womenMenu.isDisplayed();
	}
	
	public boolean validatedresstab() {
		return dressesMenu.isDisplayed();
	}
	
	public boolean validatetblogtab() {
		return blogMenu.isDisplayed();
	}
	
	public boolean validatetshirttab() {
		return shirtMenu.isDisplayed();
	}
	
	public void clickOnSignIn() {
		signin.click();
	}
	
	public void clickOnTShirtMenu()
	{
		tshirtMenu.click();
	}
	
	public void clickOnContactUs()
	{
		contactus.click();
	}
	public String getPageTitle()
	{
		return(driver.getTitle());
	}
}
