package genericUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver;
	JavascriptExecutor js;
	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor) driver;
	}
	/**
	 * This method is used to click on element using javascript executor
	 * @param element
	 */
	public void clickingOnElement(WebElement element) {	
		js.executeScript("arguments[0].click();", element);
	}
	/**
	 * This method is used to enter the data using javascript executor
	 * @param element
	 * @param data which has to enter to the element
	 */
	public void enteringDataIntoElement(WebElement element, String data) {
		js.executeScript("arguments[0].value='"+data+"'", element);
	}

	/**
	 * This method returns the reference for webdriverwait to achieve explicit wait
	 * @param time to wait
	 * @return
	 * 
	 */
	public WebDriverWait explicitWaitReference(int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait;
	}
	/**
	 * this method return the actions class reference
	 * @return
	 */

	public Actions actionsReference() {
		Actions action=new Actions(driver);
		return action;
	}
	/**
	 * This method is used to handle the dropdown
	 * @param element
	 * @param value
	 */

	public void handlingDropdown(WebElement element, String value) {
		Select select=new Select(element);
		try {
			select.selectByVisibleText(value);
		}catch (Exception e1) {
			try {
				select.selectByValue(value);
			}catch (Exception e) {
				int val=Integer.parseInt(value);
				select.selectByIndex(val);
			}
		}
	}
	/**
	 * This method is used to perfomr scroll TO action	
	 * @param x
	 * @param y
	 */
	public void scrollToAction(int x, int y) {
		js.executeScript("window.scrollTo("+x+","+y+")");
	}
	/**
	 * This method is used to perform scrllBy action
	 * @param x
	 * @param y
	 */
	public void scrollByAction(int x, int y) {
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

	/**
	 * This method is used to scroll to the element to increase the element visibility
	 * If the status is true the window will scroll untill the element reaches the top
	 * If the status is false the window will scroll untill the element reaches the bottom
	 * @param element
	 * @param status
	 */
	public void scrollIntoViewAction(WebElement element, Boolean status) {
		js.executeScript("arguments[0].scrollIntoView("+status+")",element);
	}
	/**
	 * This method is used to switch the driver control from window to frame with the help of index
	 * @param index
	 */

	public void switchingToFrame(int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the driver control from window to frame with the help of name
	 * @param name
	 */
	public void switchingToFrame(String name) {
		driver.switchTo().frame(name);
	}
	/**
	 * This method is used to switch the driver control from window to frame with the help of webelement
	 * @param element
	 */
	public void switchingToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch the driver control from frame to window
	 */
	public void switchingBackToMainWindow() {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is returning the alert reference
	 * @return
	 */
	public Alert returnAlertReference() {
		return driver.switchTo().alert();
	}
	/**
	 * This method is used to switch the driver control from one window to another window with the title reference 
	 * @param allWindowId
	 * @param expectedTitle
	 * @param parentId
	 */

	public void switchingToWindow(Set<String> allWindowId,String expectedTitle,String parentId) {
		allWindowId.remove(parentId);
		for(String id:allWindowId) {
			driver.switchTo().window(id);
			if(expectedTitle.equalsIgnoreCase(driver.getTitle())) {
				break;
			}
		}
	}

	/**
	 * This method is used to switch the control back to parent window
	 * @param parentID
	 */
	public void switchingBackToMainWindow(String parentID) {
		driver.switchTo().window(parentID);
	}
}
