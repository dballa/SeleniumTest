package selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StaleUtils {

	public static boolean isStale(WebElement webElement) {

		try {
			webElement.isEnabled();
			return false;
		} catch (StaleElementReferenceException exception) {

			return true;
		}

	}
	
public static WebElement returnNotStaleWebElement(WebElement webElement,By Locator,WebDriver webDriver) {
	return isStale(webElement) ? webElement = webDriver.findElement(Locator) : webElement;
}
	
}
