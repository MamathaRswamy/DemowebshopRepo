package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class BaseClass implements IAutoConstants {
	public static WebDriver driver;
	public static TakesScreenshotUtility screenshot;
	public static WebDriverUtility webdriverUtility;
	public static ExtentTest logger;
	PropertyUtility property;
	DatabaseUtility dbUtility;
	JavaUtility javaUtility;
	public static LoginPage loginPage;
	
	@BeforeClass(alwaysRun = true)
	public void launchingBrowserAndNavigateToApp() {
		property=new PropertyUtility();		

		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			WebDriverManager.chromedriver().clearResolutionCache().setup();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(options);
		}else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(property.getDataFromPropertyFile("url"));
		webdriverUtility=new WebDriverUtility(driver);	
		dbUtility=new DatabaseUtility();
		javaUtility=new JavaUtility();

	}
	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() {	
		loginPage=new LoginPage(driver);
		screenshot=new TakesScreenshotUtility(driver);

		System.out.println("logged in to application");
	}
	@AfterMethod(alwaysRun = true)
	public void logoutFromApplication() {
		System.out.println("logged out from application");
	}
	@AfterClass(alwaysRun = true)
	public void teardownTheBrowser() {
		driver.quit();
	}
}
