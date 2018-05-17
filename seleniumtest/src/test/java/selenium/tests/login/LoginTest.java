package selenium.tests.login;

import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.PWD;
import static selenium.tests.utils.Constants.USR;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import selenium.page.login.LoginView;
import selenium.utils.DriverUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

	public static WebDriver driver;

	public static LoginView loginView;

	@BeforeClass
	public static void init() throws InterruptedException {
		driver = DriverUtil.getChromeDriver();
		loginView = new LoginView(driver);

	}

	@Test
	public void loginTest() throws InterruptedException {

		loginView.login(USR, PWD);
		assertTrue(loginView.isLoggedIn());
	}
	
	@AfterClass
	public static void close() {
		driver.quit();
	}

}
