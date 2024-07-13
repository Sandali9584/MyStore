package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccount {

	//create object of webdriver
		WebDriver driver;
		
		public registeredUserAccount(WebDriver rdriver) {
			driver= rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelements
		@FindBy(xpath  = "//a[@title ='View my customer account']")
		WebElement userName;
		
		@FindBy(linkText = "Sign out")
		WebElement signOut;
		
		@FindBy(name =  "search_query")
		WebElement searchBox;
		
		@FindBy(name =  "submit_search")
		WebElement submit_search;
		
		@FindBy(linkText = "Women")
		WebElement womenMenu;
		
		@FindBy(linkText = "T-shirts")
		WebElement TshirtMenu;
		
		@FindBy(linkText = "Dresses")
		WebElement DressMenu;
		
		@FindBy(linkText = "More")
		WebElement more;
		
		public String getUserName() {
			String uname = userName.getText();
			return uname;
		}
		
		public void clickonsignout() {
			signOut.click();
		}
		
		public void EnterDataInSearchBox(String searchKey)
		{
			searchBox.sendKeys(searchKey);
		}

		public void ClickOnSearchButton()
		{
			submit_search.click();

		}

		
		public void MouseOverTShirtMenu()
		{
			Actions actions=new Actions(driver);
			actions.moveToElement(womenMenu).moveToElement(DressMenu).click().perform();
		}

}
