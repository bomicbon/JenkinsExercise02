package com.jass.common;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CommonMethods {
	private WebDriver driver;
	public  Logger logger= Logger.getLogger(CommonMethods.class);
	
	public WebDriver openBrowser(String sBrowserType){
		if(sBrowserType.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\urian\\\\\\\\Documents\\\\\\\\java\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		driver=new ChromeDriver();
          logger.info("OPeninng Chrome browser");
		}else if(sBrowserType.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
			logger.info("OPeninng Firefox browser");
	
		}else if(sBrowserType.equalsIgnoreCase("remote")){
			ChromeOptions chromeOpts = new ChromeOptions();
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("goog:chromeOptions",  chromeOpts);
			cap.setCapability("browserName",  "chrome");
			String nodeURL = "http://localhost:444/wd/hub";
		}else{
			Assert.fail("Please select the browser");
		}

		//driver.manage().deleteAllCookies();    
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        driver.manage().window().maximize();  
        
        
        
        
        return driver;
	}
	
	public void gotoURL(String sURL){
		driver.get(sURL);
		logger.info("OPeninng the URL="+sURL);
	}
	
	public void closeBrowser(){
		driver.quit();
		logger.info("close browser");
	}
	
	public void setValue(WebElement slocator,String sValue){
		String Element=slocator.getText();
		try {	
			logger.info(Element + "trying to set the value");
			slocator.clear();
			slocator.sendKeys(sValue);
			logger.info(sValue + " entered");
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(Element + "field not found");
		}
	}
	
	public void click(WebElement slocator){
		try {
			
			String Element=slocator.getText();
			if ((Element.isEmpty()) || (Element==null)){
				Element=slocator.getAttribute("value");
			}
			logger.info(Element + " trying to click");

			slocator.click();
			logger.info(Element + " clicked ");
			
			//acceptPopup();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(slocator + " not clicked ");
		}
	}
	
	public void selectDropdown(WebElement sLocator, String selection) {
		try {
			Select item = new Select(sLocator);
			item.selectByVisibleText(selection);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	 public void verifyText(WebElement slocator, String ExpectedText) {
			String ActualText=slocator.getText().trim();
			ExpectedText=ExpectedText.trim();
			
		if (ExpectedText.equalsIgnoreCase(ActualText)){

			logger.info("Expected Text"+ ExpectedText +" is Verified");
			}
		else{
			logger.info(" Expected ext="+ ExpectedText +"Not Found, instead found="+ActualText);
			Assert.fail("Expected Text="+ ExpectedText +"Not Found, instead found="+ActualText);}
}	
	 
	 public void verifyText(String expected){
		 try{
			 driver.findElement(By.xpath("//*[contains(text(),'"+ expected.trim() +"')]"));
			 logger.info("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" verified");
			// return true;
		 }
		 catch(NoSuchElementException e){
			 logger.info("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
		 }
		 
	 }

}
