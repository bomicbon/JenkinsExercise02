package com.jass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.jass.common.CommonMethods;

public class ForgotPasswordPage {
	
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
	
	@FindBy(name="Continue")
	private WebElement CONTINUE;
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb5']/span[2]")
	private WebElement SIGNIN;
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb4']/span") 
	private WebElement LOGOFF;
	
	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		CM = new CommonMethods();
	}
	
	public void enterEmail(String email) {
		CM.setValue(EMAILADDRESS, email);
		CM.click(CONTINUE);
	}
	
	public void verifyErrorHeader() {
		String ExpectedText = "Error: The E-Mail Address was not found in our records, please try again.";
		CM.verifyText(HEADER, ExpectedText);
	}
	

}
