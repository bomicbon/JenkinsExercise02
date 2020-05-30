package com.platform.project.runner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


public class AndroidBrowserTest {
	
	public WebDriver driver;
	String kobitonServerUrl = "https://svatitech:84b66fb4-d842-4faf-958d-66bd97a3118b@api.kobiton.com/wd/hub";
	String deviceName = "Galaxy S10e";
	String platformVersion = "9";
	String platformName = "Android";
	
	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureSceenshots", true);
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("deviceGroup",  "KOBITON");
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("platformName", platformName);

		driver = new AndroidDriver<WebElement>(new URL(kobitonServerUrl), capabilities);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		System.out.println("Device has been connected.");
	}
	
	@Test
	public void runTest() throws Exception{
		System.out.println("Browser Opened");
		driver.get("");
		System.out.println("Navigated to the URL");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
		System.out.println("Session has been closed.");
	}
}
