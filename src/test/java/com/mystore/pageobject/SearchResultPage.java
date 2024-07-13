package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver driver;
	
	//create constructor
	
	public SearchResultPage(WebDriver rdriver) {
		driver= rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a")
	WebElement searchResultProduct ;
	
	@FindBy(linkText="More")
	WebElement more;
	
	//action methods on web elements of search result page
	
	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
	}
	
	public void ClickOnMoreLink()
	{
		more.click();

	}
}
