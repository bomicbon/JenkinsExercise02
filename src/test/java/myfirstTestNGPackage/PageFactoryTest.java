package myfirstTestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFactoryTest {
	private WebDriver driver;
	public String sURL="http://107.170.213.234/catalog/index.php?osCsid=rn6djqisn2i8bsigkdje2f1dv4";
	
	@FindBy(how = How.LINK_TEXT, using = "log yourself in")
	private WebElement LOGYOURSELFLINK;
	
	@FindBy(how = How.NAME, using = "email_address")
	private WebElement EMAILID;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement PWD;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/h1")
	private WebElement HEADER;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tdb5']/span[2]")
	private WebElement SignIn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tdb4']/span")
	private WebElement SignOff;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",  "");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("Open Browser");
		driver.get(sURL);
		System.out.println("Open URL"+sURL);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("Browser Closed");
	}

	@Test
	public void testcase01() {
		PageFactory.initElements(driver, this);
		LOGYOURSELFLINK.click();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
