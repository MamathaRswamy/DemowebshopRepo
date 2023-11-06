package login;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ITestListnerUtility;
@Listeners(ITestListnerUtility.class)

public class TC_02_Test extends BaseClass {
	@Test
	public void launchingMyntra() {
		driver.navigate().to("https://www.myntra.com/");
	}

}
