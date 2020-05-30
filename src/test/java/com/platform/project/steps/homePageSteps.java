package com.platform.project.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.jass.common.CommonMethods;
import com.jass.common.ReadPropertyFile;
import com.jass.common.ScreenCapture;
import com.jass.pages.WelcomeToiBusinessPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class homePageSteps {
	private WebDriver driver;
	CommonMethods CM;
	WelcomeToiBusinessPage WelcomePage;
	
	ReadPropertyFile ReadPropertyFile;
	
	@Before
	public void setUp() {
		CM = new CommonMethods();
		ReadPropertyFile = new ReadPropertyFile();
		String getBrowser = ReadPropertyFile.getConfigPropertyVal("sBrowserType");
		String getURL = ReadPropertyFile.getConfigPropertyVal("sURL");
		driver = CM.openBrowser(getBrowser);
	}
	
	@After
	public void tearDown() throws Exception {
		CM.closeBrowser();
	}
	
	@Given("^I open my Home Page$")
	public void openHomePage(){
		String getURL = ReadPropertyFile.getConfigPropertyVal("sURL");
		CM.gotoURL(getURL);
	}

	@Then("^Check the home page title is correct$")
	public void verifyHomePageTitle(){
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.verifyHeader();
	}

}
