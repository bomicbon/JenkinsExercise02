package com.jass.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jass.common.CommonMethods;
import com.jass.pages.WelcomeToiBusinessPage;
import com.jass.pages.ForgotPasswordPage;
import com.jass.pages.PleaseSignInPage;
import com.jass.pages.MyAccountInformationPage;
import com.jass.pages.MyAccountPage;
import com.jass.common.ReadPropertyFile;
import com.jass.common.ScreenCapture;

public class LoginTests {
	private WebDriver driver;
	CommonMethods CM;
	WelcomeToiBusinessPage WelcomePage;
	ReadPropertyFile ReadPropertyFile;
	
	@BeforeMethod
	public void setUp() {
		CM = new CommonMethods();
		ReadPropertyFile = new ReadPropertyFile();
		String getBrowser = ReadPropertyFile.getConfigPropertyVal("sBrowserType");
		String getURL = ReadPropertyFile.getConfigPropertyVal("sURL");
		driver = CM.openBrowser(getBrowser);
		CM.gotoURL(getURL);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult it) throws Exception {
		ScreenCapture ScreenCapture = new ScreenCapture(driver);
		ScreenCapture.takeScreenShoot(it.getMethod());
		System.out.println("Screenshot captured for: "+it.getMethod()+" Failed TestCase");
		CM.closeBrowser();
	}
	
	@Test
	public void testcase01() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickLogYourselfLink();
		PleaseSignInPage SignInPage = new PleaseSignInPage(driver);
		SignInPage.Login("ecalix@test.com","test123");
		WelcomePage.verifyHeader();
		WelcomePage.clickLogOff();
	}
	
	@Test
	public void testcase02() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickLogYourselfLink();
		PleaseSignInPage SignInPage = new PleaseSignInPage(driver);
		String getBrowser = ReadPropertyFile.getConfigPropertyVal("sBrowserType");
		String getURL = ReadPropertyFile.getConfigPropertyVal("sURL");
		String getUsername = ReadPropertyFile.getConfigPropertyVal("username");
		String getPassword = ReadPropertyFile.getConfigPropertyVal("password");
		SignInPage.Login(getUsername, getPassword);
		WelcomePage.verifyHeader();
		WelcomePage.clickLogOff();
	}
	
	@Test
	public void testcase03() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickLogYourselfLink();
		PleaseSignInPage SignInPage = new PleaseSignInPage(driver);
		try {
			FileInputStream fis = new FileInputStream("/myFirstMavenProject/src/test/java/urianlee/myFirstMavenProject/excel.xlsx");
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row row = sheet.getRow(0);
			Cell cell = row.getCell(0);
			String getBrowser = cell.getStringCellValue();
			Cell cell2 = row.getCell(1);
			String getURL = cell2.getStringCellValue();
			Cell cell3 = row.getCell(2);
			String getUsername = cell3.getStringCellValue();
			Cell cell4 = row.getCell(3);
			String getPassword = cell4.getStringCellValue();
			SignInPage.Login(getUsername, getPassword);
			WelcomePage.verifyHeader();
			WelcomePage.clickLogOff();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testcase04() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickLogYourselfLink();
		PleaseSignInPage SignInPage = new PleaseSignInPage(driver);
		SignInPage.Login("ecalix@test.com","test123");
		SignInPage.Login("justagile@test.com",  "test123");
		WelcomePage.verifyHeader();
		WelcomePage.clickLogOff();
	}
	
	@Test
	public void testcase05() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickLogYourselfLink();
		PleaseSignInPage SignInPage = new PleaseSignInPage(driver);
		SignInPage.Login("blank","blank");
		WelcomePage.verifyErrorHeader();
		WelcomePage.clickLogOff();
	}
	
	@Test
	public void testcase06() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickLogYourselfLink();
		WelcomePage.clickForgotPasswordLink();
		ForgotPasswordPage fpp = new ForgotPasswordPage(driver);
		fpp.enterEmail("blank");
		fpp.verifyErrorHeader();
	}
	
	@Test
	public void testcase07() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(WebElement link: allLinks) {
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
			CM.click(link);
		}
	}
	
	@Test
	public void testcase08() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickLogYourselfLink();
		WelcomePage.verifyDropDown();
	}
	
	@Test
	public void testcase09() throws InterruptedException {
		WelcomePage = new WelcomeToiBusinessPage(driver);
		WelcomePage.clickCreateAccount();
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		myAccountPage.clickContinue();
		MyAccountInformationPage myAccountInfoPage = new MyAccountInformationPage(driver);
		myAccountInfoPage.fillForm();
	}
	
	@Test
	public void testcase10() throws InterruptedException {
		
	}
}
