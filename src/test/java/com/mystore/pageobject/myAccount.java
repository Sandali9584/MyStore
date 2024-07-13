package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {

	//create object of webdriver
		WebDriver driver;
		
		//constructor
		public myAccount(WebDriver rdriver) {
			driver= rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelements
		@FindBy(id = "email_create")
		WebElement createEmailId;
		
		@FindBy(id = "SubmitCreate")
		WebElement SubmitCreate;
		
		//Already registered users
		@FindBy(id = "email")
		WebElement registeredUserEmail;
		
		@FindBy(id = "passwd")
		WebElement registeredUserPwd;
		
		@FindBy(id = "SubmitLogin")
		WebElement submitLogin;
		
		//identify action on webelement
		public void enterCreateEmail(String email) {
			createEmailId.sendKeys(email);
		}

		public void clickSubmitCreate() {
			SubmitCreate.click();
		}
		
		//action methods for already registered users
		
		public void enterEmail(String email) {
			registeredUserEmail.sendKeys(email);
		}
		
		public void enterPassword(String pwd) {
			registeredUserPwd.sendKeys(pwd);
		}
		
		public void clickSubmit() {
			submitLogin.click();
		}
		
}
