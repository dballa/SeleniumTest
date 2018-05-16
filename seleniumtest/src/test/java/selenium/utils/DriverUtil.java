package selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {
	
	//

	public static WebDriver getChromeDriver() {
		String exePath = "C:\\googleChromeDriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		return new ChromeDriver();
	}
}
