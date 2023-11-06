package login;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class TC_05_Test extends BaseClass {
	@Test
	public void launchingAmazon() {
		driver.navigate().to("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=58355126069&hvpone=&hvptwo=&hvadid=678711876615&hvpos=&hvnetw=g&hvrand=2771409869767097021&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007768&hvtargid=kwd-10573980&hydadcr=14453_2371562");
	}

}
