package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class accountCreationDetails {

	//create object of webdriver
	WebDriver driver;
	
	//constructor
	public accountCreationDetails(WebDriver rdriver) {
		driver= rdriver;
		
		PageFactory.initElements(rdriver, this); 
	}
	
	//identify webelements
		@FindBy(id = "id_gender1")
		WebElement titleMrs;
		
		@FindBy(id = "customer_firstname")
		WebElement firstname;
		
		@FindBy(id = "customer_lastname")
		WebElement lastname;
		
		@FindBy(id = "passwd")
		WebElement password;
		
		@FindBy(id="submitAccount")
		WebElement submitbtn;
		
		//identify action to be performed on web elements
		
		public void selectTitleMrs() {
			titleMrs.click();
		}
		
		public void enterFirstname(String fname) {
			firstname.sendKeys(fname);
		}
		public void enterLastname(String lname) {
			lastname.sendKeys(lname);
		}
		public void enterpassword(String pwd) {
			password.sendKeys(pwd);
		}
		
		public void clickOnRegister() {
			submitbtn.click();
		}
}

