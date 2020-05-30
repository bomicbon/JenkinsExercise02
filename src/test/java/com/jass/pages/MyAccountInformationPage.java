package com.jass.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.jass.common.CommonMethods;
// Create Account -> MyAccountPage -> New Account -> MyAccountInformationPage
public class MyAccountInformationPage {
	private WebDriver driver;
	CommonMethods CM;
	
	@FindBy(how=How.XPATH, using="//*[@id='bodyContent']/h1") // HEADER
	private WebElement HEADER;
	
	@FindBy(linkText="log yourself in") // LOG IN
	private WebElement LOGYOURSELFINLINK;
	
	@FindBy(name="Continue")
	private WebElement CONTINUE;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[2]/td[2]/input")
	private WebElement GENDERMALE;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[2]/td[2]/input")
	private WebElement FIRSTNAME;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"dob\"]")
	private WebElement LASTNAME;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")
	private WebElement DATEOFBIRTH;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")
	private WebElement EMAILADDRESS;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[3]/table/tbody/tr/td[2]/input")
	private WebElement COMPANYNAME;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[4]/table/tbody/tr[1]/td[2]/input")
	private WebElement STREETADDRESS;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[4]/table/tbody/tr[2]/td[2]/input")
	private WebElement SUBURB;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[4]/table/tbody/tr[3]/td[2]/input")
	private WebElement POSTCODE;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[4]/table/tbody/tr[4]/td[2]/input")
	private WebElement CITY;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[4]/table/tbody/tr[5]/td[2]/input")
	private WebElement STATEPROVINCE;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[4]/table/tbody/tr[6]/td[2]/select")
	private WebElement COUNTRY;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[5]/table/tbody/tr[1]/td[2]/input")
	private WebElement TELEPHONENO;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[5]/table/tbody/tr[2]/td[2]/input")
	private WebElement FAXNO;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[5]/table/tbody/tr[3]/td[2]/input")
	private WebElement NEWSLETTER;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[6]/table/tbody/tr[1]/td[2]/input")
	private WebElement PASSWORD;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bodyContent\"]/form/div/div[6]/table/tbody/tr[2]/td[2]/input")
	private WebElement PASSWORDCONF;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb5']/span[2]")
	private WebElement SIGNIN;
	
	@FindBy(how=How.XPATH, using="//*[@id='tdb4']/span") 
	private WebElement LOGOFF;
	
	public MyAccountInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		CM = new CommonMethods();
	}
	
	public void fillForm() {
		CM.click(GENDERMALE);
		CM.setValue(FIRSTNAME, "Bobby");
		CM.setValue(LASTNAME, "Johnson");
		CM.setValue(DATEOFBIRTH, "07-29-1994");
		CM.setValue(EMAILADDRESS, "abcd@efg.com");
		CM.setValue(COMPANYNAME, "BIGINC");
		CM.setValue(STREETADDRESS, "9392 Alamo Dr.");
		CM.setValue(SUBURB, "SF");
		CM.setValue(POSTCODE, "99393");
		CM.setValue(CITY, "LOS ANGELES");
		CM.setValue(STATEPROVINCE, "CA");
		CM.selectDropdown(COUNTRY, "United States");
		CM.setValue(TELEPHONENO, "9259259259");
		CM.setValue(FAXNO, "293239529");
		CM.click(NEWSLETTER);
		CM.setValue(PASSWORD, "test321");
		CM.setValue(PASSWORDCONF, "test321");
		CM.click(CONTINUE);
	}
}
