package login;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ITestListnerUtility;
@Listeners(ITestListnerUtility.class)
public class TC_01_Test extends BaseClass{
	@Test
public void launchingFlipkart() {
	driver.navigate().to("https://www.flipkart.com/");
}
}
