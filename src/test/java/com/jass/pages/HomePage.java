package com.jass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.jass.common.CommonMethods;
import com.jass.common.ReadPropertyFile;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HomePage {
	private WebDriver driver;
	CommonMethods CM;
	ReadPropertyFile ReadPropertyFile;
	
	@FindBy(how=How.XPATH, using="//*[@id='bodyContent']/h1")
	private WebElement HEADER;
	
	@FindBy(linkText="log yourself in")
	private WebElement LOGYOURSELFINLINK;
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb4']/span")
	private WebElement LOGOFF;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		CM = new CommonMethods();
	}
	
	
	public void clickLogOff() {
		CM.click(LOGOFF);
	}
	
	public void clickLogYourselfLink() {
		CM.click(LOGYOURSELFINLINK);
	}
	
	public void openHomePage() {
		driver.get(ReadPropertyFile.getConfigPropertyVal("sURL"));
	}
	
	public void verifyHeader() {
		String ExpectedText = "Welcome to iBusiness";
		CM.verifyText(HEADER, ExpectedText);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
