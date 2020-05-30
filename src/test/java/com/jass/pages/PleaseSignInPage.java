package com.jass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.jass.common.CommonMethods;

public class PleaseSignInPage {
	private WebDriver driver;
	CommonMethods CM;
	
	@FindBy(how=How.XPATH, using="//*[@id='bodyContent']/h1") // HEADER
	private WebElement HEADER;
	
	@FindBy(linkText="log yourself in") // LOG IN
	private WebElement LOGYOURSELFINLINK;
	
	@FindBy(name="email_address") // EMAIL ADDRESS
	private WebElement EMAILADDRESS;
	
	@FindBy(name="password") // PASSWORD
	private WebElement PASSWORD;
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb5']/span[2]")
	private WebElement SIGNIN;
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb4']/span") 
	private WebElement LOGOFF;
	
	public PleaseSignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		CM = new CommonMethods();
	}
	
	public void Login(String email, String password) {
		CM.setValue(EMAILADDRESS, email);
		CM.setValue(PASSWORD, password);
		CM.click(SIGNIN);
	}
	
}

