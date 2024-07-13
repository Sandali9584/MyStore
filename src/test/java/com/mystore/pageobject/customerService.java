package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class customerService {
	//create object of webdriver
		WebDriver driver;
		
		public customerService(WebDriver rdriver) {
			driver= rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelements
		@FindBy(id = "id_contact")
		WebElement subjectheading;
		
		@FindBy(id = "email")
		WebElement emailaddress;
		
		@FindBy(name = "id_order")
		WebElement orderreference;
		
		@FindBy(id = "fileUpload")
		WebElement choosefile;
		
		@FindBy(id = "message")
		WebElement message;
		
		@FindBy(id = "submitMessage")
		WebElement submitmessage;
		
		@FindBy(xpath = "//p[@class=\"alert alert-success\"]")
		WebElement sucessAlert;
		
		@FindBy(name = "id_product")
		WebElement product;
		
		public void selectheading(String text)
		{
			Select obj = new Select(subjectheading);
			obj.selectByVisibleText(text);
		}
		
		public void enteremail(String email) {
			emailaddress.sendKeys(email);
		}
		
		public void enterorderreference(String reference) {
			orderreference.sendKeys(reference);
		}
		
		public void selectorderreference(String reference)
		{
			Select obj = new Select(orderreference);
			obj.selectByVisibleText(reference);
		}
		
		public void selectProduct(String productdetail)
		{
			Select obj = new Select(product);
			obj.selectByVisibleText(productdetail);
		}
		
		public void entermessage(String msg) {
			message.sendKeys(msg);
		}
		
		public void clicksendbtn() {
			submitmessage.click();
		}
		
		public String getOrderSucessMessage()
		{
			return(sucessAlert.getText());
		}
}
