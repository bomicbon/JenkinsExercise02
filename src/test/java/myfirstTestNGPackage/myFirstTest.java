package myfirstTestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class myFirstTest {
	private WebDriver driver;
	public String sURL = new String("http://107.170.213.234/catalog/index.php?osCsid=rn6djqisn2i8bsigkdje2f1dv4");
	
	//DataProvider Example
	@Parameters({"sBrowserType"})
	@BeforeMethod
	public void setUp(String sBrowserType) {
		if(sBrowserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\urian\\\\Documents\\\\java\\\\chromedriver_win32\\\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("Please select the valid browser type.");
			Assert.fail();
		}
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS);
		driver.get(sURL);
	}
	@DataProvider(name="testdata")
	public Object[][] createData1() {
		return new Object[][] {
		{"ecalix@test.com", "test123"},
		{"jass@test.com", "test123"},
		};
	}
	
	@Test(dataProvider="testdata")
	public void testCase01(String emailID, String sPWD) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\urian\\Documents\\java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(sURL);
		
		driver.findElement(By.linkText("log yourself in")).click();
		driver.findElement(By.name("email_address")).sendKeys(emailID);
		driver.findElement(By.name("password")).sendKeys(sPWD);
		driver.findElement(By.xpath("//*[@id='tdb5']/span[2]")).click();
		String ExpectedResults = "Welcome to iBusiness";
		String ActualResults = driver.findElement(By.xpath("//*[@id='bodyContent']/h1")).getText();
		System.out.println("ExpectedResults is "+ExpectedResults+"\n"+"ActualResults is "+ActualResults);
		Assert.assertEquals(ActualResults, ExpectedResults);
		System.out.println(ActualResults+"is verified");
		driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		System.out.println("Click Logoff");
	}
}
