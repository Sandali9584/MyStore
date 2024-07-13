package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class youraddress {

	//create object of webdriver
		WebDriver driver;
		
		public youraddress(WebDriver rdriver) {
			driver= rdriver;
			
			PageFactory.initElements(rdriver, this);
		}
		
		//identify webelements
		
		@FindBy(id = "company")
		WebElement company;
		
		@FindBy(id = "address1")
		WebElement address;
		
		@FindBy(id = "city")
		WebElement city;
		
		@FindBy(id="id_state")
		WebElement state;
		
		@FindBy(id = "postcode")
		WebElement postcode;
		
		@FindBy(id="id_country")
		WebElement country;
		
		@FindBy(id = "phone")
		WebElement phone;
		
		@FindBy(id = "phone_mobile")
		WebElement mobile;
		
		@FindBy(id = "submitAddress")
		WebElement submitaddress;
		
		//identify action on webelement
		public void entercompanyname(String companyname) {
			company.sendKeys(companyname);
		}
		
		public void enteraddress(String Address) {
			address.sendKeys(Address);
		}
		
		public void entercity(String cityname) {
			city.sendKeys(cityname);
		}
		
		public void selectState(String text)
		{
			Select obj = new Select(state);
			obj.selectByVisibleText(text);
		}
		
		public void enterpostcode(String pstcode) {
			postcode.sendKeys(pstcode);
		}
		
		public void selectCountry(String text)
		{
			Select obj = new Select(country);
			obj.selectByVisibleText(text);
		}
		
		public void enterphonenum(String phonenum) {
			phone.sendKeys(phonenum);
		}
		
		public void entermobilephonenum(String mobilephonenum) {
			mobile.sendKeys(mobilephonenum);
		}
		
		public void clickOnsubmit() {
			submitaddress.click();
		}
		
		

}
