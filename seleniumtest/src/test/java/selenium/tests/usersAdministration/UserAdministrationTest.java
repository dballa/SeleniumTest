package selenium.tests.usersAdministration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.*;

import selenium.page.login.LoginView;
import selenium.page.usersAdministration.UserAdministrationView;
import selenium.utils.DriverUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserAdministrationTest {

	public static WebDriver webDriver;

	public static UserAdministrationView userAdministrationView;

	@BeforeClass
	public static void init() throws InterruptedException {
		webDriver = DriverUtil.getChromeDriver();
		
		LoginView loginView = new LoginView(webDriver);
		loginView.login(USR, PASSWORD);
		
		userAdministrationView = new UserAdministrationView(webDriver);
	}

	@Test
	public void test1clearTest() throws InterruptedException {
		userAdministrationView.fill(WRONG_EMAIL);
		Thread.sleep(2000);
		userAdministrationView.clear();
		assertTrue("One or all  the fields are  empty", userAdministrationView.fieldsAreEmpty());

	}

	@Test
	public void test2submitTest() throws InterruptedException {
		userAdministrationView.fill(WRONG_EMAIL);
		userAdministrationView.submit();
		Thread.sleep(2000);
		userAdministrationView.catchMessage();
		assertTrue(userAdministrationView.isMessagePresent());
	}
	@AfterClass
	public static void close() {
		webDriver.quit();
	}
}
