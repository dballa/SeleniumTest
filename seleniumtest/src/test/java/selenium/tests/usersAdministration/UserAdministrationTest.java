package selenium.tests.usersAdministration;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;
import static selenium.tests.utils.Constants.*;

import selenium.page.usersAdministration.UserAdministrationView;
import selenium.utils.DriverUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserAdministrationTest {

	public static WebDriver driver;
	
	public static UserAdministrationView userAdministrationView;
	
	
	@BeforeClass
	public static void  init() {
		driver = DriverUtil.getChromeDriver();
		try {
			userAdministrationView = new UserAdministrationView(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test1clearTest() throws InterruptedException {
		userAdministrationView.fill(WRONG_EMAIL);
		Thread.sleep(2000);
		userAdministrationView.clear();
		assertTrue(userAdministrationView.getName().getText().isEmpty());
		assertTrue(userAdministrationView.getSurname().getText().isEmpty());
		assertTrue(userAdministrationView.getEmail().getText().isEmpty());
		assertTrue(userAdministrationView.getAddress().getText().isEmpty());
		assertTrue(userAdministrationView.getPassword().getText().isEmpty());
		
	}
	
	@Test
	public void test2submitTest() throws InterruptedException{
		userAdministrationView.fill(WRONG_EMAIL);
		userAdministrationView.submit();
		Thread.sleep(1000);
		userAdministrationView.catchMessage();
		assertTrue(userAdministrationView.isMessagePresent());
	}
}
