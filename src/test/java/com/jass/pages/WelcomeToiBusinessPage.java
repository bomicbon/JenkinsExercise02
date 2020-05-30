package com.jass.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jass.common.*;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WelcomeToiBusinessPage {
	private WebDriver driver;
	CommonMethods CM;
	ReadPropertyFile ReadPropertyFile;
	
	@FindBy(how=How.XPATH, using="//*[@id='bodyContent']/h1")
	private WebElement HEADER;
	
	@FindBy(linkText="log yourself in")
	private WebElement LOGYOURSELFINLINK;
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb4']/span")
	private WebElement LOGOFF;
	
	@FindBy(linkText="Password forgotten? Click here.")
	private WebElement FORGOTPASSWORD;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"columnLeft\"]/div[2]/div[2]/form/select")
	private WebElement DROPDOWN;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"tdb3\"]/span[2]")
	private WebElement CREATEACCOUNT;
	
	
	
	public WelcomeToiBusinessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		CM = new CommonMethods();
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void after() {
		driver.quit();
	}
	
	public void clickLogOff() {
		CM.click(LOGOFF);
	}
	
	public void clickLogYourselfLink() {
		CM.click(LOGYOURSELFINLINK);
	}
	
	public void clickForgotPasswordLink() {
		CM.click(FORGOTPASSWORD);
	}
	
	public void clickCreateAccount() {
		CM.click(CREATEACCOUNT);
	}
	
	public void openHomePage() {
		driver.get(ReadPropertyFile.getConfigPropertyVal("sURL"));
		CM.gotoURL("http://107.170.213.234/catalog/index.php?osCsid=rn6djqisn2i8bsigkdje2f1dv4");
	}
	
	public void verifyHeader() {
		String ExpectedText = "Welcome to iBusiness";
		CM.verifyText(HEADER, ExpectedText);
	}
	
	public void verifyErrorHeader() {
		String ExpectedText = "Error: No match for E-Mail Address and/or Password.";
		CM.verifyText(HEADER, ExpectedText);
	}
	
	public void printAllLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(WebElement link: allLinks) {
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
			CM.click(link);
		}
	}
	
	public void verifyDropDown() {
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"columnLeft\"]/div[2]/div[2]/form/select")));
		dropdown.selectByValue("Canon");
		dropdown.selectByValue("Fox");
		dropdown.selectByValue("GT Interactive");
		dropdown.selectByValue("Hewlett Packard");
		dropdown.selectByValue("Logitech");
		dropdown.selectByValue("Matrox");
		dropdown.selectByValue("Microsoft");
		dropdown.selectByValue("Samsung");
		dropdown.selectByValue("Sierra");
		dropdown.selectByValue("Warner");
	}
}

